package com.ocelot.xssf;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class ExampleEventUserModel {
    public void processOneSheet(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();
        XMLReader parser = fetchSheetParser(sst);

        // To look up the Sheet Name / Sheet Order / rID,
        //  you need to process the core Workbook stream.
        // Normally it's of the form rId# or rSheet#
        InputStream sheet2 = r.getSheet("rId2");
        InputSource sheetSource = new InputSource(sheet2);
        parser.parse(sheetSource);
        sheet2.close();
    }

    public void processAllSheets(InputStream in) throws Exception {
        OPCPackage pkg = OPCPackage.open(in);
        XSSFReader r = new XSSFReader(pkg);

        // parse workbook
        WorkbookHandler handler = WorkbookHandler.newInstance();
        XMLReader workbookReader = fetchWorkbookParser(handler);
        workbookReader.parse(new InputSource(r.getWorkbookData()));
        List<SheetEntity> sheetEntities = handler.getSheets();

        SharedStringsTable sst = r.getSharedStringsTable();
        XMLReader parser = fetchSheetParser(sst);


        // 操作多个sheet
//        Iterator<InputStream> sheets = r.getSheetsData();
//        while (sheets.hasNext()) {
//            System.out.println("Processing new sheet:\n");
//            InputStream sheet = sheets.next();
//            InputSource sheetSource = new InputSource(sheet);
//            parser.parse(sheetSource);
//            sheet.close();
//            System.out.println("");
//        }
    }

    public XMLReader fetchWorkbookParser(WorkbookHandler handler) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "org.apache.xerces.parsers.SAXParser"
                );
        parser.setContentHandler(handler);
        return parser;
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "org.apache.xerces.parsers.SAXParser"
                );
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }

    public static void main(String[] args) throws Exception {
        ExampleEventUserModel example = new ExampleEventUserModel();
        String path = "/Users/gaoxiang/Desktop/cc.xlsx";
//        example.processOneSheet(path);
        FileInputStream file = new FileInputStream(path);
        example.processAllSheets(file);
    }
}
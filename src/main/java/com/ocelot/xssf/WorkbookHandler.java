package com.ocelot.xssf;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

public class WorkbookHandler extends DefaultHandler {

    private List<SheetEntity> sheets = new LinkedList<>();

    public static WorkbookHandler newInstance() {
        return new WorkbookHandler();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("sheet")) {
            String name = attributes.getValue("name");
            String rId = attributes.getValue("r:id");
            sheets.add(new SheetEntity(name, rId));
        }
    }

    public List<SheetEntity> getSheets() {
        return this.sheets;
    }

}
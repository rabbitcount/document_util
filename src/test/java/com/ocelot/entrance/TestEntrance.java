package com.ocelot.entrance;

public class TestEntrance {






}

//    public static void userModel() {
//        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
//        XSSFSheet sheet = wb.getSheetAt(0);
//        Iterator<Row> iterator = sheet.iterator();
//        boolean isfirstline = true;
//        while (iterator.hasNext()) {
//            Row row = iterator.next();
//            if (isfirstline) { // 忽略上传文件第一行的标题栏
//                isfirstline = false;
//                continue;
//            }
//            //解析excel，每行有11列，然后对每列解析出来之后调用后端服务把数据保存到数据库中，
//        }
//    }
//
//    public static void eventModel() {
//        new ExcelEventUserModelParse(filePath)
//                .setHandler(new ExcelEventUserModelParse.SimpleSheetContentsHandler() {
//                    @Override
//                    public void endRow(int rowNum) {
//                        // System.out.println(row.toString());
//                        if (!isEmpty.getIsEmpty()) {
//                            table.add(row);
//                        } else {
//                            isnull.setIsEmpty(isEmpty.getIsEmpty());
//                            isnull.setRowNum(isEmpty.getRowNum());
//                        }
//                    }
//                }).parse();
//    }

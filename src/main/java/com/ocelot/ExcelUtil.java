package com.ocelot;

import com.ocelot.constant.CellInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ExcelUtil {

    public <T> void streamParse(InputStream in) {

    }



//    private static Object getValue(Class<?> fieldType, Cell cell, CellInfo filedExcelAnnotation) throws ParseException {
//        if (fieldType.isAssignableFrom(String.class)) {
//            return CellConvert.getString(cell);
//        }
//        if (fieldType.isAssignableFrom(Byte.class)) {
//            return CellConvert.geByte(cell);
//        }
//        if (fieldType.isAssignableFrom(Integer.class)) {
//            return CellConvert.getInteger(cell);
//        }
//        if (fieldType.isAssignableFrom(Float.class)) {
//            return CellConvert.getFloat(cell);
//        }
//        if (fieldType.isAssignableFrom(Double.class)) {
//            return CellConvert.getDouble(cell);
//        }
//        if (fieldType.isAssignableFrom(Short.class)) {
//            return CellConvert.getShort(cell);
//        }
//        if (fieldType.isAssignableFrom(Long.class)) {
//            return CellConvert.getLong(cell);
//        }
//        if (fieldType.isAssignableFrom(Boolean.class)) {
//            return CellConvert.getBoolean(cell);
//        }
//        if (fieldType.isAssignableFrom(Date.class)) {
//            return CellConvert.getDate(cell, filedExcelAnnotation.format());
//        }
//        throw new RuntimeException(String.format(" field (%s) is not support field =%S", filedExcelAnnotation.name(), fieldType.getName()));
//    }
}

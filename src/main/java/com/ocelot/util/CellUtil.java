package com.ocelot.util;

import com.ocelot.constant.CellInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class CellUtil {

    public <T> T convert(Class<T> targetClazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        // 处理父级
        Field[] fields = targetClazz.getDeclaredFields();
//        Field[] fields = new Field[]{};
//        Class temp = targetClazz;
//        while(temp != null){
//            fields = ArrayUtils.addAll(temp.getDeclaredFields(),fields);
//            temp = temp.getSuperclass();
//        }
        T target = targetClazz.newInstance();
        for (Field field : fields) {
            CellInfo cellInfo = getCellInfo(field.getAnnotations());
            if (Objects.isNull(cellInfo)) {
                continue;
            }
            Class<?> fieldType = field.getType();
            Integer index = cellInfo.index();
            String propertyName = field.getName();
            Object value = null; // getValue(fieldType, row.getCell(index), filedExcelAnnotation);
            if (value != null) {
                BeanUtils.setProperty(target, propertyName, value);
            }
        }
        return target;
    }

    private CellInfo getCellInfo(Annotation[] sources) {
        if (ArrayUtils.isEmpty(sources)) {
            return null;
        }
        for (Annotation source : sources) {
            if (source instanceof CellInfo) {
                return (CellInfo) source;
            }
        }
        return null;
    }
}

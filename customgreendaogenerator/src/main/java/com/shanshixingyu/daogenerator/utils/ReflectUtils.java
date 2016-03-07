package com.shanshixingyu.daogenerator.utils;

import java.lang.reflect.Field;

/**
 * @author hwz on 2016-03-07.
 */
public class ReflectUtils {

    public static boolean setFieldValue(Object obj, String attributeName, Object value) {
        if (obj == null || attributeName == null || attributeName.trim().length() <= 0) {
            return false;
        }

        boolean success = false;
        try {
            Class clazz = obj.getClass();
            Class superClazz = clazz.getSuperclass();
            Field field = superClazz.getDeclaredField(attributeName);
            field.setAccessible(true);
            field.set(obj, value);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

}

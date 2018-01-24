package com.fengzhuo.tudou.ms.common;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
    private final static Logger log = Logger.getLogger(ReflectUtil.class);

    public static void setValue(Class cls, Object instance, String fieldName, String value) {
        if (cls == null || StringUtil.isEmpty(fieldName) || StringUtil.isEmpty(value)) {
            return;
        }
        try {
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            Class<?> fileType = field.getType();
            Object setValue = value;
            if (fileType != String.class) {
                Method valueOf = fileType.getMethod("valueOf", String.class);
                setValue = valueOf.invoke(String.class, value);
            }
            field.set(instance == null ? cls : instance, setValue);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public static Object getField(Class clazz, Object o, String fieldName, Object defaultVal) {
        if (clazz == null || o == null || StringUtil.isEmpty(fieldName)) {
            return defaultVal;
        }
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(o);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
        try {
            Method method = clazz.getMethod("get" + StringUtil.firstCharUpperCase(fieldName));
            return method.invoke(o);
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        try {
            Method method = clazz.getMethod("is" + StringUtil.firstCharUpperCase(fieldName));
            return method.invoke(o);
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        return defaultVal;
    }
}

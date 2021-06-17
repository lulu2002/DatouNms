package me.lulu.datounms.utils;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class ReflectionUtil {

    @SneakyThrows
    public static <E> E getStaticFieldContent(Class<?> clazz, String fieldName) {
        return getFieldContent(clazz, fieldName, null);
    }

    @SneakyThrows
    public static <E, G> E getFieldContent(Class<G> clazz, String fieldName, G instance) {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return ( E ) field.get(instance);
    }

}

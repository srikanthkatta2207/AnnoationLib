package com.srik.lib.utils;


public final class Util {

    public static <T> boolean isEmpty(T ...objects) {

        return objects.length == 0;
    }

    public static <T> boolean isEmpty(T object) {

        return object == null;
    }
}
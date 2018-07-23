package com.srik.lib.utils;

import com.srik.lib.annotations.GET;
import com.srik.lib.annotations.PATH;
import com.srik.lib.annotations.POST;
import com.srik.lib.annotations.QueryParam;

public class AnnotationClassFinder {

    static Class aClass = null;

    public static Class getClass(String type) throws Exception {

        try {
            switch (type) {
                case "GET":
                    aClass = GET.class;
                    break;
                case "POST":
                    aClass = POST.class;
                    break;
                case "PATH":
                    aClass = PATH.class;
                    break;
                case "QueryParam":
                    aClass = QueryParam.class;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aClass;
    }
}

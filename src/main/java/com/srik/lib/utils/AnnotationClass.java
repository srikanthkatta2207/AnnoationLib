package com.srik.lib.utils;

import com.srik.lib.annotations.*;

public enum AnnotationClass {

    GET {
        @Override
        public Class getClazz() {
            return GET.class;
        }
    },

    POST {
        @Override
        public Class getClazz() {
            return POST.class;
        }
    },

    PATH {
        @Override
        public Class getClazz() {
            return PATH.class;
        }
    };

    public abstract Class getClazz();
}
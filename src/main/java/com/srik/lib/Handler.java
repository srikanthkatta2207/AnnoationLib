package com.srik.lib;

import com.srik.lib.mappers.ClassLevelAnnotationMapper;
import com.srik.lib.utils.AnnotationClass;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Handler {

    private static HashMap<String,Class> reflectedClassesMap ;


    static {

        reflectedClassesMap = ClassLevelAnnotationMapper.getReflectedClassesMapFor("com.srik.lib",AnnotationClass.GET.getClazz());
    }

    public <T extends Annotation> Object handle(String url, Class<T> annotationClass) {

        Class reflectedClass = reflectedClassesMap.get(url);

        return call(reflectedClass,annotationClass);
    }


    private <T,E extends Annotation> T call(Class<T> reflectedClass, Class<E> annotationClass) {

        try {
            Object object = reflectedClass.newInstance();

            Method[] methods = reflectedClass.getMethods();

            for (Method method : methods) {

                Annotation annotation = method.getAnnotation(annotationClass);

                if(annotation != null) return (T) method.invoke(object, null);

            }
        } catch (Exception e) { e.printStackTrace();}

        return null;
    }
}


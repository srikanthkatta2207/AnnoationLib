package com.srik.lib;

import com.srik.lib.annotations.QueryParam;
import com.srik.lib.mappers.ClassLevelAnnotationMapper;
import com.srik.lib.utils.AnnotationClassFinder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Handler {

    private static HashMap<String, Class> reflectedClassesMap;

    public static void init(String packageName) {

        try {

            reflectedClassesMap = ClassLevelAnnotationMapper
                    .getReflectedClassesMapFor(packageName, AnnotationClassFinder.getClass("PATH"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static <T extends Annotation> Object send(String url, String method,HashMap<String,String> queryParams) throws Exception {

        Class annotationClass = AnnotationClassFinder.getClass(method);

        Class reflectedClass = reflectedClassesMap.get(url);

        return call(reflectedClass, annotationClass,queryParams);
    }


    private static <T, E extends Annotation> T call(Class<T> reflectedClass, Class<E> annotationClass, HashMap<String, String> queryParams) {

        try {
            Object object = reflectedClass.newInstance();

            Method[] methods = reflectedClass.getMethods();

            Object[] args = null;

            for (Method method : methods) {

                Annotation annotation = method.getAnnotation(annotationClass);

                if (annotation != null) {

                    args = getArgsForInvokeMethod(method,queryParams);

                    return (T) method.invoke(object,args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private static Object[] getArgsForInvokeMethod(Method method,HashMap<String,String> queryParams) {

        Annotation[][] paramAnnotations = method.getParameterAnnotations();

        Object[] args = new Object[paramAnnotations.length];

        if(paramAnnotations.length != 0) {

            int index=0;

            for (Annotation[] paramAnnotation : paramAnnotations) {

                args[index] = queryParams.get(((QueryParam) paramAnnotation[0]).value());

                index++;
            }
        }

        return args;
    }


}


package com.srik.lib.mappers;

import com.srik.lib.annotations.PATH;
import org.reflections.Reflections;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Set;

public class ClassLevelAnnotationMapper {


    public static HashMap<String, Class> getReflectedClassesMapFor(String packageName,Class annotation) {

        return ClassLevelAnnotationMapper.getReflectedClassesFor(packageName,annotation);
    }


    private static HashMap<String, Class> getReflectedClassesFor(String path, Class annotationType) {

        HashMap<String, Class> reflectedClassesForClassLevelAnnotations = new HashMap<>();

        Reflections reflections = new Reflections(path);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(annotationType);

        for (Class classObj : annotated) {

            try {

                Annotation annotation = classObj.getAnnotation(annotationType);

                if(annotation != null) reflectedClassesForClassLevelAnnotations.put(((PATH) annotation).value(), classObj);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return reflectedClassesForClassLevelAnnotations;
    }
}

package com.test.supply_12.annotation_03;

import java.lang.reflect.Method;

@Pro(className ="com.test.supply_12.annotation_03.AnnotationTest",methodName = "show")
public class annotationtestwork {
    public static void main(String[] args)throws Exception {
        Class<annotationtestwork> annotationtestworkClass = annotationtestwork.class;
        Pro an = annotationtestworkClass.getAnnotation(Pro.class);
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className+"++++"+methodName);
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(obj);

    }
}

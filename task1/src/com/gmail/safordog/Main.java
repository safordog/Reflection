package com.gmail.safordog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MyClass mc = new MyClass();
        Class<?> myClass = mc.getClass();
        Method[] methods = myClass.getDeclaredMethods();
        for (Method temp : methods) {
            if (temp.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myAnnotation = temp.getAnnotation(MyAnnotation.class);
                temp.invoke(mc, myAnnotation.paramOne(), myAnnotation.paramTwo());
            }
        }

    }
}

package com.gmail.safordog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        MoveText temp = new MoveText();
        Saver saver = new Saver();
        Class<?> classSaver = saver.getClass();
        temp.setTexttoSaver(temp.readTextFromContainer(), saver);
        Method method = classSaver.getDeclaredMethod("save", String.class);
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        method.invoke(saver, myAnnotation.path());
    }
}

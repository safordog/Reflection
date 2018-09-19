package com.gmail.safordog;

import java.lang.reflect.Field;

public class MoveText {

    public MoveText() {
    }

    public String readTextFromContainer() throws NoSuchFieldException, IllegalAccessException {
        TextContainer cont = new TextContainer();
        Class<?> textContainer = cont.getClass();
        Field fieldOne = null;
        fieldOne = textContainer.getDeclaredField("text");
        fieldOne.setAccessible(true);
        String str = (String) fieldOne.get(cont);
        return str;
    }

    public void setTexttoSaver(String str, Saver saver) throws NoSuchFieldException, IllegalAccessException {
        Class<?> classSaver = saver.getClass();
        Field fieldTwo;
        fieldTwo = classSaver.getDeclaredField("textSaver");
        fieldTwo.setAccessible(true);
        fieldTwo.set(saver, str);
    }
}

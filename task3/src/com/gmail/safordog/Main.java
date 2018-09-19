package com.gmail.safordog;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        File file = new File("save.txt");
        Saver saver = new Saver();
        saver.toSerialize(file);
        saver.toSetFields(saver.toDeserialize(file));
    }
}

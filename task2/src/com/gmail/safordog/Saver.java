package com.gmail.safordog;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saver {

    private String textSaver;

    public Saver() {
    }

    public String getText() {
        return textSaver;
    }

    public void setText(String textSaver) {
        this.textSaver = textSaver;
    }

    public Saver(String textSaver) {
        this.textSaver = textSaver;
    }

    @MyAnnotation(path = "text.txt")
    public void save(String path) {
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println(this.textSaver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

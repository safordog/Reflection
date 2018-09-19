package com.gmail.safordog;

public class MyClass {

    public MyClass() {

    }

    @MyAnnotation(paramOne = "Prog.kiev.ua", paramTwo = 5)
    public void printConsole(String text, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}

package com.gmail.safordog;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
    public @interface MyAnnotation {
        String path() default "default.txt";
    }

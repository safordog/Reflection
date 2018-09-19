package com.gmail.safordog;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
    public @interface MyAnnotation {
        String paramOne() default "Default";
        int paramTwo() default 3;
}

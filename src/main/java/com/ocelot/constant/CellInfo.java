package com.ocelot.constant;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
public @interface CellInfo {

    int index() default -1;
}

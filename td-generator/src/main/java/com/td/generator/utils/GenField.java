package com.td.generator.utils;

import java.lang.annotation.*;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:44:20
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GenField {
    String name();
}

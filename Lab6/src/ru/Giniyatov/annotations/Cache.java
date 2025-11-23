package ru.Giniyatov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания кешируемых областей.
 * Может применяться только к типам (классам).
 * Имеет необязательное свойство value типа String[].
 * Значение по умолчанию: пустой массив.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив имен кешируемых областей.
     *
     * @return массив имен областей (по умолчанию пустой массив)
     */
    String[] value() default {};
}


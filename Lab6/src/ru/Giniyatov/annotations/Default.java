package ru.Giniyatov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания типа по умолчанию.
 * Может применяться к типам (классам) или полям.
 * Имеет обязательное свойство value типа Class.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Класс по умолчанию.
     *
     * @return класс по умолчанию
     */
    Class<?> value();
}


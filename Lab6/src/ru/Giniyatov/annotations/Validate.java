package ru.Giniyatov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания списка типов для валидации.
 * Может применяться к типам (классам) или аннотациям.
 * Имеет обязательное свойство value типа Class[].
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив классов для проверки.
     *
     * @return массив классов для валидации
     */
    Class<?>[] value();
}


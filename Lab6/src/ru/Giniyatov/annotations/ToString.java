package ru.Giniyatov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления включением полей в строковое представление объекта.
 * Может применяться к типам (классам) или полям.
 * Имеет необязательное свойство value с двумя вариантами: YES или NO.
 * Значение по умолчанию: YES.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Режим включения поля в строковое представление.
     */
    enum Mode {
        YES, NO
    }

    /**
     * Режим отображения поля.
     *
     * @return режим отображения (по умолчанию YES)
     */
    Mode value() default Mode.YES;
}


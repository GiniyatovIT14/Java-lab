package ru.Giniyatov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя обязательными свойствами.
 * Может применяться только к типам (классам).
 * Имеет два обязательных свойства: first (String) и second (int).
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Первое свойство (строковое).
     *
     * @return строковое значение
     */
    String first();

    /**
     * Второе свойство (числовое).
     *
     * @return числовое значение
     */
    int second();
}


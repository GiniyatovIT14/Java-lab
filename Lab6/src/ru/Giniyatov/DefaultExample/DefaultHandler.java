package ru.Giniyatov.DefaultExample;

import ru.Giniyatov.annotations.Default;

import java.lang.reflect.Field;

/**
 * Обработчик для работы с аннотацией @Default.
 */
public class DefaultHandler {

    /**
     * Выводит имя класса по умолчанию из аннотации @Default на классе.
     *
     * @param clazz класс для проверки
     * @return имя класса по умолчанию или null, если аннотация отсутствует
     */
    public static String getDefaultClassName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            return annotation.value().getName();
        }

        return null;
    }

    /**
     * Выводит имя класса по умолчанию из аннотации @Default на поле.
     *
     * @param field поле для проверки
     * @return имя класса по умолчанию или null, если аннотация отсутствует
     */
    public static String getDefaultClassName(Field field) {
        if (field == null) {
            return null;
        }

        if (field.isAnnotationPresent(Default.class)) {
            Default annotation = field.getAnnotation(Default.class);
            return annotation.value().getName();
        }

        return null;
    }
}


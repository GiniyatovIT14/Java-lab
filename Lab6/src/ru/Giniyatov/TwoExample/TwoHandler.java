package ru.Giniyatov.TwoExample;

import ru.Giniyatov.annotations.Two;

/**
 * Обработчик для работы с аннотацией @Two.
 */
public class TwoHandler {

    /**
     * Считывает и выводит значения свойств аннотации @Two.
     *
     * @param clazz класс для проверки
     * @return строка с информацией о свойствах или null, если аннотация отсутствует
     */
    public static String getTwoProperties(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            return "first=" + annotation.first() + ", second=" + annotation.second();
        }

        return null;
    }

    /**
     * Получает значение свойства first из аннотации @Two.
     *
     * @param clazz класс для проверки
     * @return значение first или null, если аннотация отсутствует
     */
    public static String getFirst(Class<?> clazz) {
        if (clazz != null && clazz.isAnnotationPresent(Two.class)) {
            return clazz.getAnnotation(Two.class).first();
        }
        return null;
    }

    /**
     * Получает значение свойства second из аннотации @Two.
     *
     * @param clazz класс для проверки
     * @return значение second или -1, если аннотация отсутствует
     */
    public static int getSecond(Class<?> clazz) {
        if (clazz != null && clazz.isAnnotationPresent(Two.class)) {
            return clazz.getAnnotation(Two.class).second();
        }
        return -1;
    }
}


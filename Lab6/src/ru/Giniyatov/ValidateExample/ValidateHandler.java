package ru.Giniyatov.ValidateExample;

import ru.Giniyatov.annotations.Validate;

import java.util.Arrays;

/**
 * Обработчик для работы с аннотацией @Validate.
 */
public class ValidateHandler {

    /**
     * Выводит список классов, указанных в аннотации @Validate.
     *
     * @param clazz класс для проверки
     * @return массив классов из аннотации или null, если аннотация отсутствует
     * @throws IllegalArgumentException если массив классов пуст
     */
    public static Class<?>[] getValidationClasses(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            Class<?>[] classes = annotation.value();
            if (classes.length == 0) {
                throw new IllegalArgumentException("Массив классов для валидации не может быть пустым");
            }
            return classes;
        }

        return null;
    }

    /**
     * Выводит имена классов, указанных в аннотации @Validate.
     *
     * @param clazz класс для проверки
     * @return строка с именами классов через запятую
     */
    public static String getValidationClassNames(Class<?> clazz) {
        Class<?>[] classes = getValidationClasses(clazz);
        if (classes == null) {
            return "Аннотация @Validate не найдена";
        }
        return Arrays.toString(classes);
    }
}


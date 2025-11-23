package ru.Giniyatov.ToStringExample;

import ru.Giniyatov.annotations.ToString;

import java.lang.reflect.Field;

/**
 * Обработчик для формирования строкового представления объекта на основе аннотации @ToString.
 */
public class ToStringHandler {

    /**
     * Формирует строковое представление объекта, учитывая только поля с @ToString(Mode.YES).
     *
     * @param obj объект для преобразования
     * @return строковое представление объекта
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append("{");

        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            // Проверяем аннотацию на поле
            ToString annotation = field.getAnnotation(ToString.class);
            ToString.Mode mode = (annotation != null) ? annotation.value() : ToString.Mode.YES;

            // Включаем поле только если режим YES
            if (mode == ToString.Mode.YES) {
                if (!first) {
                    sb.append(", ");
                }
                first = false;

                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    sb.append(field.getName()).append("=").append(value);
                } catch (IllegalAccessException e) {
                    sb.append(field.getName()).append("=<недоступно>");
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}


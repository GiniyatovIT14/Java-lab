package ru.Giniyatov.CacheExample;

import ru.Giniyatov.annotations.Cache;

import java.util.Arrays;

/**
 * Обработчик для работы с аннотацией @Cache.
 */
public class CacheHandler {

    /**
     * Выводит список всех кешируемых областей из аннотации @Cache.
     *
     * @param clazz класс для проверки
     * @return массив имен кешируемых областей или null, если аннотация отсутствует
     */
    public static String[] getCacheAreas(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            return annotation.value();
        }

        return null;
    }

    /**
     * Выводит информацию о кешируемых областях.
     *
     * @param clazz класс для проверки
     * @return строка с информацией о кешируемых областях
     */
    public static String getCacheInfo(Class<?> clazz) {
        String[] areas = getCacheAreas(clazz);
        if (areas == null) {
            return "Аннотация @Cache не найдена";
        }
        if (areas.length == 0) {
            return "Список кешируемых областей пуст";
        }
        return "Кешируемые области: " + Arrays.toString(areas);
    }
}


package ru.Giniyatov.List;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// Утилиты для работы со списками
public class ListUtils {

    // Удаляет все вхождения элемента E из списка L
    public static <T> void removeAllOccurrences(List<T> list, T element) {
        if (list == null || element == null) {
            return;
        }

        // Используем итератор для безопасного удаления
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (element.equals(current)) {
                iterator.remove();
            }
        }
    }

    // Создание списка из элементов (шаблонный метод)
    @SafeVarargs
    public static <T> List<T> createList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }
}

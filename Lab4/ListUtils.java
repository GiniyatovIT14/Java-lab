import java.util.ArrayList;
import java.util.List;

// Утилиты для работы со списками
class ListUtils {

    // Применить функцию к каждому элементу списка
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        if (list == null || function == null) {
            throw new IllegalArgumentException("Список и функция не могут быть null!");
        }

        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    // Отфильтровать список по условию
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null || predicate == null) {
            throw new IllegalArgumentException("Список и предикат не могут быть null!");
        }

        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Свернуть список к одному значению
    public static <T> T reduce(List<T> list, Reducer<T> reducer, T defaultValue) {
        if (list == null || reducer == null) {
            throw new IllegalArgumentException("Список и редьюсер не могут быть null!");
        }

        if (list.isEmpty()) {
            return defaultValue;
        }

        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = reducer.reduce(result, list.get(i));
        }
        return result;
    }

    // Коллекционирование элементов в пользовательскую коллекцию
    public static <T, P> P collect(List<T> list, Collector<T, P> collector) {
        if (list == null || collector == null) {
            throw new IllegalArgumentException("Список и коллектор не могут быть null!");
        }

        P result = collector.create();
        for (T item : list) {
            collector.add(result, item);
        }
        return result;
    }
}
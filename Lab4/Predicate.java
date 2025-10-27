// Функциональный интерфейс для проверки условий
interface Predicate<T> {
    // Проверить условие для значения
    boolean test(T value);
}
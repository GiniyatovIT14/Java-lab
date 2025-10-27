// Функциональный интерфейс для создания коллекции
interface Collector<T, P> {
    // Создать новую коллекцию
    P create();

    // Добавить элемент в коллекцию
    void add(P collection, T item);
}
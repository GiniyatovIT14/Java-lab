// Функциональный интерфейс для свертки значений
interface Reducer<T> {
    // Свернуть два значения в одно
    T reduce(T accumulator, T current);
}
package ru.Giniyatov.TwoExample;

import ru.Giniyatov.annotations.Two;

/**
 * Тестовый класс для демонстрации работы аннотации @Two.
 */
@Two(first = "Hello", second = 42)
public class TwoClass {
    private String data;

    /**
     * Конструктор по умолчанию.
     */
    public TwoClass() {
        this.data = "test";
    }
}


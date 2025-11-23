package ru.Giniyatov.DefaultExample;

import ru.Giniyatov.annotations.Default;

/**
 * Тестовый класс для демонстрации работы аннотации @Default.
 */
@Default(String.class)
public class DefaultClass {
    @Default(Integer.class)
    private Object field1;

    private Object field2;

    /**
     * Конструктор по умолчанию.
     */
    public DefaultClass() {
    }
}


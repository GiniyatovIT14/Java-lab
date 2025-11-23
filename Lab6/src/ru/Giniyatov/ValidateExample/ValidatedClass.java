package ru.Giniyatov.ValidateExample;

import ru.Giniyatov.annotations.Validate;

/**
 * Тестовый класс для демонстрации работы аннотации @Validate.
 */
@Validate({String.class, Integer.class, Double.class})
public class ValidatedClass {
    private String name;
    private int value;

    /**
     * Конструктор с параметрами.
     *
     * @param name имя
     * @param value значение
     */
    public ValidatedClass(String name, int value) {
        this.name = name;
        this.value = value;
    }
}


package ru.Giniyatov.PersonStream;

// Класс для хранения информации о человеке
public class Person {
    private String name;
    private Integer number;

    // Конструктор
    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    // Строковое представление
    @Override
    public String toString() {
        return name + ":" + (number != null ? number : "нет номера");
    }
}
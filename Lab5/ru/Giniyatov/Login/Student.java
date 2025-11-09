package ru.Giniyatov.Login;

// Класс для хранения информации о студенте
public class Student {
    private String lastName;
    private String firstName;
    private String login;

    // Конструктор
    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = ""; // Логин будет сгенерирован позже
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    // Сеттер для логина
    public void setLogin(String login) {
        this.login = login;
    }

    // Строковое представление
    @Override
    public String toString() {
        return lastName + " " + firstName + " -> " + login;
    }
}
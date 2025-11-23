package ru.Giniyatov.ToStringExample;

import ru.Giniyatov.annotations.ToString;

/**
 * Тестовый класс для демонстрации работы аннотации @ToString.
 */
public class ToStringClass {
    private String name = "Иван";
    private int age = 25;

    @ToString(ToString.Mode.NO)
    private String password = "secret123";

    private String email = "ivan@example.com";

    /**
     * Конструктор с параметрами.
     *
     * @param name имя
     * @param age возраст
     * @param password пароль
     * @param email email
     */
    public ToStringClass(String name, int age, String password, String email) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    /**
     * Получить имя.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Получить возраст.
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Получить пароль.
     *
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Получить email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }
}


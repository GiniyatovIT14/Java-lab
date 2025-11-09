package ru.Giniyatov.Cat;

import java.util.Collection;

// Класс с методами для работы с мяукающими объектами
public class Funs {

    // Метод, который вызывает мяуканье у каждого объекта
    public static void meowsCare(Collection<Meowable> meowables) {
        if (meowables == null) {
            return;
        }

        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }

    // Перегруженный метод для одиночного объекта
    public static void meowsCare(Meowable meowable) {
        if (meowable != null) {
            meowable.meow();
        }
    }
}
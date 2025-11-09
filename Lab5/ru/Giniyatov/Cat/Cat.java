package ru.Giniyatov.Cat;

// Класс Кот
public class Cat implements Meowable {
    private String name;

    // Конструктор с именем
    public Cat(String name) {
        this.name = name;
    }

    // Метод мяуканья (один раз)
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    // Метод мяуканья N раз
    public void meow(int times) {
        if (times <= 0) {
            System.out.println(name + ": ... (не хочет мяукать)");
            return;
        }

        StringBuilder meowString = new StringBuilder(name + ": ");
        for (int i = 0; i < times; i++) {
            if (i > 0) {
                meowString.append("-");
            }
            meowString.append("мяу");
        }
        meowString.append("!");

        System.out.println(meowString.toString());
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Строковое представление
    @Override
    public String toString() {
        return "кот: " + name;
    }
}
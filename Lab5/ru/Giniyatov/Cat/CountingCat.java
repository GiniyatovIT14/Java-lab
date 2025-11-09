package ru.Giniyatov.Cat;

// Класс для подсчета мяуканий
public class CountingCat implements Meowable {
    private Cat realCat;
    private int meowCount;

    // Конструктор принимает реального кота
    public CountingCat(Cat cat) {
        this.realCat = cat;
        this.meowCount = 0;
    }

    // Переопределяем метод meow для подсчета (одиночное мяуканье)
    @Override
    public void meow() {
        realCat.meow(); // Вызываем мяуканье реального кота
        meowCount++;    // Увеличиваем счетчик
    }

    // Метод для многократного мяуканья с подсчетом
    public void meow(int times) {
        realCat.meow(times); // Вызываем многократное мяуканье реального кота
        meowCount += times;  // Увеличиваем счетчик на количество мяуканий
    }

    // Геттер для количества мяуканий
    public int getMeowCount() {
        return meowCount;
    }

    // Сброс счетчика
    public void resetMeowCount() {
        this.meowCount = 0;
    }

    @Override
    public String toString() {
        return realCat.toString() + " [мяукал: " + meowCount + " раз]";
    }
}
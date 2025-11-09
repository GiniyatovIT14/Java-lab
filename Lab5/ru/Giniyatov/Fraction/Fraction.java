package ru.Giniyatov.Fraction;

// Класс Дробь с кэшированием вещественного значения
public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;
    private Double cachedDecimalValue;      // кэширование вещ. числа
    private boolean isCacheValid;           // флаг валидности кэша

    // Конструктор по умолчанию
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
        this.cachedDecimalValue = 0.0;
        this.isCacheValid = true;
    }

    // Конструктор с параметрами
    public Fraction(int numerator, int denominator) {
        validateDenominator(denominator);
        normalizeAndSetValues(numerator, denominator);
        this.isCacheValid = false;
    }

    // Проверка знаменателя
    private void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
    }

    // Нормализация и установка значений (знаменатель всегда положительный)
    private void normalizeAndSetValues(int numerator, int denominator) {
        if (denominator < 0) {
            this.numerator = -numerator;    // знаменатель не может быть "-" -> меняем знаки
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    @Override
    public double getDecimalValue() {
        if (!isCacheValid || cachedDecimalValue == null) {
            // Вычисляем и кэшируем значение
            cachedDecimalValue = (double) numerator / denominator;
            isCacheValid = true;
        }
        return cachedDecimalValue;
    }

    @Override
    public void setNumeratorAndDenominator(int numerator, int denominator) {
        validateDenominator(denominator);
        normalizeAndSetValues(numerator, denominator);
        isCacheValid = false;       // Сбрасываем кэш при изменении значений
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Переопределение equals для сравнения по состоянию
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
    // Переопределение hashCode
    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }

    // Строковое представление дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
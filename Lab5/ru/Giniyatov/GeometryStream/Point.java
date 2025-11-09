package ru.Giniyatov.GeometryStream;

// Класс точки на плоскости
public class Point {
    private double x;
    private double y;

    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Проверка равенства точек (ОБЯЗАТЕЛЬНО для distinct())
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    // Хэш-код (ОБЯЗАТЕЛЬНО для distinct())
    @Override
    public int hashCode() {
        return 31 * Double.hashCode(x) + Double.hashCode(y);
    }

    // Строковое представление
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
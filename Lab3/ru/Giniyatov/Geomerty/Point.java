package ru.Giniyatov.Geomerty;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        // Проверка на специальные значения double
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Координаты не могут быть NaN");
        }
        if (Double.isInfinite(x) || Double.isInfinite(y)) {
            throw new IllegalArgumentException("Координаты не могут быть бесконечными");
        }
        this.x = x;
        this.y = y;
    }

    // Альтернативный конструктор для строкового ввода
    public Point(String xStr, String yStr) {
        try {
            this.x = Double.parseDouble(xStr);
            this.y = Double.parseDouble(yStr);

            // Проверка на специальные значения
            if (Double.isNaN(x) || Double.isNaN(y)) {
                throw new IllegalArgumentException("Координаты не могут быть NaN");
            }
            if (Double.isInfinite(x) || Double.isInfinite(y)) {
                throw new IllegalArgumentException("Координаты не могут быть бесконечными");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Координаты должны быть числами: " + e.getMessage());
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Point other = (Point) obj;
        return Double.compare(this.x, other.x) == 0 &&
                Double.compare(this.y, other.y) == 0;
    }
}
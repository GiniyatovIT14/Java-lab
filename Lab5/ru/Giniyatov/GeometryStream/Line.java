package ru.Giniyatov.GeometryStream;

// Класс линии
public class Line {
    private Point start;
    private Point end;

    // Конструктор
    public Line(Point start, Point end) { 
        this.start = start;
        this.end = end;
    }

    // Строковое представление
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
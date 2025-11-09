package ru.Giniyatov.GeometryStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Класс ломаной линии с использованием коллекций
public class Polyline {
    private List<Point> points;

    // Конструктор с коллекцией точек
    public Polyline(List<Point> points) {
        if (points == null) {
            this.points = new ArrayList<>();
        } else {
            this.points = new ArrayList<>(points);
        }
    }

    // Конструктор с массивом точек (для обратной совместимости)
    public Polyline(Point[] points) {
        this.points = new ArrayList<>();
        if (points != null) {
            for (Point point : points) {
                this.points.add(point);
            }
        }
    }

    // Геттер для точек
    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    // Строковое представление
    @Override
    public String toString() {
        if (points.isEmpty()) {
            return "Линия []";
        }

        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
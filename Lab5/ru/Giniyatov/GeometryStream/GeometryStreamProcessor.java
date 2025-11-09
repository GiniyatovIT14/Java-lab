package ru.Giniyatov.GeometryStream;

import java.util.*;
import java.util.stream.Collectors;

// Класс для обработки геометрических данных с помощью стримов
public class GeometryStreamProcessor {

    // Основной метод обработки стрима точек
    public static Polyline processPoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            return new Polyline(new ArrayList<>());
        }

        List<Point> processedPoints = points.stream()
                // исключаем дубликаты
                .distinct()
                // сортируем по X
                .sorted(Comparator.comparingDouble(Point::getX))
                // делаем Y положительными
                .map(point -> {
                    double newY = point.getY() < 0 ? -point.getY() : point.getY();
                    return new Point(point.getX(), newY);
                })
                // собираем в коллекцию
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }
}
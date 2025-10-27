
import java.util.List;

// Утилиты для математических операций с коробками
class MathUtils {

    // Найти максимальное значение в коробках с числами
    public static double findMax(List<Box<? extends Number>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Список коробок не может быть пустым!");
        }

        double max = Double.MIN_VALUE;
        boolean numberFound = false;

        for (Box<? extends Number> box : boxes) {
            if (box.containsNumber()) {
                double value = box.getAsDouble();
                if (value > max) {
                    max = value;
                    numberFound = true;
                }
            }
        }

        if (!numberFound) {
            throw new IllegalArgumentException("Ни одна коробка не содержит числовое значение!");
        }

        return max;
    }

    // Найти максимум в массиве коробок
    public static double findMax(Box<? extends Number>... boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Массив коробок не может быть пустым!");
        }

        return findMax(List.of(boxes));
    }
}
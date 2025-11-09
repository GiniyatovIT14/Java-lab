package ru.Giniyatov.Queue;

import java.util.*;

// Утилиты для работы с очередями
public class QueueUtils {

    // Переписывает элементы из очереди L1 в очередь L2 в обратном порядке
    public static <T> void reverseQueue(Queue<T> L1, Queue<T> L2) {
        if (L1 == null || L2 == null) {
            throw new IllegalArgumentException("Очереди не могут быть null");
        }

        // Очищаем целевую очередь L2
        L2.clear();

        // Используем стек для обращения порядка
        Stack<T> stack = new Stack<>();

        // Перекладываем все элементы из L1 в стек
        while (!L1.isEmpty()) {
            stack.push(L1.poll());
        }

        // Перекладываем элементы из стека обратно в L1 и в L2
        while (!stack.isEmpty()) {
            T element = stack.pop();
            L1.offer(element); // Возвращаем элементы в L1
            L2.offer(element); // Записываем в L2 в обратном порядке
        }
    }

    // Альтернативный метод: создает новую очередь с обратным порядком
    public static <T> Queue<T> createReversedQueue(Queue<T> original) {
        if (original == null) {
            return new LinkedList<>();
        }

        Queue<T> reversed = new LinkedList<>();
        Stack<T> stack = new Stack<>();

        // Создаем копию исходной очереди, чтобы не изменять оригинал
        Queue<T> temp = new LinkedList<>(original);

        // Перекладываем в стек
        while (!temp.isEmpty()) {
            stack.push(temp.poll());
        }

        // Перекладываем из стека в новую очередь
        while (!stack.isEmpty()) {
            reversed.offer(stack.pop());
        }

        return reversed;
    }

    // Создание очереди из массива элементов
    @SafeVarargs
    public static <T> Queue<T> createQueue(T... elements) {
        Queue<T> queue = new LinkedList<>();
        for (T element : elements) {
            queue.offer(element);
        }
        return queue;
    }

    // Преобразование очереди в строку для красивого вывода
    public static <T> String queueToString(Queue<T> queue) {
        if (queue == null) return "null";

        Queue<T> temp = new LinkedList<>(queue); // Создаем копию для обхода
        StringBuilder sb = new StringBuilder("[");

        while (!temp.isEmpty()) {
            sb.append(temp.poll());
            if (!temp.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
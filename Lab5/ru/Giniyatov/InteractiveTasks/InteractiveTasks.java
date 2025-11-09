package ru.Giniyatov.InteractiveTasks;

import ru.Giniyatov.Fraction.Fraction;
import ru.Giniyatov.Cat.*;
import ru.Giniyatov.List.*;
import ru.Giniyatov.Login.*;
import ru.Giniyatov.Finder.*;
import ru.Giniyatov.Queue.*;
import ru.Giniyatov.GeometryStream.*;
import ru.Giniyatov.PersonStream.*;

import java.util.*;
import java.io.*;

/// Класс для интерактивной работы с пользователем
public class InteractiveTasks {
    private static Scanner scanner = new Scanner(System.in);

    // Интерактивное выполнение задания 1
    public static void interactiveTask1() {
        System.out.println("=== ИНТЕРАКТИВНАЯ РАБОТА С ДРОБЯМИ ===");
        System.out.println("Теперь вы можете создать свою собственную дробь!");
        System.out.println();

        try {
            // Ввод числителя
            System.out.print("Введите ЧИСЛИТЕЛЬ (целое число): ");
            int numerator = getValidInt();

            // Ввод знаменателя
            System.out.print("Введите ЗНАМЕНАТЕЛЬ (целое число, не ноль): ");
            int denominator = getValidInt();

            // Создание дроби
            Fraction fraction = new Fraction(numerator, denominator);
            System.out.println();
            System.out.println("УСПЕХ! Дробь создана:");
            System.out.println("• Дробь в виде: " + fraction);
            System.out.println("• Десятичное значение: " + fraction.getDecimalValue());

            // Демонстрация кэширования
            System.out.println();
            System.out.println("Проверка кэширования:");
            System.out.println("Повторный расчет значения (должен браться из кэша): " +
                    fraction.getDecimalValue());

            // Предложение изменить дробь
            System.out.println();
            System.out.print("Хотите изменить дробь? (1 - ДА, 0 - НЕТ): ");
            int choice = getValidIntInRange(0, 1);

            if (choice == 1) {
                System.out.println();
                System.out.print("Введите НОВЫЙ числитель: ");
                int newNumerator = getValidInt();

                System.out.print("Введите НОВЫЙ знаменатель: ");
                int newDenominator = getValidInt();

                fraction.setNumeratorAndDenominator(newNumerator, newDenominator);
                System.out.println();
                System.out.println("Дробь обновлена:");
                System.out.println("• Новая дробь: " + fraction);
                System.out.println("• Новое десятичное значение: " + fraction.getDecimalValue());
            }

            System.out.println();

        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("ОШИБКА: " + e.getMessage());
            System.out.println("Пожалуйста, попробуйте снова.");
        }

        System.out.println("========================================");
        System.out.println();
    }

    // Интерактивное выполнение задания 2
    public static void interactiveTask2() {
        System.out.println("=== Интерактивная работа с котами ===");
        System.out.println("Создайте своего кота и посчитайте его мяуканья!");
        System.out.println();

        // Ввод имени кота
        System.out.print("Введите имя кота: ");
        String catName = scanner.nextLine();

        // Создание кота и счетчика
        Cat cat = new Cat(catName);
        CountingCat countingCat = new CountingCat(cat);

        System.out.println();
        System.out.println("Создан: " + cat);
        System.out.println();

        boolean continueMeowing = true;

        while (continueMeowing) {
            System.out.println("Текущее количество мяуканий: " + countingCat.getMeowCount());
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1 - Мяукнуть один раз");
            System.out.println("2 - Мяукнуть несколько раз");
            System.out.println("3 - Вызвать метод meowsCare (мяукнет автоматически)");
            System.out.println("4 - Сбросить счетчик");
            System.out.println("0 - Вернуться в меню");
            System.out.print("Ваш выбор: ");

            int choice = getValidIntInRange(0, 4);

            switch (choice) {
                case 1:
                    countingCat.meow();
                    break;
                case 2:
                    System.out.print("Сколько раз мяукнуть? ");
                    int times = getValidIntInRange(1, 10);
                    countingCat.meow(times);
                    break;
                case 3:
                    System.out.println("Вызываем метод meowsCare...");
                    Funs.meowsCare(countingCat);
                    break;
                case 4:
                    countingCat.resetMeowCount();
                    System.out.println("Счетчик сброшен!");
                    break;
                case 0:
                    continueMeowing = false;
                    break;
            }
            System.out.println();
        }

        System.out.println("Итоговое количество мяуканий: " + countingCat.getMeowCount());
        System.out.println("======================================");
        System.out.println();
    }

    // Интерактивное выполнение задания 3
    public static void interactiveTask3() {
        System.out.println("=== Интерактивная работа со списками ===");
        System.out.println("Создайте список и удалите из него все вхождения элемента");
        System.out.println();

        boolean continueWorking = true;

        while (continueWorking) {
            System.out.println("Выберите тип списка:");
            System.out.println("1 - Список целых чисел");
            System.out.println("2 - Список строк");
            System.out.println("3 - Список дробных чисел");
            System.out.println("0 - Вернуться в меню");
            System.out.print("Ваш выбор: ");

            int typeChoice = getValidIntInRange(0, 3);
            System.out.println();

            switch (typeChoice) {
                case 1:
                    workWithIntegerList();
                    break;
                case 2:
                    workWithStringList();
                    break;
                case 3:
                    workWithDoubleList();
                    break;
                case 0:
                    continueWorking = false;
                    break;
            }

            if (typeChoice != 0) {
                System.out.println();
            }
        }

        System.out.println("=======================================");
        System.out.println();
    }

    // Работа со списком целых чисел
    private static void workWithIntegerList() {
        System.out.println("--- Список целых чисел ---");
        System.out.print("Введите числа через пробел: ");
        scanner.nextLine(); // Очистка буфера

        String input = scanner.nextLine();
        String[] numberStrings = input.split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            try {
                numbers.add(Integer.parseInt(numStr));
            } catch (NumberFormatException e) {
                System.out.println("Пропущен нечисловой элемент: '" + numStr + "'");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.println("Создан список: " + numbers);

        System.out.print("Введите число для удаления: ");
        int numberToRemove = getValidInt();

        List<Integer> originalList = new ArrayList<>(numbers);
        ListUtils.removeAllOccurrences(numbers, numberToRemove);

        System.out.println();
        System.out.println("Результат:");
        System.out.println("Исходный список: " + originalList);
        System.out.println("После удаления " + numberToRemove + ": " + numbers);
        System.out.println("Удалено элементов: " + (originalList.size() - numbers.size()));
    }

    // Работа со списком строк
    private static void workWithStringList() {
        System.out.println("--- Список строк ---");
        System.out.print("Введите строки через запятую: ");
        scanner.nextLine(); // Очистка буфера

        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }

        String[] strings = input.split(",");
        List<String> stringList = new ArrayList<>();
        for (String str : strings) {
            stringList.add(str.trim());
        }

        System.out.println("Создан список: " + stringList);

        System.out.print("Введите строку для удаления: ");
        String stringToRemove = scanner.nextLine().trim();

        List<String> originalList = new ArrayList<>(stringList);
        ListUtils.removeAllOccurrences(stringList, stringToRemove);

        System.out.println();
        System.out.println("Результат:");
        System.out.println("Исходный список: " + originalList);
        System.out.println("После удаления '" + stringToRemove + "': " + stringList);
        System.out.println("Удалено элементов: " + (originalList.size() - stringList.size()));
    }

    // Работа со списком дробных чисел
    private static void workWithDoubleList() {
        System.out.println("--- Список дробных чисел ---");
        System.out.print("Введите числа через пробел (можно дробные): ");
        scanner.nextLine(); // Очистка буфера

        String input = scanner.nextLine();
        String[] numberStrings = input.split("\\s+");

        List<Double> doubles = new ArrayList<>();
        for (String numStr : numberStrings) {
            try {
                doubles.add(Double.parseDouble(numStr));
            } catch (NumberFormatException e) {
                System.out.println("Пропущен некорректный элемент: '" + numStr + "'");
            }
        }

        if (doubles.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.println("Создан список: " + doubles);

        System.out.print("Введите число для удаления: ");
        double numberToRemove;
        while (true) {
            try {
                numberToRemove = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите корректное число: ");
            }
        }

        List<Double> originalList = new ArrayList<>(doubles);
        ListUtils.removeAllOccurrences(doubles, numberToRemove);

        System.out.println();
        System.out.println("Результат:");
        System.out.println("Исходный список: " + originalList);
        System.out.println("После удаления " + numberToRemove + ": " + doubles);
        System.out.println("Удалено элементов: " + (originalList.size() - doubles.size()));
    }

    // Вспомогательные методы для валидации ввода
    private static int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int getValidIntInRange(int min, int max) {
        int input;
        while (true) {
            input = getValidInt();
            if (input >= min && input <= max) {
                break;
            }
            System.out.print("Ошибка! Введите число от " + min + " до " + max + ": ");
        }
        return input;
    }

    // Интерактивное выполнение задания 4
    public static void interactiveTask4() {
        System.out.println("=== Интерактивная работа с генерацией логинов ===");
        System.out.println();

        System.out.print("Введите имя входного файла (например, students.txt): ");
        String inputFile = scanner.nextLine().trim();

        if (inputFile.isEmpty()) {
            inputFile = "students.txt";
        }

        // Чтение студентов из файла
        List<Student> students = LoginGenerator.readStudentsFromFile(inputFile);

        if (students.isEmpty()) {
            System.out.println("Не удалось прочитать студентов из файла.");
            System.out.println("Создайте файл '" + inputFile + "' с данными в формате:");
            System.out.println("5");
            System.out.println("Иванова Мария");
            System.out.println("Петров Сергей");
            System.out.println("...");
            return;
        }

        System.out.println("Успешно прочитано " + students.size() + " студентов");
        System.out.println();

        // Генерация логинов
        List<Student> result = LoginGenerator.generateLogins(students);

        // Вывод результатов
        System.out.println("Сгенерированные логины:");
        for (Student student : result) {
            System.out.println(student);
        }
        System.out.println();

        // Запись в файл
        System.out.print("Введите имя выходного файла для сохранения логинов (например, logins.txt): ");
        String outputFile = scanner.nextLine().trim();

        if (outputFile.isEmpty()) {
            outputFile = "logins.txt";
        }

        LoginGenerator.writeResultsToFile(outputFile, result);

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

    // Интерактивное выполнение задания 5
    public static void interactiveTask5() {
        System.out.println("=== Интерактивная работа с поиском согласных ===");
        System.out.println();

        System.out.println("Выберите способ ввода текста:");
        System.out.println("1 - Ввести текст вручную");
        System.out.println("2 - Прочитать текст из файла");
        System.out.print("Ваш выбор: ");

        int choice = getValidIntInRange(1, 2);
        System.out.println();

        String text = "";

        if (choice == 1) {
            // Ручной ввод текста
            System.out.println("Введите текст на русском языке:");
            System.out.print("> ");
            scanner.nextLine(); // Очистка буфера
            text = scanner.nextLine();
        } else {
            // Чтение из файла
            System.out.print("Введите имя файла с текстом: ");
            scanner.nextLine(); // Очистка буфера
            String filename = scanner.nextLine().trim();

            if (filename.isEmpty()) {
                filename = "text.txt";
            }

            text = ConsonantFinder.readTextFromFile(filename);
            if (text.isEmpty()) {
                System.out.println("Не удалось прочитать текст из файла.");
                return;
            }

            System.out.println("Текст из файла:");
            System.out.println(text);
            System.out.println();
        }

        if (text.trim().isEmpty()) {
            System.out.println("Текст пуст!");
            return;
        }

        // Поиск и вывод согласных
        Set<Character> consonants = ConsonantFinder.findVoicedConsonants(text);
        ConsonantFinder.printConsonants(consonants);

        // Предложение сохранить результат
        System.out.println();
        System.out.print("Хотите сохранить результат в файл? (1 - да, 0 - нет): ");
        int saveChoice = getValidIntInRange(0, 1);

        if (saveChoice == 1) {
            System.out.print("Введите имя файла для сохранения: ");
            scanner.nextLine(); // Очистка буфера
            String outputFile = scanner.nextLine().trim();

            if (outputFile.isEmpty()) {
                outputFile = "consonants.txt";
            }

            ConsonantFinder.writeConsonantsToFile(outputFile, consonants);
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println();
    }

    // Интерактивное выполнение задания 6
    public static void interactiveTask6() {
        System.out.println("=== Интерактивная работа с очередями ===");
        System.out.println();

        boolean continueWorking = true;

        while (continueWorking) {
            System.out.println("Выберите тип элементов очереди:");
            System.out.println("1 - Целые числа");
            System.out.println("2 - Строки");
            System.out.println("0 - Вернуться в меню");
            System.out.print("Ваш выбор: ");

            int typeChoice = getValidIntInRange(0, 2);
            System.out.println();

            if (typeChoice == 0) {
                continueWorking = false;
                continue;
            }

            if (typeChoice == 1) {
                workWithIntegerQueue();
            } else {
                workWithStringQueue();
            }

            System.out.println();
        }

        System.out.println("======================================");
        System.out.println();
    }

    // Работа с очередью целых чисел
    private static void workWithIntegerQueue() {
        System.out.println("--- Очередь целых чисел ---");
        System.out.print("Введите числа через пробел: ");
        scanner.nextLine(); // Очистка буфера

        String input = scanner.nextLine();
        String[] numberStrings = input.split("\\s+");

        Queue<Integer> L1 = new LinkedList<>();
        for (String numStr : numberStrings) {
            try {
                L1.offer(Integer.parseInt(numStr));
            } catch (NumberFormatException e) {
                System.out.println("Пропущен нечисловой элемент: '" + numStr + "'");
            }
        }

        if (L1.isEmpty()) {
            System.out.println("Очередь пуста!");
            return;
        }

        Queue<Integer> L2 = new LinkedList<>();

        System.out.println("Исходная очередь L1: " + QueueUtils.queueToString(L1));
        System.out.println("Целевая очередь L2 (до): " + QueueUtils.queueToString(L2));

        // Сохраняем копию для демонстрации
        Queue<Integer> L1Copy = new LinkedList<>(L1);

        QueueUtils.reverseQueue(L1, L2);

        System.out.println();
        System.out.println("Результат:");
        System.out.println("Очередь L1 (после): " + QueueUtils.queueToString(L1));
        System.out.println("Очередь L2 (после): " + QueueUtils.queueToString(L2));

        // Демонстрация альтернативного метода
        System.out.println();
        System.out.println("Альтернативный метод (без изменения L1):");
        Queue<Integer> reversed = QueueUtils.createReversedQueue(L1Copy);
        System.out.println("Исходная очередь: " + QueueUtils.queueToString(L1Copy));
        System.out.println("Обращенная очередь: " + QueueUtils.queueToString(reversed));
    }

    // Работа с очередью строк
    private static void workWithStringQueue() {
        System.out.println("--- Очередь строк ---");
        System.out.print("Введите строки через запятую: ");
        scanner.nextLine(); // Очистка буфера

        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Очередь пуста!");
            return;
        }

        String[] strings = input.split(",");
        Queue<String> L1 = new LinkedList<>();
        for (String str : strings) {
            L1.offer(str.trim());
        }

        Queue<String> L2 = new LinkedList<>();

        System.out.println("Исходная очередь L1: " + QueueUtils.queueToString(L1));
        System.out.println("Целевая очередь L2 (до): " + QueueUtils.queueToString(L2));

        // Сохраняем копию для демонстрации
        Queue<String> L1Copy = new LinkedList<>(L1);

        QueueUtils.reverseQueue(L1, L2);

        System.out.println();
        System.out.println("Результат:");
        System.out.println("Очередь L1 (после): " + QueueUtils.queueToString(L1));
        System.out.println("Очередь L2 (после): " + QueueUtils.queueToString(L2));

        // Демонстрация альтернативного метода
        System.out.println();
        System.out.println("Альтернативный метод (без изменения L1):");
        Queue<String> reversed = QueueUtils.createReversedQueue(L1Copy);
        System.out.println("Исходная очередь: " + QueueUtils.queueToString(L1Copy));
        System.out.println("Обращенная очередь: " + QueueUtils.queueToString(reversed));
    }

    // Интерактивное выполнение задания 7
    public static void interactiveTask7() {
        System.out.println("=== Интерактивная работа с точками и стримами ===");
        System.out.println();

        List<Point> points = new ArrayList<>();

        System.out.println("Добавьте точки (координаты X и Y):");

        while (true) {
            System.out.print("Введите координату X (или 'stop' для завершения): ");
            if (!scanner.hasNextDouble()) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println("Ошибка! Введите число или 'stop'");
                continue;
            }
            double x = scanner.nextDouble();

            System.out.print("Введите координату Y: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Ошибка! Введите число: ");
                scanner.next();
            }
            double y = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера

            points.add(new Point(x, y));
            System.out.println("Добавлена точка: {" + x + ";" + y + "}");
            System.out.println();
        }

        if (points.isEmpty()) {
            System.out.println("Точки не добавлены.");
            return;
        }

        System.out.println("Исходные точки (" + points.size() + "):");
        points.forEach(point -> System.out.println("  " + point));
        System.out.println();

        // Обработка стримом
        Polyline result = GeometryStreamProcessor.processPoints(points);

        System.out.println("Результат обработки стримом:");
        System.out.println("Ломаная линия: " + result);

        System.out.println("===============================================");
        System.out.println();
    }

    // Интерактивное выполнение задания 8
    public static void interactiveTask8() {
        System.out.println("=== Интерактивная работа с обработкой людей ===");
        System.out.println();

        System.out.print("Введите имя входного файла (например, people.txt): ");
        String inputFile = scanner.nextLine().trim();

        if (inputFile.isEmpty()) {
            inputFile = "people.txt";
        }

        // Чтение людей из файла
        List<Person> people = PersonStreamProcessor.readPeopleFromFile(inputFile);

        if (people.isEmpty()) {
            System.out.println("Не удалось прочитать данные из файла.");
            System.out.println("Создайте файл '" + inputFile + "' с данными в формате:");
            System.out.println("Вася:5");
            System.out.println("Петя:3");
            System.out.println("Аня:5");
            System.out.println("Маша:");
            System.out.println("...");
            return;
        }

        System.out.println("Успешно прочитано " + people.size() + " записей");
        System.out.println();
        System.out.println("Исходные данные:");
        people.forEach(person -> System.out.println("  " + person));
        System.out.println();

        // Обработка стримом
        Map<Integer, List<String>> result = PersonStreamProcessor.processPeople(people);

        System.out.println("Результат обработки стримом:");
        System.out.println(PersonStreamProcessor.formatResult(result));
        System.out.println();

        // Запись в файл
        System.out.print("Введите имя выходного файла для сохранения результата: ");
        String outputFile = scanner.nextLine().trim();

        if (outputFile.isEmpty()) {
            outputFile = "result.txt";
        }

        PersonStreamProcessor.writeResultToFile(outputFile, result);

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }
}
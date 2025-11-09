package ru.Giniyatov.DemonstrateTasks;

import ru.Giniyatov.Fraction.Fraction;
import ru.Giniyatov.Cat.*;
import ru.Giniyatov.GeometryStream.*;
import ru.Giniyatov.List.*;
import ru.Giniyatov.Login.*;
import ru.Giniyatov.Finder.*;
import ru.Giniyatov.Queue.*;
import ru.Giniyatov.PersonStream.*;

import java.util.*;
import java.io.*;

// Класс для демонстрации всех заданий
public class DemonstrateTasks {

    // Демонстрация задания 1
    public static void demonstrateTask1() {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ С ДРОБЯМИ ===");
        System.out.println();

        // 1. Создание дробей с разными параметрами
        System.out.println("1. СОЗДАНИЕ ДРОБЕЙ:");
        System.out.println("-------------------");

        Fraction frac1 = new Fraction(3, 4);
        System.out.println("• Дробь 3/4: " + frac1);

        Fraction frac2 = new Fraction(-2, 5);
        System.out.println("• Дробь -2/5: " + frac2);

        // Демонстрация автоматической нормализации знака
        Fraction frac3 = new Fraction(6, -8);
        System.out.println("• Дробь 6/-8 (автоматически нормализована): " + frac3);

        Fraction frac4 = new Fraction(3, 4); // Такая же как frac1
        System.out.println("• Дробь 3/4 (для сравнения): " + frac4);

        System.out.println();

        // 2. Получение вещественных значений
        System.out.println("2. ВЕЩЕСТВЕННЫЕ ЗНАЧЕНИЯ:");
        System.out.println("-------------------------");
        System.out.println("• " + frac1 + " = " + frac1.getDecimalValue());
        System.out.println("• " + frac2 + " = " + frac2.getDecimalValue());
        System.out.println("• " + frac3 + " = " + frac3.getDecimalValue());

        System.out.println();

        // 3. Демонстрация кэширования
        System.out.println("3. ДЕМОНСТРАЦИЯ КЭШИРОВАНИЯ:");
        System.out.println("---------------------------");
        System.out.println("При первом вызове getDecimalValue() происходит вычисление:");
        double firstCall = frac1.getDecimalValue();
        System.out.println("• Первый вызов: " + firstCall);

        System.out.println("При повторном вызове значение берется из кэша:");
        double secondCall = frac1.getDecimalValue();
        System.out.println("• Второй вызов: " + secondCall);
        System.out.println("• Значения совпадают: " + (firstCall == secondCall));

        System.out.println();

        // 4. Демонстрация сравнения дробей
        System.out.println("4. СРАВНЕНИЕ ДРОБЕЙ:");
        System.out.println("--------------------");
        System.out.println("• " + frac1 + " равна " + frac4 + "? " + frac1.equals(frac4));
        System.out.println("• " + frac1 + " равна " + frac2 + "? " + frac1.equals(frac2));
        System.out.println("• " + frac1 + " равна " + frac3 + "? " + frac1.equals(frac3));

        System.out.println();

        // 5. Демонстрация изменения значений
        System.out.println("5. ИЗМЕНЕНИЕ ДРОБИ:");
        System.out.println("-------------------");
        System.out.println("Исходная дробь: " + frac1 + " = " + frac1.getDecimalValue());

        // Изменяем дробь
        frac1.setNumeratorAndDenominator(1, 2);
        System.out.println("После изменения на 1/2: " + frac1 + " = " + frac1.getDecimalValue());

        System.out.println();

        // 6. Демонстрация обработки ошибок
        System.out.println("6. ОБРАБОТКА ОШИБОК:");
        System.out.println("-------------------");
        try {
            Fraction invalidFraction = new Fraction(1, 0);
            System.out.println("Эта строка не будет напечатана");
        } catch (IllegalArgumentException e) {
            System.out.println("• Попытка создать дробь с знаменателем 0:");
            System.out.println("  Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
        System.out.println();
    }

    // Демонстрация задания 2
    public static void demonstrateTask2() {
        System.out.println("=== Демонстрация задания 2 (Количество мяуканий) ===");
        System.out.println();

        // 1. Создание кота и демонстрация базового функционала
        System.out.println("1. Создание кота и базовые методы:");
        Cat cat = new Cat("Барсик");
        System.out.println("Создан: " + cat);

        System.out.println("Одиночное мяуканье:");
        cat.meow();

        System.out.println("Многократное мяуканье (3 раза):");
        cat.meow(3);
        System.out.println();

        // 2. Создание обертки для подсчета мяуканий
        System.out.println("2. Создание счетчика мяуканий:");
        CountingCat countingCat = new CountingCat(cat);
        System.out.println("Создан счетчик для кота");
        System.out.println();

        // 3. Демонстрация работы через метод meowsCare
        System.out.println("3. Работа через метод meowsCare:");
        System.out.println("Перед вызовом: счетчик = " + countingCat.getMeowCount());

        // Вызываем метод meowsCare с нашим CountingCat
        Funs.meowsCare(countingCat);
        System.out.println("После первого вызова: счетчик = " + countingCat.getMeowCount());

        // Еще несколько вызовов
        Funs.meowsCare(countingCat);
        Funs.meowsCare(countingCat);
        System.out.println("После трех вызовов: счетчик = " + countingCat.getMeowCount());
        System.out.println();

        // 4. Демонстрация многократного мяуканья через счетчик
        System.out.println("4. Многократное мяуканье через счетчик:");
        System.out.println("Перед многократным мяуканьем: счетчик = " + countingCat.getMeowCount());
        countingCat.meow(5);
        System.out.println("После мяуканья 5 раз: счетчик = " + countingCat.getMeowCount());
        System.out.println();

        // 5. Демонстрация с коллекцией мяукающих объектов
        System.out.println("5. Работа с коллекцией мяукающих:");

        // Создаем несколько котов со счетчиками
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Васька");
        CountingCat countingCat1 = new CountingCat(cat1);
        CountingCat countingCat2 = new CountingCat(cat2);

        // Создаем коллекцию
        Meowable[] meowables = {countingCat1, countingCat2, countingCat1};

        System.out.println("Вызываем meowsCare для коллекции из 3 элементов...");
        Funs.meowsCare(Arrays.asList(meowables));

        System.out.println("Результаты:");
        System.out.println("- " + countingCat1 + " (мяукал 2 раза)");
        System.out.println("- " + countingCat2 + " (мяукал 1 раз)");

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Демонстрация задания 3
    public static void demonstrateTask3() {
        System.out.println("=== Демонстрация задания 3 (Удаление из списка) ===");
        System.out.println();

        // 1. Демонстрация с целыми числами
        System.out.println("1. Список целых чисел:");
        List<Integer> numbers = ListUtils.createList(1, 2, 3, 2, 4, 2, 5);
        System.out.println("Исходный список: " + numbers);

        ListUtils.removeAllOccurrences(numbers, 2);
        System.out.println("После удаления всех двоек: " + numbers);
        System.out.println();

        // 2. Демонстрация со строками
        System.out.println("2. Список строк:");
        List<String> words = ListUtils.createList("яблоко", "банан", "яблоко", "апельсин", "яблоко");
        System.out.println("Исходный список: " + words);

        ListUtils.removeAllOccurrences(words, "яблоко");
        System.out.println("После удаления всех 'яблоко': " + words);
        System.out.println();

        // 3. Демонстрация с дробными числами
        System.out.println("3. Список дробных чисел:");
        List<Double> doubles = ListUtils.createList(1.1, 2.2, 1.1, 3.3, 1.1, 4.4);
        System.out.println("Исходный список: " + doubles);

        ListUtils.removeAllOccurrences(doubles, 1.1);
        System.out.println("После удаления всех 1.1: " + doubles);
        System.out.println();

        // 4. Демонстрация с логическими значениями
        System.out.println("4. Список логических значений:");
        List<Boolean> booleans = ListUtils.createList(true, false, true, true, false);
        System.out.println("Исходный список: " + booleans);

        ListUtils.removeAllOccurrences(booleans, true);
        System.out.println("После удаления всех true: " + booleans);

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Демонстрация задания 4
    public static void demonstrateTask4() {
        System.out.println("=== Демонстрация задания 4 (Генерация логинов) ===");
        System.out.println();

        // 1. Демонстрация с готовыми данными
        System.out.println("1. Демонстрация с примером из задания:");

        List<Student> exampleStudents = new ArrayList<>();
        exampleStudents.add(new Student("Иванова", "Мария"));
        exampleStudents.add(new Student("Петров", "Сергей"));
        exampleStudents.add(new Student("Бойцова", "Екатерина"));
        exampleStudents.add(new Student("Петров", "Иван"));
        exampleStudents.add(new Student("Иванова", "Наташа"));

        List<Student> result = LoginGenerator.generateLogins(exampleStudents);
        System.out.println("Результат генерации логинов:");
        for (Student student : result) {
            System.out.println("  " + student);
        }
        System.out.println();

        // 2. Демонстрация чтения из файла
        System.out.println("2. Демонстрация работы с файлами:");
        String inputFile = "students.txt";
        String outputFile = "logins.txt";

        List<Student> fileStudents = LoginGenerator.readStudentsFromFile(inputFile);
        if (!fileStudents.isEmpty()) {
            System.out.println("Прочитано студентов из файла: " + fileStudents.size());
            List<Student> fileResult = LoginGenerator.generateLogins(fileStudents);

            System.out.println("Сгенерированные логины:");
            for (Student student : fileResult) {
                System.out.println("  " + student);
            }

            // Записываем результаты в файл
            LoginGenerator.writeResultsToFile(outputFile, fileResult);
        }

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Демонстрация задания 5
    public static void demonstrateTask5() {
        System.out.println("=== Демонстрация задания 5 (Звонкие согласные) ===");
        System.out.println();

        // 1. Демонстрация с готовым текстом
        System.out.println("1. Демонстрация с примером текста:");
        String demoText = "Сегодня прекрасная погода, солнце светит ярко, птицы поют веселые песни.";
        System.out.println("Текст: " + demoText);

        Set<Character> consonants = ConsonantFinder.findVoicedConsonants(demoText);
        ConsonantFinder.printConsonants(consonants);
        System.out.println();

        // 2. Демонстрация работы с файлом
        System.out.println("2. Демонстрация работы с файлом:");
        String inputFile = "text.txt";
        String outputFile = "consonants.txt";

        // Создаем тестовый файл с русским текстом
        createTextDemoFile(inputFile);

        String fileText = ConsonantFinder.readTextFromFile(inputFile);
        if (!fileText.isEmpty()) {
            System.out.println("Прочитан текст из файла:");
            System.out.println(fileText);
            System.out.println();

            Set<Character> fileConsonants = ConsonantFinder.findVoicedConsonants(fileText);
            ConsonantFinder.printConsonants(fileConsonants);

            // Записываем результаты в файл
            ConsonantFinder.writeConsonantsToFile(outputFile, fileConsonants);
        }

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Вспомогательный метод для создания демо-файла с текстом
    private static void createTextDemoFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("В саду растут высокие деревья и красивые цветы.");
            writer.println("Пчелы жужжат, собирая нектар с цветов.");
            writer.println("Дети играют в мяч и весело смеются.");
        } catch (IOException e) {
            System.out.println("Не удалось создать демо-файл: " + e.getMessage());
        }
    }

    // Демонстрация задания 6
    public static void demonstrateTask6() {
        System.out.println("=== Демонстрация задания 6 (Обращение очереди) ===");
        System.out.println();

        // 1. Демонстрация с числами
        System.out.println("1. Демонстрация с числами:");
        Queue<Integer> L1_numbers = QueueUtils.createQueue(1, 2, 3, 4, 5);
        Queue<Integer> L2_numbers = new LinkedList<>();

        System.out.println("Исходная очередь L1: " + QueueUtils.queueToString(L1_numbers));
        System.out.println("Целевая очередь L2 (до): " + QueueUtils.queueToString(L2_numbers));

        QueueUtils.reverseQueue(L1_numbers, L2_numbers);

        System.out.println("Очередь L1 (после): " + QueueUtils.queueToString(L1_numbers));
        System.out.println("Очередь L2 (после): " + QueueUtils.queueToString(L2_numbers));
        System.out.println();

        // 2. Демонстрация со строками
        System.out.println("2. Демонстрация со строками:");
        Queue<String> L1_strings = QueueUtils.createQueue("A", "B", "C", "D");
        Queue<String> L2_strings = new LinkedList<>();

        System.out.println("Исходная очередь L1: " + QueueUtils.queueToString(L1_strings));
        System.out.println("Целевая очередь L2 (до): " + QueueUtils.queueToString(L2_strings));

        QueueUtils.reverseQueue(L1_strings, L2_strings);

        System.out.println("Очередь L1 (после): " + QueueUtils.queueToString(L1_strings));
        System.out.println("Очередь L2 (после): " + QueueUtils.queueToString(L2_strings));
        System.out.println();

        // 3. Демонстрация с пустой очередью
        System.out.println("3. Демонстрация с пустой очередью:");
        Queue<Integer> emptyQueue = new LinkedList<>();
        Queue<Integer> targetQueue = new LinkedList<>();

        System.out.println("Исходная очередь L1: " + QueueUtils.queueToString(emptyQueue));
        System.out.println("Целевая очередь L2 (до): " + QueueUtils.queueToString(targetQueue));

        QueueUtils.reverseQueue(emptyQueue, targetQueue);

        System.out.println("Очередь L1 (после): " + QueueUtils.queueToString(emptyQueue));
        System.out.println("Очередь L2 (после): " + QueueUtils.queueToString(targetQueue));
        System.out.println();

        // 4. Демонстрация альтернативного метода
        System.out.println("4. Альтернативный метод (без изменения исходной очереди):");
        Queue<Integer> original = QueueUtils.createQueue(10, 20, 30, 40);
        Queue<Integer> reversed = QueueUtils.createReversedQueue(original);

        System.out.println("Исходная очередь: " + QueueUtils.queueToString(original));
        System.out.println("Обращенная очередь: " + QueueUtils.queueToString(reversed));
        System.out.println("Исходная очередь (не изменилась): " + QueueUtils.queueToString(original));

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Демонстрация задания 7
    public static void demonstrateTask7() {
        System.out.println("=== Демонстрация задания 7 (Стримы с точками) ===");
        System.out.println();

        // Демонстрация работы стрима
        List<Point> samplePoints = Arrays.asList(
                new Point(3, -4),   // Будет: {3.0;4.0}
                new Point(1, 2),    // Будет: {1.0;2.0}
                new Point(5, 7),    // Будет: {5.0;7.0}
                new Point(1, 2),    // Дубликат - УДАЛИТСЯ
                new Point(2, -5),   // Будет: {2.0;5.0}
                new Point(3, -4),   // Дубликат - УДАЛИТСЯ
                new Point(0, -1)    // Будет: {0.0;1.0}
        );

        System.out.println("Исходные точки:");
        samplePoints.forEach(point -> System.out.println("  " + point));
        System.out.println();

        System.out.println("Этапы обработки стримом:");
        System.out.println("1. distinct() - удаляем дубликаты {1.0;2.0} и {3.0;-4.0}");
        System.out.println("2. sorted() - сортируем по X: {0.0;-1.0}, {1.0;2.0}, {2.0;-5.0}, {3.0;-4.0}, {5.0;7.0}");
        System.out.println("3. map() - отрицательные Y делаем положительными");
        System.out.println("4. collect() - собираем в ломаную");
        System.out.println();

        Polyline result = GeometryStreamProcessor.processPoints(samplePoints);

        System.out.println("Результат обработки стримом:");
        System.out.println("Ломаная: " + result);
        System.out.println();

        // Проверка что дубликаты действительно удалены
        System.out.println("Проверка удаления дубликатов:");
        long originalCount = samplePoints.size();
        long distinctCount = result.getPoints().size();
        System.out.println("Исходное количество точек: " + originalCount);
        System.out.println("После distinct(): " + distinctCount);
        System.out.println("Удалено дубликатов: " + (originalCount - distinctCount));

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Демонстрация задания 8
    public static void demonstrateTask8() {
        System.out.println("=== Демонстрация задания 8 (Обработка людей) ===");
        System.out.println();

        // 1. Демонстрация с готовыми данными
        System.out.println("1. Демонстрация с примером из задания:");
        List<Person> examplePeople = Arrays.asList(
                new Person("Вася", 5),
                new Person("Петя", 3),
                new Person("Аня", 5),
                new Person("Маша", null),  // Без номера - будет отфильтрована
                new Person("КОЛЯ", 3),     // Будет преобразован в "Коля"
                new Person("анна", 7)      // Будет преобразована в "Анна"
        );

        System.out.println("Исходные люди:");
        examplePeople.forEach(person -> System.out.println("  " + person));
        System.out.println();

        Map<Integer, List<String>> result = PersonStreamProcessor.processPeople(examplePeople);

        System.out.println("Результат обработки стримом:");
        System.out.println(PersonStreamProcessor.formatResult(result));
        System.out.println();

        // 2. Демонстрация работы с файлом
        System.out.println("2. Демонстрация работы с файлом:");
        String inputFile = "people.txt";
        String outputFile = "result.txt";

        // Создаем тестовый файл
        createPeopleDemoFile(inputFile);

        List<Person> filePeople = PersonStreamProcessor.readPeopleFromFile(inputFile);
        if (!filePeople.isEmpty()) {
            System.out.println("Прочитано людей из файла: " + filePeople.size());
            System.out.println("Исходные данные:");
            filePeople.forEach(person -> System.out.println("  " + person));
            System.out.println();

            Map<Integer, List<String>> fileResult = PersonStreamProcessor.processPeople(filePeople);

            System.out.println("Результат обработки:");
            System.out.println(PersonStreamProcessor.formatResult(fileResult));

            // Записываем результаты в файл
            PersonStreamProcessor.writeResultToFile(outputFile, fileResult);
        }

        System.out.println();
        System.out.println("=== Демонстрация завершена ===");
        System.out.println();
    }

    // Вспомогательный метод для создания демо-файла с людьми
    private static void createPeopleDemoFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Вася:5");
            writer.println("Петя:3");
            writer.println("Аня:5");
            writer.println("Маша:");        // Без номера
            writer.println("КОЛЯ:3");
            writer.println("анна:7");
            writer.println("Сергей:");      // Без номера
            writer.println("ОЛЯ:7");
        } catch (IOException e) {
            System.out.println("Не удалось создать демо-файл: " + e.getMessage());
        }
    }
}
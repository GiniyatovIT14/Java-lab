package ru.Giniyatov.PersonStream;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

// Класс для обработки данных о людях с помощью стримов
public class PersonStreamProcessor {

    // Чтение людей из файла
    public static List<Person> readPeopleFromFile(String filename) {
        List<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Разделяем имя и номер
                String[] parts = line.split(":");
                if (parts.length >= 1) {
                    String name = parts[0].trim();
                    Integer number = null;

                    // Пытаемся получить номер, если он есть
                    if (parts.length >= 2 && !parts[1].trim().isEmpty()) {
                        try {
                            number = Integer.parseInt(parts[1].trim());
                        } catch (NumberFormatException e) {
                            // Номер невалидный - оставляем null
                        }
                    }

                    people.add(new Person(name, number));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл '" + filename + "' не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return people;
    }

    // Основной метод обработки стримом
    public static Map<Integer, List<String>> processPeople(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return new HashMap<>();
        }

        return people.stream()
                // Убираем людей без номеров
                .filter(person -> person.getNumber() != null)
                // Приводим имена к нужному формату
                .map(person -> {
                    String formattedName = formatName(person.getName());
                    return new Person(formattedName, person.getNumber());
                })
                // Группируем по номеру
                .collect(Collectors.groupingBy(
                        Person::getNumber,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));
    }

    // Форматирование имени: нижний регистр, но первая буква заглавная
    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        String lowerCaseName = name.toLowerCase();
        if (lowerCaseName.length() == 1) {
            return lowerCaseName.toUpperCase();
        }

        return lowerCaseName.substring(0, 1).toUpperCase() +
                lowerCaseName.substring(1);
    }

    // Запись результата в файл
    public static void writeResultToFile(String filename, Map<Integer, List<String>> result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(formatResult(result));
            System.out.println("Результат записан в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    // Форматирование результата для вывода
    public static String formatResult(Map<Integer, List<String>> result) {
        if (result.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        // Сортируем по номеру для красивого вывода
        List<Integer> sortedKeys = new ArrayList<>(result.keySet());
        Collections.sort(sortedKeys);

        for (Integer number : sortedKeys) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(number).append(":[");

            List<String> names = result.get(number);
            Collections.sort(names); // Сортируем имена по алфавиту

            for (int i = 0; i < names.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(names.get(i));
            }
            sb.append("]");
            first = false;
        }
        sb.append("]");

        return sb.toString();
    }
}

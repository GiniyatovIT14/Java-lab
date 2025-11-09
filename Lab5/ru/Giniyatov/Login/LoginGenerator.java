package ru.Giniyatov.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class LoginGenerator {

    // Генерация логинов из списка студентов
    public static List<Student> generateLogins(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return new ArrayList<>();
        }

        Map<String, Integer> lastNameCount = new HashMap<>();
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            String lastName = student.getLastName();

            // Получаем текущий счетчик для фамилии
            int count = lastNameCount.getOrDefault(lastName, 0) + 1;
            lastNameCount.put(lastName, count);

            // Создаем логин
            String login = (count == 1) ? lastName : lastName + count;

            // Создаем копию студента с логином
            Student studentWithLogin = new Student(student.getLastName(), student.getFirstName());
            studentWithLogin.setLogin(login);
            result.add(studentWithLogin);
        }

        return result;
    }

    // Чтение студентов из файла
    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            int expectedCount = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                lineNumber++;

                // Первая строка - количество студентов
                if (lineNumber == 1) {
                    try {
                        expectedCount = Integer.parseInt(line);
                        if (expectedCount < 0 || expectedCount > 100) {
                            System.out.println("Ошибка: количество студентов должно быть от 0 до 100");
                            return new ArrayList<>();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: первая строка должна содержать число");
                        return new ArrayList<>();
                    }
                    continue;
                }

                // Пропускаем строки сверх ожидаемого количества
                if (lineNumber > expectedCount + 1) {
                    break;
                }

                // Разделяем фамилию и имя
                String[] parts = line.split("\\s+", 2);
                if (parts.length != 2) {
                    System.out.println("Ошибка в строке " + lineNumber + ": неверный формат");
                    continue;
                }

                String lastName = parts[0].trim();
                String firstName = parts[1].trim();

                // Проверка длины фамилии и имени
                if (lastName.length() > 20) {
                    System.out.println("Предупреждение: фамилия '" + lastName + "' слишком длинная, обрезана до 20 символов");
                    lastName = lastName.substring(0, 20);
                }

                if (firstName.length() > 15) {
                    System.out.println("Предупреждение: имя '" + firstName + "' слишком длинное, обрезано до 15 символов");
                    firstName = firstName.substring(0, 15);
                }

                students.add(new Student(lastName, firstName));
            }

            // Проверка количества прочитанных студентов
            if (students.size() != expectedCount) {
                System.out.println("Предупреждение: ожидалось " + expectedCount + " студентов, прочитано " + students.size());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл '" + filename + "' не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return students;
    }

    // Запись результатов в файл
    public static void writeResultsToFile(String filename, List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getLogin());
            }
            System.out.println("Результаты записаны в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}

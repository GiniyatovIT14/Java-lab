package ru.Giniyatov.Finder;

import java.util.*;
import java.io.*;

// Класс для поиска звонких согласных букв в тексте
public class ConsonantFinder {

    // Множество звонких согласных букв русского языка
    private static final Set<Character> VOICED_CONSONANTS = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    );

    // Чтение текста из файла
    public static String readTextFromFile(String filename) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл '" + filename + "' не найден");
            return "";
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return "";
        }

        return text.toString().trim();
    }

    // Поиск уникальных звонких согласных букв
    public static Set<Character> findVoicedConsonants(String text) {
        Set<Character> consonants = new TreeSet<>(); // TreeSet для автоматической сортировки

        if (text == null || text.isEmpty()) {
            return consonants;
        }

        text = text.toLowerCase(); // Приводим к нижнему регистру для удобства сравнения

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Проверяем, является ли символ звонкой согласной буквой русского алфавита
            if (isRussianVoicedConsonant(c)) {
                consonants.add(c);
            }
        }

        return consonants;
    }

    // Проверка, является ли символ звонкой согласной буквой русского алфавита
    private static boolean isRussianVoicedConsonant(char c) {
        return VOICED_CONSONANTS.contains(c);
    }

    // Вывод результата в консоль
    public static void printConsonants(Set<Character> consonants) {
        if (consonants.isEmpty()) {
            System.out.println("В тексте не найдено звонких согласных букв.");
            return;
        }

        System.out.println("Найденные звонкие согласные буквы (в алфавитном порядке):");
        for (char c : consonants) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Запись результата в файл
    public static void writeConsonantsToFile(String filename, Set<Character> consonants) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            if (consonants.isEmpty()) {
                writer.println("В тексте не найдено звонких согласных букв.");
            } else {
                writer.println("Найденные звонкие согласные буквы (в алфавитном порядке):");
                for (char c : consonants) {
                    writer.print(c + " ");
                }
                writer.println();
            }
            System.out.println("Результат записан в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
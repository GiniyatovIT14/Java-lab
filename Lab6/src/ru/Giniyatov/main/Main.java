package ru.Giniyatov.main;

import ru.Giniyatov.DemonstrateTasks.DemonstrateTasks;

import java.util.Scanner;

/**
 * Главный класс приложения для лабораторной работы №6.
 * Демонстрирует работу с аннотациями и тестированием.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Главный метод приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("Лабораторная работа №6: ИНСТРУМЕНТИРОВАНИЕ КОДА");
        System.out.println("Вариант 4");
        System.out.println("==================================================\n");

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    DemonstrateTasks.demonstrateTask1();
                    break;
                case 2:
                    DemonstrateTasks.demonstrateTask2();
                    break;
                case 3:
                    DemonstrateTasks.demonstrateTask3();
                    break;
                case 4:
                    DemonstrateTasks.demonstrateTask4();
                    break;
                case 5:
                    DemonstrateTasks.demonstrateTask5();
                    break;
                case 6:
                    DemonstrateTasks.demonstrateTask6();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.\n");
            }
        }

        scanner.close();
    }

    /**
     * Отображение главного меню.
     */
    private static void displayMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1 - Задание 1: @Invoke");
        System.out.println("2 - Задание 2: @Default");
        System.out.println("3 - Задание 3: @ToString");
        System.out.println("4 - Задание 4: @Validate");
        System.out.println("5 - Задание 5: @Two");
        System.out.println("6 - Задание 6: @Cache");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт меню: ");
    }

    /**
     * Получение и валидация выбора меню.
     *
     * @return выбранный пункт меню
     */
    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите число: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return choice;
    }
}


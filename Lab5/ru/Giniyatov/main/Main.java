package ru.Giniyatov.main;
import ru.Giniyatov.DemonstrateTasks.*;
import ru.Giniyatov.InteractiveTasks.*;
import java.util.Scanner;

// Главный класс приложения
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная работа: ШАБЛОНЫ ООП И КОЛЛЕКЦИИ");
        System.out.println("=============================================\n");

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    DemonstrateTasks.demonstrateTask1();
                    InteractiveTasks.interactiveTask1();
                    break;
                case 2:
                    DemonstrateTasks.demonstrateTask2();
                    InteractiveTasks.interactiveTask2();
                    break;
                case 3:
                    DemonstrateTasks.demonstrateTask3();
                    InteractiveTasks.interactiveTask3();
                    break;
                case 4:
                    DemonstrateTasks.demonstrateTask4();
                    InteractiveTasks.interactiveTask4();
                    break;
                case 5:
                    DemonstrateTasks.demonstrateTask5();;
                    InteractiveTasks.interactiveTask5();
                    break;
                case 6:
                    DemonstrateTasks.demonstrateTask6();
                    InteractiveTasks.interactiveTask6();
                case 7:
                    DemonstrateTasks.demonstrateTask7();
                    InteractiveTasks.interactiveTask7();
                case 8:
                    DemonstrateTasks.demonstrateTask8();
                    InteractiveTasks.interactiveTask8();
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

    // Отображение меню
    private static void displayMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1 - Работа с дробями");
        System.out.println("2 - Количество мяуканий");
        System.out.println("3 - Удаление элементов из списка");
        System.out.println("4 - Генератор логинов для студентов");
        System.out.println("5 - Поиск звонких");
        System.out.println("6 - Очередь в обратном порядке");
        System.out.println("7 - (Стримы) Ломанная");
        System.out.println("8 - (Стримы) Люди и номера");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт меню: ");
    }

    // Получение и валидация выбора меню
    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите число: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
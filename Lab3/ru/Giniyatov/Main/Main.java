package ru.Giniyatov.Main;

import ru.Giniyatov.Menu.correctInput;
import ru.Giniyatov.Menu.taskManager;

import java.awt.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;


public class Main {
    public static void main(String[] args) {

        if (args.length >= 2) {
            String xStr = args[0];
            String yStr = args[1];
            double result = power(xStr, yStr);
            System.out.printf("Результат возведения " + xStr + " в степень " + yStr + ": " + result);
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        taskManager taskManager = new taskManager(scanner);

        while (true) {
            showTasks();

            System.out.print("Выберите задачу -> ");
            int choice = correctInput.correctChoice(scanner);

            switch (choice) {
                case 1:
                    taskManager.reshPistolModiff();
                    break;
                case 2:
                    taskManager.reshNameModiff();
                    break;
                case 3:
                    taskManager.reshPhoneBook();
                    break;
                case 4:
                    taskManager.reshAutomaticWeapon();
                    break;
                case 5:
                    System.out.println("Демонстрация идентичная с задачей №1");
                    break;
                case 6:
                    taskManager.reshShooter();
                    break;
                case 7:
                    taskManager.reshPoint();
                    break;
                case 8:
                    ShooterDemonstrate.demoShooters();
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    System.exit(0);
                default:
                    System.out.println("Введена некорректная задача!");
                    break;
            }
        }
    }

    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }

    public static void showTasks() {
        System.out.println("\n=== ВЫБОР ЗАДАЧИ ===");
        System.out.println("1. Пистолет перезаряжается");
        System.out.println("2. Непустые имена");
        System.out.println("3. Желтые страницы (справочник)");
        System.out.println("4. Автомат");
        System.out.println("5. Наследованный пистолет (демонстрация идентична с з. 1)");
        System.out.println("6. Стрелок");
        System.out.println("7. Сравнение точек");
        System.out.println("8. Демонстрация Shooter");
        System.out.println("0. Выход");
    }
}
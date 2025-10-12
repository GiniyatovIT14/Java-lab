package ru.Giniyatov.Menu;

import java.util.Scanner;

public class correctInput {
    public static int correctChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("Ошибка! Введите число.");
                scanner.next();
                System.out.print("Повторите ввод -> ");
            }
        }
    }
}

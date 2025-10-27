import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateBox();
                    reshTasks.reshBox();
                    break;
                case 2:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateComparable();
                    reshTasks.reshComparable();
                    break;
                case 3:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateMaxSearch();
                    reshTasks.reshMaxSearch();
                    break;
                case 4:
                    System.out.println("\n=========================");
                    demonstrateTasks.demonstrateFunction();
                    reshTasks.reshFunction();
                    break;
                case 5:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateFilter();
                    reshTasks.reshFilter();
                    break;
                case 6:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateReduce();
                    reshTasks.reshReduce();
                    break;
                case 7:
                    System.out.println("\n========================");
                    demonstrateTasks.demonstrateCollect();
                    reshTasks.reshCollect();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

            if (!exit) {
                System.out.println("\nНажмите Enter чтобы продолжить...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n===== Список задач =====");
        System.out.println("1. Обобщенная коробка");
        System.out.println("2. Интерфейс Сравнимое");
        System.out.println("3. Поиск максимума в коробках");
        System.out.println("4. Функциональное преобразование");
        System.out.println("5. Фильтрация списков");
        System.out.println("6. Свертка списков");
        System.out.println("7. Коллекционирование");
        System.out.println("0. Выход");
        System.out.println("========================");
        System.out.print("Выберите задачу: ");
    }

    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите номер задачи: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
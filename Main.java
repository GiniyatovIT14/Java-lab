import java.awt.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class correctInput {            // класс с методами проверки входных данных для каждой задачиж
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

    public static String correctNameInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return input;
            }

            boolean isCorrect = true;
            for (int i = 0; i < input.length(); i++) {
                char el = input.charAt(i);
                int ascii = (int) el;

                boolean isEng = (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122);
                boolean isRuss = (ascii >= 1040 && ascii <= 1071) || (ascii >= 1072 && ascii <= 1103) ||
                        (ascii == 1025) || (ascii == 1105);
                boolean isSpec = (ascii == 45) || (ascii == 32);

                if (!(isEng || isRuss || isSpec)) {
                    System.out.println("Введен недопустимый символ -> " + el);
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                return input;
            } else {
                System.out.print("Попробуйте снова -> ");
            }
        }
    }

    public static int correctHeight(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;
            } else {
                System.out.print("Ошибка! Рост - целое число. Повторите ввод -> ");
                scanner.next();
            }
        }
    }
}

class taskManager {
    private Scanner scanner;

    public taskManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void reshNameTask() {
        System.out.println("=== Задача с именами ===");

        System.out.println("===== Демонстрация ======");
        Name cleopatra = new Name(null, "Клеопатра", null);
        Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovsky = new Name("Маяковский", "Владимир", null);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
        System.out.println("=========================\n");

        System.out.print("Введите имя -> ");
        String lastName = correctInput.correctNameInput(scanner);
        System.out.print("Введите фамилию -> ");
        String firstName = correctInput.correctNameInput(scanner);
        System.out.print("Введите отчество -> ");
        String patronymic = correctInput.correctNameInput(scanner);

        Name name = new Name(
                lastName.isEmpty() ? null : lastName,
                firstName.isEmpty() ? null : firstName,
                patronymic.isEmpty() ? null : patronymic
        );

        System.out.println("Результат -> " + name);
    }

    public void reshHumanTask() {
        System.out.println("=== Задача с людьми ===");

        System.out.println("===== Демонстрация =====");
        Human cleopatra = new Human("Клеопатра", 152);
        Human pushkin = new Human("Пушкин", 167);
        Human vladimir = new Human("Владимир", 189);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(vladimir);
        System.out.println("=========================\n");

        System.out.println("Создайте своего человека -> ");

        System.out.print("Введите имя -> ");
        String name = correctInput.correctNameInput(scanner);


        System.out.print("Введите рост (см): ");
        int height = correctInput.correctHeight(scanner);

        // Создаем объект человека
        Human customPerson = new Human(name.isEmpty() ? "Неизвестно" : name, height);

        System.out.println("Результат: " + customPerson);
    }

    public void reshEmployee() {
        System.out.println("=== Задача с сотрудниками и отделами ===");

        System.out.println("Создаем Петрова, Козлова, Сидорова и отдел IT:");

        Employee kozlov = new Employee("Козлов", "IT");
        Employee petrov = new Employee("Петров", "IT", kozlov);
        Employee sidorov = new Employee("Сидоров", "IT", kozlov);

        System.out.println("Козлов назначен начальником отдела IT\n");

        System.out.println("Результат:");
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);

        System.out.print("Желаете ли создать своих сотрудников и отдел? (1 - Да; 0 - Нет) -> ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                System.out.println("Выход из задачи...");
                return;
            case 1:
                System.out.print("Создадим отдел. Введите его название -> ");
                String depName = correctInput.correctNameInput(scanner);

                System.out.print("Введите имя начальника -> ");
                String nameBoss = correctInput.correctNameInput(scanner);
                Employee boss = new Employee(nameBoss, depName);

                List<Employee> personal = new ArrayList<>();
                personal.add(boss);

                System.out.print("Введите желаемое количество сотрудников -> ");
                int countPerson = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < countPerson; i++) {
                    System.out.print("Имя сотрудника " + (i+1) + " -> ");
                    String nameEmp = correctInput.correctNameInput(scanner);

                    if (!nameEmp.isEmpty()) {
                        Employee employee = new Employee(nameEmp, depName, boss);
                        personal.add(employee);
                    }
                }

                System.out.println("\nРезультат:");
                for (Employee emp : personal) {
                    System.out.println(emp);
                }
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
    public void reshEmployeeModified() {
        System.out.println("=== Задача с сотрудниками и отделами (модифицированная) ===");

        EmployeeModified kozlov = new EmployeeModified("Козлов", "IT");
        EmployeeModified petrov = new EmployeeModified("Петров", "IT", kozlov);
        EmployeeModified sidorov = new EmployeeModified("Сидоров", "IT", kozlov);

        System.out.println("Сотрудники:");
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);

        System.out.println("\nСписок сотрудников отдела:");
        System.out.println("Через Петрова:");
        List<EmployeeModified> employeesFromPetrov = petrov.getDepartmentEmployees();
        for (EmployeeModified emp : employeesFromPetrov) {
            System.out.println("- " + emp.getName());
        }
    }

    public void reshNameModiffTask() {
        System.out.println("=== Задача с именами (новые требования) ===");

        NameModiff cleopatra = new NameModiff("Клеопатра");

        NameModiff pushkin = new NameModiff("Александр", "Пушкин", "Сергеевич");

        NameModiff mayakovsky = new NameModiff("Владимир", "Маяковский");

        NameModiff hristofor = new NameModiff("Христофор", "Бонифатьевич");

        System.out.println("Созданные имена:");
        System.out.println("1. " + cleopatra);
        System.out.println("2. " + pushkin);
        System.out.println("3. " + mayakovsky);
        System.out.println("4. " + hristofor);
    }

    public void reshPistolTask() {
        System.out.println("=== Задача с пистолетом ===");

        Pistol pistol = new Pistol(3);
        System.out.println("Создан: " + pistol);

        System.out.println("\nСтреляем 5 раз:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Выстрел " + i + ": ");
            pistol.shoot();
        }

        System.out.println("\nИтоговое состояние: " + pistol);

        System.out.println("\n=== Дополнительная демонстрация ===");

        Pistol defaultPistol = new Pistol();
        System.out.println("Пистолет по умолчанию: " + defaultPistol);

        System.out.print("Выстрел: ");
        defaultPistol.shoot();
        System.out.println("Осталось патронов: " + defaultPistol.getBullets());
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        taskManager taskManager = new taskManager(scanner);

        while (true) {
            showTasks();

            System.out.print("Выберите задачу -> ");
            int choice = correctInput.correctChoice(scanner);

            switch (choice) {
                case 1:
                    taskManager.reshNameTask();
                    break;
                case 2:
                    taskManager.reshHumanTask();
                    break;
                case 3:
                    taskManager.reshEmployee();
                    break;
                case 4:
                    taskManager.reshEmployeeModified();
                    break;
                case 5:
                    taskManager.reshNameModiffTask();
                    break;
                case 6:
                    taskManager.reshPistolTask();
                    break;
                default:
                    System.out.println("Введена некорректная задача!");
                    break;
            }
        }
    }

    private static void showTasks() {
        System.out.println("\n=== ВЫБОР ЗАДАЧИ ===");
        System.out.println("1. Имена");
        System.out.println("2. Человек");
        System.out.println("3. Сотрудники и отделы");
        System.out.println("4. Сотрудники и отделы (изм.)");
        System.out.println("5. Имена (изм.)");
        System.out.println("6. Пистолет");
    }
}
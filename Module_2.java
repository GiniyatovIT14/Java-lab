import java.util.Scanner;

public class Module_2 {
    public static double SafeDiv(int x, int y) {        // task 2.2
        if (y == 0)
            return 0;
        else
            return (double) x / y;
    }

    public static String makeDecision(int x, int y) {       // task 2.4
        if (x == y)
            return ("Результат: " + x + " == " + y);
        else if (x > y)
            return ("Результат: " + x + " > " + y);
        else
            return ("Результат: " + x + " < " + y);
    }

    public static boolean sum3(int x, int y, int z) {       // task 2.6
        if ((x + y == z) || (x + z == y) || (y + z == x)) {
            return true;
        }
        else
            return false;
    }

    public static String age(int x) {       // task 2.8
        if ((x % 10 == 1) & (x % 100 != 11))
            return ("Результат -> " + x + " год");
        else if (((x % 10 == 2) || (x % 10 == 3) || (x % 10 == 4)) & (x % 100 != 12 & x % 100 != 13 & x % 100 != 14)) {
            return ("Результат -> " + x + " года");
        }
        else
            return ("Результат -> " + x + " лет");
    }

    public static void printDays (String x) {       // task 2.10
        System.out.println("Результат:");
        switch (x) {
            case "понедельник":
                System.out.println(" понедельник\n вторник\n среда\n четверг\n пятница\n суббота\n воскресенье");
                break;
            case "вторник":
                System.out.println(" вторник\n среда\n четверг\n пятница\n суббота\n воскресенье");
                break;
            case "среда":
                System.out.println(" среда\n четверг\n пятница\n суббота\n воскресенье");
                break;
            case "четверг":
                System.out.println(" четверг\n пятница\n суббота\n воскресенье");
                break;
            case "пятница":
                System.out.println(" пятница\n суббота\n воскресенье");
                break;
            case "суббота":
                System.out.println(" суббота\n воскресенье");
                break;
            case "воскресенье":
                System.out.println(" воскресенье");
            default:
                System.out.println("Это не день недели!");
        }
    }

    public static void reshSafeDiv() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите делимое -> ");
        int num1 = scanner.nextInt();
        System.out.print("Введите делитель -> ");
        int num2 = scanner.nextInt();

        double res = SafeDiv(num1, num2);
        System.out.println("Результат -> " + res);

        scanner.close();
    }

    public static void reshMakeDecision() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число -> ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число -> ");
        int num2 = scanner.nextInt();

        String res = makeDecision(num1, num2);
        System.out.println(res);

        scanner.close();
    }

    public static void reshSum3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число -> ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число -> ");
        int num2 = scanner.nextInt();
        System.out.print("Введите третье число -> ");
        int num3 = scanner.nextInt();

        boolean res = sum3(num1,num2, num3);
        System.out.println("Результат -> " + res);

        scanner.close();
    }

    public static void reshAge() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите возраст -> ");
        int num = scanner.nextInt();

        String res = age(num);
        System.out.println(res);

        scanner.close();
    }

    public static void reshPrintDays() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите день недели (со строчной буквы) -> ");
        String str = scanner.next();

        printDays(str);

        scanner.close();
    }
}


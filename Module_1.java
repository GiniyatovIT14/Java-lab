import java.util.Scanner;

public class Module_1 {
    public static int sumLastNums(int x) {      // task 1.2

        if (x < 0) {
            System.out.println("Задано отрицательное число! Выход из программы...");
            System.exit(1);
        }

        int last = x % 10;
        int lastlast = (x / 10) % 10;

        return last + lastlast;
    }

    public static boolean isPositive(int x) {       // task 1.4
        if (x >= 0) return true;
        else return false;
    }

    public static boolean isUpperCase (char x) {        // task 1.6
        if (Character.isUpperCase(x))
            return true;
        else if (Character.isLowerCase(x))
            return false;
        else {
            System.out.println("Введен некорректный символ!");
            System.exit(1);
            return false;
        }
    }

    public static boolean isDivisor(int a, int b) {     // task 1.8
        if (a % b == 0) return true;
        else if (b % a == 0) return true;
        else return false;
    }

    public static int lastNumSum (int a, int b) {       // task 1.10
        return (a % 10) + (b % 10);
    }

    public static void reshSumLastNums() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число -> ");
        int num = scanner.nextInt();
        int res = sumLastNums(num);

        System.out.println("Сумма двух последних цифр заданного числа -> " + res);

        scanner.close();
    }

    public static void reshIsPostitve() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число -> ");
        int num = scanner.nextInt();
        boolean res = isPositive(num);

        System.out.println("Проверка... Результат -> " + res);

        scanner.close();
    }

    public static void reshIsUpperCase() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите символ -> ");
        char alpha = scanner.next().charAt(0);
        boolean res = isUpperCase(alpha);

        System.out.println("Проверка... Результат -> " + res);

        scanner.close();
    }

    public static void reshIsDivisor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число -> ");
        int num1 = scanner.nextInt();
        System.out.print("Введите первое число -> ");
        int num2 = scanner.nextInt();

        boolean res = isDivisor(num1, num2);
        System.out.print("Проверка... Результат -> " + res);

        scanner.close();
    }

    public static void reshLastNumSum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число №1 -> ");
        int num1 = scanner.nextInt();
        System.out.print("Введите число №2 -> ");
        int num2 = scanner.nextInt();

        int res = lastNumSum(num1, num2);
        System.out.println(num1 + " + " + num2 + " это " + res);

        for (int i = 3; i <=5; i++) {
            System.out.print("Введите число №" + i + " -> ");
            int num_i = scanner.nextInt();

            int res_i = lastNumSum(res, num_i);
            System.out.println(res + " + " + num_i + " это " + res_i);

            res = res_i;
        }
        System.out.println("Итого -> " + res);
        scanner.close();
    }

}

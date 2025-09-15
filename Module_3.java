import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

public class Module_3 {
    public static String reverseListNums(int x) {       // task 3.2
        StringBuilder res = new StringBuilder();

        if (x >= 0) {
            for (int i = x; i != -1; i--) {
                res.append(i);
                res.append(" ");
            }
        }
        else {
            for (int i = x; i != 1; i++) {
                res.append(i);
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static int pow(int x, int y) {       // task 3.4
        int res = 1;

        if (y == 0)
            return 1;

        for (int i = 0; i < y; i++) {
            res *= x;
        }
        return res;
    }

    public static boolean equalNum (int x) {       // task 3.6
        if (x < 10 & x > -10)
            return true;

        int num_x = Math.abs(x);
        int last = num_x % 10;

        while (num_x > 0) {
            if (num_x % 10 != last)
                return false;
            num_x /= 10;
        }

        return true;
    }

    public static void leftTriangle(int x) {        // task 3.8
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void reshReverseListNums() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число x -> ");
        int x = scanner.nextInt();

        String res = reverseListNums(x);
        System.out.println("Результат -> " + res);

        scanner.close();
    }

    public static void reshPow() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число -> ");
        int num = scanner.nextInt();
        System.out.print("Введите степень, в которую хотите возвести число -> ");
        int power = scanner.nextInt();

        int res = pow(num, power);
        System.out.println("Результат -> " + res);

        scanner.close();
    }

    public static void reshEqualNum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число -> ");
        int num = scanner.nextInt();

        boolean res = equalNum(num);
        System.out.println("Результат -> " + res);

        scanner.close();
    }

    public static void reshLeftTriangle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите высоту треугольника -> ");
        int x = scanner.nextInt();

        System.out.println("Треугольник: ");
        leftTriangle(x);

        scanner.close();
    }

    public static void reshGuessGame() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int random_num = random.nextInt(10);
        System.out.println("Число успешно загадано!");

        int attempt = 0;
        int guess = 100;

        while (guess != random_num) {
            System.out.print("Попробуйте угадать загаданное число (0-9) -> ");

            if (scanner.hasNext()) {
                guess = scanner.nextInt();

                if (guess < 0 || guess > 9) {
                    System.out.println("Число должно быть от 0 до 9!");
                    continue;
                }

                attempt++;

                if (guess == random_num) {
                    System.out.println("Вы угадали число! Это число " + random_num);
                    System.out.println("Количество попыток -> " + attempt);
                }
                else {
                    System.out.println("К сожалению, вы не угадали. Попробуйте еще раз!");
                    scanner.next();
                }
            }
        }

    }


}
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Module_1 {
    Scanner scanner = new Scanner(System.in);

    public int sumLastNums(int x) {      // task 1.2
        if (x < 0) {
            System.out.println("Задано отрицательное число! Выход из программы...");
            System.exit(1);
        }

        int last = x % 10;
        int lastlast = (x / 10) % 10;

        return last + lastlast;
    }

    public boolean isPositive(int x) {       // task 1.4
        if (x >= 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isUpperCase(char x) {        // task 1.6
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

    public boolean isDivisor(int a, int b) {     // task 1.8
        if (a % b == 0) return true;
        else if (b % a == 0) return true;
        else return false;
    }

    public int lastNumSum(int a, int b) {       // task 1.10
        return (a % 10) + (b % 10);
    }

    public void reshSumLastNums() {
        System.out.print("Введите число -> ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        int res = sumLastNums(num);

        System.out.println("Сумма двух последних цифр заданного числа -> " + res);
    }

    public void reshIsPostitve() {
        System.out.print("Введите число -> ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        boolean res = isPositive(num);

        System.out.println("Проверка... Результат -> " + res);
    }

    public void reshIsUpperCase() {
        System.out.print("Введите символ -> ");
        char alpha = scanner.next().charAt(0);
        boolean res = isUpperCase(alpha);

        System.out.println("Проверка... Результат -> " + res);
    }

    public void reshIsDivisor() {
        System.out.print("Введите первое число -> ");
        int num1;
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите второе число -> ");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        boolean res = isDivisor(num1, num2);
        System.out.print("Проверка... Результат -> " + res);
    }

    public void reshLastNumSum() {
        System.out.print("Введите число №1 -> ");
        int num1;
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите число №2 -> ");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int res = lastNumSum(num1, num2);
        System.out.println(num1 + " + " + num2 + " это " + res);

        for (int i = 3; i <= 5; i++) {
            System.out.print("Введите число №" + i + " -> ");
            int num_i;
            if (scanner.hasNextInt()) {
                num_i = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }

            int res_i = lastNumSum(res, num_i);
            System.out.println(res + " + " + num_i + " это " + res_i);

            res = res_i;
        }
        System.out.println("Итого -> " + res);
    }

}

class Module_2 {
    Scanner scanner = new Scanner(System.in);

    public double SafeDiv(int x, int y) {        // task 2.2
        if (y == 0)
            return 0;
        else
            return (double) x / y;
    }

    public String makeDecision(int x, int y) {       // task 2.4
        if (x == y)
            return ("Результат: " + x + " == " + y);
        else if (x > y)
            return ("Результат: " + x + " > " + y);
        else
            return ("Результат: " + x + " < " + y);
    }

    public boolean sum3(int x, int y, int z) {       // task 2.6
        if ((x + y == z) || (x + z == y) || (y + z == x)) {
            return true;
        } else
            return false;
    }

    public String age(int x) {       // task 2.8
        if ((x % 10 == 1) & (x % 100 != 11))
            return ("Результат -> " + x + " год");
        else if (((x % 10 == 2) || (x % 10 == 3) || (x % 10 == 4)) & (x % 100 != 12 & x % 100 != 13 & x % 100 != 14)) {
            return ("Результат -> " + x + " года");
        } else
            return ("Результат -> " + x + " лет");
    }

    public void printDays(String x) {       // task 2.10
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
                break;
            default:
                System.out.println("Это не день недели!");
        }
    }

    public void reshSafeDiv() {
        System.out.print("Введите делимое -> ");
        int num1;
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите делитель -> ");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        double res = SafeDiv(num1, num2);
        System.out.println("Результат -> " + res);
    }

    public void reshMakeDecision() {
        System.out.print("Введите первое число -> ");
        int num1;
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите второе число -> ");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        String res = makeDecision(num1, num2);
        System.out.println(res);
    }

    public void reshSum3() {
        System.out.print("Введите первое число -> ");
        int num1;
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите второе число -> ");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите третье число -> ");
        int num3;
        if (scanner.hasNextInt()) {
            num3 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        boolean res = sum3(num1, num2, num3);
        System.out.println("Результат -> " + res);
    }

    public void reshAge() {
        System.out.print("Введите возраст -> ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        String res = age(num);
        System.out.println(res);
    }

    public void reshPrintDays() {
        System.out.print("Введите день недели (со строчной буквы) -> ");
        String str = scanner.next();

        printDays(str);
    }
}

class Module_3 {
    Scanner scanner = new Scanner(System.in);

    public String reverseListNums(int x) {       // task 3.2
        StringBuilder res = new StringBuilder();

        if (x >= 0) {
            for (int i = x; i != -1; i--) {
                res.append(i);
                res.append(" ");
            }
        } else {
            for (int i = x; i != 1; i++) {
                res.append(i);
                res.append(" ");
            }
        }
        return res.toString();
    }

    public int pow(int x, int y) {       // task 3.4
        int res = 1;

        if (y == 0)
            return 1;

        for (int i = 0; i < y; i++) {
            res *= x;
        }
        return res;
    }

    public boolean equalNum(int x) {       // task 3.6
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

    public void leftTriangle(int x) {        // task 3.8
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public void reshReverseListNums() {
        System.out.print("Введите число x -> ");
        int x;
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        String res = reverseListNums(x);
        System.out.println("Результат -> " + res);
    }

    public void reshPow() {
        System.out.print("Введите число -> ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        System.out.print("Введите степень, в которую хотите возвести число -> ");
        int power;
        if (scanner.hasNextInt()) {
            power = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int res = pow(num, power);
        System.out.println("Результат -> " + res);
    }

    public void reshEqualNum() {
        System.out.print("Введите число -> ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        boolean res = equalNum(num);
        System.out.println("Результат -> " + res);
    }

    public void reshLeftTriangle() {
        System.out.print("Введите высоту треугольника -> ");
        int x;
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        System.out.println("Треугольник: ");
        leftTriangle(x);
    }

    public void reshGuessGame() {
        Random random = new Random();
        int random_num = random.nextInt(10);
        System.out.println("Число успешно загадано!");

        int attempt = 0;
        int guess = 100;

        while (guess != random_num) {
            System.out.print("Попробуйте угадать загаданное число (0-9) -> ");

            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();

                if (guess < 0 || guess > 9) {
                    System.out.println("Число должно быть от 0 до 9!");
                    continue;
                }

                attempt++;

                if (guess == random_num) {
                    System.out.println("Вы угадали число! Это число " + random_num);
                    System.out.println("Количество попыток -> " + attempt);
                } else {
                    System.out.println("К сожалению, вы не угадали. Попробуйте еще раз!");
                }
            } else {
                System.out.println("Это не целое число");
                scanner.next();
            }
        }
    }
}

class Module_4 {
    Scanner scanner = new Scanner(System.in);

    public int findLast(int[] arr, int x) {      // task 4.2
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public int[] add(int[] arr, int x, int pos) {        // task 4.4
        int[] new_arr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            new_arr[i] = arr[i];
        }

        new_arr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            new_arr[i + 1] = arr[i];
        }

        return new_arr;
    }

    public void reverse(int[] arr) {         // task 4.6
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int[] concat(int[] arr1, int[] arr2) {        // task 4.8
        int[] res = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++)
            res[i + arr1.length] = arr2[i];

        return res;
    }

    public int[] deleteNegative(int[] arr) {         // task 4.10
        int cnt_positive = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                cnt_positive++;
        }

        int[] res = new int[cnt_positive];
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                res[pos] = arr[i];
                pos++;
            }
        }

        return res;
    }

    public void reshFindLast() {
        System.out.print("Введите размер массива -> ");
        int size;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " массива -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr[i] = element;
        }

        System.out.print("Введите число для его поиска -> ");
        int x;
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int res = findLast(arr, x);

        if (res == -1) {
            System.out.println("Число " + x + "не найдено в массиве.");
        } else {
            System.out.println("Число " + x + " найдено по индексу -> " + res);
        }
    }

    public void reshAdd() {
        System.out.print("Введите размер исходного массива -> ");
        int size;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr[i] = element;
        }

        System.out.print("Введите число для вставки -> ");
        int x;
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        System.out.print("Введите позицию для вставки (1-" + (size) + ") -> ");
        int pos;
        if (scanner.hasNextInt()) {
            pos = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        if (pos < 0 || pos > size) {
            System.out.println("Ошибка! Позиция должна быть от 0 до " + size);
            return;
        }

        int[] result = add(arr, x, pos);

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Новый массив: " + Arrays.toString(result));
    }

    public void reshReverse() {
        System.out.print("Введите размер исходного массива -> ");
        int size;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr[i] = element;
        }

        System.out.println("Исходный масси -> " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Перевернутый массив -> " + Arrays.toString(arr));
    }

    public void reshConcat() {
        System.out.print("Введите размер массива №1 -> ");
        int size1;
        if (scanner.hasNextInt()) {
            size1 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        int[] arr1 = new int[size1];

        System.out.println("Введите элементы первого массива -> ");
        for (int i = 0; i < size1; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr1[i] = element;
        }

        System.out.print("Введите размер массива №2 -> ");
        int size2;
        if (scanner.hasNextInt()) {
            size2 = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }
        int[] arr2 = new int[size2];

        System.out.println("Введите элементы второго массива -> ");
        for (int i = 0; i < size2; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr2[i] = element;
        }

        System.out.println("Первый массив -> " + Arrays.toString(arr1));
        System.out.println("Второй массив -> " + Arrays.toString(arr2));

        int[] res = concat(arr1, arr2);
        System.out.println("Результат -> " + Arrays.toString(res));
    }

    public void reshDeleteNegative() {
        System.out.print("Введите размер массива -> ");
        int size;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Это не целое число");
            scanner.next();
            return;
        }

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            int element;
            if (scanner.hasNextInt()) {
                element = scanner.nextInt();
            } else {
                System.out.println("Это не целое число");
                scanner.next();
                return;
            }
            arr[i] = element;
        }

        System.out.println("Исходный массив -> " + Arrays.toString(arr));

        int[] result = deleteNegative(arr);
        System.out.println("Результат -> " + Arrays.toString(result));
    }
}

public class Main {
    Scanner scanner = new Scanner(System.in);
    Module_1 module1 = new Module_1();
    Module_2 module2 = new Module_2();
    Module_3 module3 = new Module_3();
    Module_4 module4 = new Module_4();

    public void ShowTask() {
        System.out.println("==== Модуль 1. Методы ====");
        System.out.println("1. Сумма знаков");
        System.out.println("2. Есть ли позитив");
        System.out.println("3. Большая буква");
        System.out.println("4. Делитель");
        System.out.println("5. Многократный вызов.");
        System.out.println("===========================\n");

        System.out.println("==== Модуль 2. Условия ====");
        System.out.println("6. Безопасное деление");
        System.out.println("7. Строка сравнения");
        System.out.println("8. Тройная сумма");
        System.out.println("9. Возраст");
        System.out.println("10. Вывод дней недели");

        System.out.println("==== Модуль 3. Циклы ====");
        System.out.println("11. Числа наоборот");
        System.out.println("12. Степень числа");
        System.out.println("13. Одинаковость");
        System.out.println("14. Левый треугольник");
        System.out.println("15. Угадайка");
        System.out.println("===========================\n");

        System.out.println("==== Модуль 4. Массивы ====");
        System.out.println("16. Поиск последнего значения");
        System.out.println("17. Добавление в массив");
        System.out.println("18. Реверс");
        System.out.println("19. Объеденение");
        System.out.println("20. Негатив");
        System.out.println("===========================\n");

        System.out.print("\nВыберите задачу и введите его номер (1-20) -> ");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.ShowTask();

        main.ShowTask();

        if (main.scanner.hasNextInt()) {
            int choiceModule = main.scanner.nextInt();
            switch (choiceModule) {
                case 1:
                    main.module1.reshSumLastNums();
                    break;
                case 2:
                    main.module1.reshIsPostitve();
                    break;
                case 3:
                    main.module1.reshIsUpperCase();
                    break;
                case 4:
                    main.module1.reshIsDivisor();
                    break;
                case 5:
                    main.module1.reshLastNumSum();
                    break;
                case 6:
                    main.module2.reshSafeDiv();
                    break;
                case 7:
                    main.module2.reshMakeDecision();
                    break;
                case 8:
                    main.module2.reshSum3();
                    break;
                case 9:
                    main.module2.reshAge();
                    break;
                case 10:
                    main.module2.reshPrintDays();
                    break;
                case 11:
                    main.module3.reshReverseListNums();
                    break;
                case 12:
                    main.module3.reshPow();
                    break;
                case 13:
                    main.module3.reshEqualNum();
                    break;
                case 14:
                    main.module3.reshLeftTriangle();
                    break;
                case 15:
                    main.module3.reshGuessGame();
                    break;
                case 16:
                    main.module4.reshFindLast();
                    break;
                case 17:
                    main.module4.reshAdd();
                    break;
                case 18:
                    main.module4.reshReverse();
                    break;
                case 19:
                    main.module4.reshConcat();
                    break;
                case 20:
                    main.module4.reshDeleteNegative();
                    break;
                default:
                    System.out.println("Выбрана задача, отсутствующая в списке");
                    break;
            }
        } else {
            System.out.println("Введено не целое число!");
            main.scanner.next();
        }
    }
}
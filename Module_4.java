import java.util.Scanner;
import java.util.Arrays;

public class Module_4 {

    public static int findLast(int[] arr, int x) {      // task 4.2
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static int[] add(int[] arr, int x, int pos) {        // task 4.4
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

    public static void reverse(int[] arr) {         // task 4.6
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int[] concat(int[] arr1, int[] arr2) {        // task 4.8
        int[] res = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++)
            res[i + arr1.length] = arr2[i];

        return res;
    }

    public static int[] deleteNegative(int[] arr) {         // task 4.10
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

    public static void reshFindLast() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива -> ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0 ; i < size; i++) {
            System.out.print("Введите элемент №" + (i+1) + " массива -> ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Введите число для его поиска -> ");
        int x = scanner.nextInt();

        int res = findLast(arr, x);

        if (res == -1) {
            System.out.println("Число " + x + "не найдено в массиве.");
        }
        else {
            System.out.println("Число " + x + " найдено по индексу -> " + res);
        }
        scanner.close();
    }

    public static void reshAdd() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер исходного массива -> ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Введите число для вставки -> ");
        int x = scanner.nextInt();

        System.out.print("Введите позицию для вставки (0-" + size + ") -> ");
        int pos = scanner.nextInt();

        if (pos < 0 || pos > size) {
            System.out.println("Ошибка! Позиция должна быть от 0 до " + size);
            scanner.close();
            return;
        }

        int[] result = add(arr, x, pos);

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Новый массив: " + Arrays.toString(result));

        scanner.close();
    }

    public static void reshReverse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер исходного массива -> ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Исходный масси -> " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Перевернутый массив -> " + Arrays.toString(arr));

        scanner.close();
    }

    public static void reshConcat() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива №1 -> ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];

        System.out.println("Введите элементы первого массива -> ");
        for (int i = 0; i < size1; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Введите размер массива №2 -> ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];

        System.out.println("Введите элементы второго массива -> ");
        for (int i = 0; i < size2; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            arr2[i] = scanner.nextInt();
        }

        System.out.println("Первый массив -> " + Arrays.toString(arr1));
        System.out.println("Второй массив -> " + Arrays.toString(arr2));

        int[] res = concat(arr1, arr2);
        System.out.println("Результат -> " + Arrays.toString(res));

        scanner.close();
    }

    public static void reshDeleteNegative() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива -> ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент №" + (i + 1) + " -> ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Исходный массив -> " + Arrays.toString(arr));

        int[] result = deleteNegative(arr);
        System.out.println("Результат -> " + Arrays.toString(result));

        scanner.close();
    }
}
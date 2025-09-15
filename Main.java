import java.util.Scanner;

public class Main {

    public static void ShowTask() {
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
        Module_1 module1 = new Module_1();
        Module_2 module2 = new Module_2();
        Module_3 module3 = new Module_3();
        Module_4 module4 = new Module_4();

        ShowTask();

        Scanner scanner = new Scanner(System.in);
        int choiceModule = scanner.nextInt();

        switch (choiceModule) {
            case 1:
                Module_1.reshSumLastNums(); break;
            case 2:
                Module_1.reshIsPostitve(); break;
            case 3:
                Module_1.reshIsUpperCase(); break;
            case 4:
                Module_1.reshIsDivisor(); break;
            case 5:
                Module_1.reshLastNumSum(); break;
            case 6:
                Module_2.reshSafeDiv(); break;
            case 7:
                Module_2.reshMakeDecision(); break;
            case 8:
                Module_2.reshSum3(); break;
            case 9:
                Module_2.reshAge(); break;
            case 10:
                Module_2.reshPrintDays(); break;
            case 11:
                Module_3.reshReverseListNums(); break;
            case 12:
                Module_3.reshPow(); break;
            case 13:
                Module_3.reshEqualNum(); break;
            case 14:
                Module_3.reshLeftTriangle(); break;
            case 15:
                Module_3.reshGuessGame(); break;
            case 16:
                Module_4.reshFindLast(); break;
            case 17:
                Module_4.reshAdd(); break;
            case 18:
                Module_4.reshReverse(); break;
            case 19:
                Module_4.reshConcat(); break;
            case 20:
                Module_4.reshDeleteNegative(); break;
                default:
                    System.out.println("Выбрана задача, отсутствующая в списке"); break;
        }
    }
}
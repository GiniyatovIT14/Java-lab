package ru.Giniyatov.Menu;

import ru.Giniyatov.Contacts.TelephoneName;
import ru.Giniyatov.Geomerty.Point;
import ru.Giniyatov.Human.NameModiff;
import ru.Giniyatov.Weapon.AutomaticWeapon;
import ru.Giniyatov.Weapon.Gun;
import ru.Giniyatov.Weapon.PistolModiff;
import ru.Giniyatov.Weapon.Shooter;

import java.util.Scanner;

public class taskManager {
    private Scanner scanner;

    public taskManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void reshPistolModiff() {
        System.out.println("=== Задача с перезарядкой пистолета ===");

        System.out.println("===== Демонстрация по условию =====");
        PistolModiff pistol = new PistolModiff(7);
        System.out.println("Создан: " + pistol);

        System.out.println("1. Заряжаем 3 патрона...");
        int returned = pistol.reload(3);
        System.out.println("Возвращено лишних -> " + returned);
        System.out.println("Состояние-> " + pistol);

        System.out.println("2. Стреляем 5 раз -> ");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Выстрел " + i + "-> ");
            pistol.shoot();
        }
        System.out.println("\nСостояние -> " + pistol);

        System.out.println("3. Заряжаем 8 патронов...");
        returned = pistol.reload(8);
        System.out.println("Возвращено лишних -> " + returned);
        System.out.println("Состояние -> " + pistol);

        System.out.println("4. Стреляем 2 раза -> ");
        for (int i = 1; i <= 2; i++) {
            System.out.print("Выстрел " + i + ": ");
            pistol.shoot();
        }
        System.out.println("\nСостояние -> " + pistol);

        System.out.println("5. Разряжаем пистолет...");
        int unloaded = pistol.unload();
        System.out.println("Извлечено патронов -> " + unloaded);
        System.out.println("Состояние -> " + pistol);

        System.out.println("6. Контрольный выстрел -> ");
        pistol.shoot();
        System.out.println("\nИтоговое состояние ->  " + pistol);
    }

    public void reshNameModiff() {
        System.out.println("=== Задача с непустыми именами ===");

        System.out.println("===== Демонстрация корректных имен =====");
        NameModiff cleopatra = new NameModiff("Клеопатра");
        NameModiff pushkin = new NameModiff("Александр", "Пушкин", "Сергеевич");
        NameModiff mayakovsky = new NameModiff("Владимир", "Маяковский");
        NameModiff hristofor = new NameModiff("Христофор", "Бонифатьевич");

        System.out.println("Созданные имена:");
        System.out.println("1. " + cleopatra);
        System.out.println("2. " + pushkin);
        System.out.println("3. " + mayakovsky);
        System.out.println("4. " + hristofor);

        System.out.println("\n===== Проверка работы геттеров =====");
        System.out.println("Пушкин - Имя: " + pushkin.getFirstName());
        System.out.println("Пушкин - Фамилия: " + pushkin.getLastName());
        System.out.println("Пушкин - Отчество: " + pushkin.getPatronymic());

        System.out.println("Проверка null параметров:");
        try {
            NameModiff invalid = new NameModiff("", null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void reshAutomaticWeapon() {
        System.out.println("=== Задача с автоматом ===");

        System.out.println("===== Демонстрация конструкторов =====");

        // a) Конструктор без параметров
        System.out.println("1. Автомат по умолчанию:");
        AutomaticWeapon auto1 = new AutomaticWeapon();
        System.out.println("   " + auto1);

        // b) Конструктор с вместимостью
        System.out.println("\n2. Автомат с вместимостью 20:");
        AutomaticWeapon auto2 = new AutomaticWeapon(20);
        System.out.println("   " + auto2);

        // c) Конструктор с вместимостью и скорострельностью
        System.out.println("\n3. Автомат с вместимостью 15 и скорострельностью 10:");
        AutomaticWeapon auto3 = new AutomaticWeapon(15, 10);
        System.out.println("   " + auto3);

        System.out.println("\n===== Демонстрация стрельбы =====");

        // Демонстрация обычной стрельбы
        System.out.println("4. Демонстрация стрельбы (скорострельность 3):");
        AutomaticWeapon demoWeapon = new AutomaticWeapon(10, 3);
        demoWeapon.reload(5);
        System.out.println("   До стрельбы: " + demoWeapon);
        System.out.print("   Стреляем: ");
        demoWeapon.shoot(); // выстрелит 3 раза
        System.out.println("   После стрельбы: " + demoWeapon);

        // Демонстрация стрельбы N секунд
        System.out.println("\n5. Демонстрация стрельбы 2 секунды (скорострельность 4):");
        AutomaticWeapon secWeapon = new AutomaticWeapon(20, 4);
        secWeapon.reload(10);
        System.out.println("   До стрельбы: " + secWeapon);
        secWeapon.shootForSeconds(2); // 2 секунды × 4 выстр/сек = 8 выстрелов
        System.out.println("   После стрельбы: " + secWeapon);

        System.out.println("\n6. Демонстрация стрельбы до опустошения:");
        AutomaticWeapon emptyWeapon = new AutomaticWeapon(10, 5);
        emptyWeapon.reload(3);
        System.out.println("   До стрельбы: " + emptyWeapon);
        System.out.print("   Стреляем: ");
        emptyWeapon.shoot(); // 5 выстрелов, но патронов только 3
        System.out.println("   После стрельбы: " + emptyWeapon);
    }

    public void reshShooter() {
        System.out.println("=== Задача с лучшим стрелком ===");

        System.out.println("===== Создание стрелков =====");

        // Стрелок без оружия
        AutomaticWeapon auto = null;
        Shooter shooter1 = new Shooter("Вася", auto);
        System.out.println("1. " + shooter1);

        // Стрелок с пистолетом
        Gun pistol = new Gun(7);
        pistol.reload(3);
        Shooter shooter2 = new Shooter("Петя", pistol);
        System.out.println("2. " + shooter2);

        // Стрелок с автоматом
        auto = new AutomaticWeapon(20, 5);
        auto.reload(15);
        Shooter shooter3 = new Shooter("Коля", auto);
        System.out.println("3. " + shooter3);

        System.out.println("\n===== Демонстрация стрельбы =====");

        System.out.println("4. Первая очередь:");
        shooter1.shoot(); // без оружия
        shooter2.shoot(); // с пистолетом
        shooter3.shoot(); // с автоматом

        System.out.println("\n5. Вторая очередь:");
        shooter1.shoot(); // без оружия
        shooter2.shoot(); // с пистолетом
        shooter3.shoot(); // с автоматом

        System.out.println("\n===== Демонстрация смены оружия =====");

        System.out.println("6. Даем Васе пистолет:");
        Gun newPistol = new Gun(5);
        newPistol.reload(5);
        shooter1.setWeapon(newPistol);
        System.out.println("   " + shooter1);
        shooter1.shoot();

        System.out.println("\n7. Забираем оружие у Пети:");
        shooter2.setWeapon(null);
        System.out.println("   " + shooter2);
        shooter2.shoot();

        System.out.println("\n8. Меняем имя Коли:");
        shooter3.setName("Николай");
        System.out.println("   " + shooter3);
        shooter3.shoot();

        System.out.println("\n===== Финальное состояние =====");
        System.out.println(shooter1);
        System.out.println(shooter2);
        System.out.println(shooter3);
    }

    public void reshPhoneBook() {
        System.out.println("=== Задача с телефонным справочником ===");

        System.out.println("===== Создание справочника =====");
        TelephoneName phoneBook = new TelephoneName();
        System.out.println("Создан пустой справочник: " + phoneBook);

        System.out.println("\n===== 1. Добавление пар 'телефон - имя' =====");

        System.out.println("Добавляем '89001112233 - Вася':");
        String oldPhone = phoneBook.addContact("89001112233", "Вася");
        System.out.println("Старый телефон: " + oldPhone);
        System.out.println(phoneBook);

        System.out.println("Добавляем '89002223344 - Петя':");
        oldPhone = phoneBook.addContact("89002223344", "Петя");
        System.out.println("Старый телефон: " + oldPhone);
        System.out.println(phoneBook);

        System.out.println("Добавляем '89003334455 - Маша':");
        oldPhone = phoneBook.addContact("89003334455", "Маша");
        System.out.println("Старый телефон: " + oldPhone);
        System.out.println(phoneBook);

        System.out.println("Добавляем '89004445566 - Вася' (замена телефона):");
        oldPhone = phoneBook.addContact("89004445566", "Вася");
        System.out.println("Старый телефон: " + oldPhone);
        System.out.println(phoneBook);

        System.out.println("\n===== 2. Удаление контакта =====");

        System.out.println("Удаляем Петю:");
        String removedPhone = phoneBook.removeContact("Петя");
        System.out.println("Удаленный телефон: " + removedPhone);
        System.out.println(phoneBook);

        System.out.println("Пытаемся удалить несуществующего Ивана:");
        removedPhone = phoneBook.removeContact("Иван");
        System.out.println("Результат: " + removedPhone);

        System.out.println("\n===== 3. Получение телефона по имени =====");

        System.out.println("Телефон Васи: " + phoneBook.getPhone("Вася"));
        System.out.println("Телефон Маши: " + phoneBook.getPhone("Маша"));
        System.out.println("Телефон несуществующего: " + phoneBook.getPhone("Иван"));

        System.out.println("\n===== 4. Приведение к строке =====");
        System.out.println(phoneBook);

        System.out.println("\n===== 5. Проверка наличия имени и телефона =====");

        System.out.println("Есть ли Вася: " + phoneBook.hasName("Вася"));
        System.out.println("Есть ли Петя: " + phoneBook.hasName("Петя"));
        System.out.println("Есть ли телефон 89004445566: " + phoneBook.hasPhone("89004445566"));
        System.out.println("Есть ли телефон 89001112233: " + phoneBook.hasPhone("89001112233"));

        System.out.println("\n===== 6. Текущее количество контактов =====");
        System.out.println("Количество контактов: " + phoneBook.getContactCount());

        System.out.println("\n===== 7. Запрос в виде массива =====");

        System.out.println("7a. Все пары:");
        String[][] allPairs = phoneBook.getAllPairs();
        for (int i = 0; i < allPairs.length; i++) {
            System.out.println("   " + (i + 1) + ". " + allPairs[i][0] + " - " + allPairs[i][1]);
        }

        System.out.println("\n7b. Все телефоны:");
        String[] allPhones = phoneBook.getAllPhones();
        for (int i = 0; i < allPhones.length; i++) {
            System.out.println("   " + (i + 1) + ". " + allPhones[i]);
        }

        System.out.println("\n7c. Все имена:");
        String[] allNames = phoneBook.getAllNames();
        for (int i = 0; i < allNames.length; i++) {
            System.out.println("   " + (i + 1) + ". " + allNames[i]);
        }

        System.out.println("\n===== 8. Поиск имен по части названия =====");

        // Добавим еще контактов для демонстрации поиска
        phoneBook.addContact("89005556677", "Валерий");
        phoneBook.addContact("89006667788", "Варвара");
        phoneBook.addContact("89007778899", "Сергей");

        System.out.println("Текущий справочник:");
        System.out.println(phoneBook);

        System.out.println("Имена, начинающиеся на 'В':");
        String[] namesWithV = phoneBook.getNamesByPrefix("В");
        for (String name : namesWithV) {
            System.out.println("   " + name);
        }

        System.out.println("Имена, начинающиеся на 'Ва':");
        String[] namesWithVa = phoneBook.getNamesByPrefix("Ва");
        for (String name : namesWithVa) {
            System.out.println("   " + name);
        }

        System.out.println("Имена, начинающиеся на 'С':");
        String[] namesWithS = phoneBook.getNamesByPrefix("С");
        for (String name : namesWithS) {
            System.out.println("   " + name);
        }

        System.out.println("\n===== Демонстрация обработки пустых данных =====");

        try {
            phoneBook.addContact("", "Иван");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении с пустым телефоном: " + e.getMessage());
        }

        try {
            phoneBook.addContact("89008889900", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении с пустым именем: " + e.getMessage());
        }

        try {
            phoneBook.addContact(null, "Иван");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении с null телефоном: " + e.getMessage());
        }

        System.out.println("\n===== Финальное состояние =====");
        System.out.println(phoneBook);
    }

    public void reshPoint() {
        System.out.println("=== Задача с сравнением точек ===");

        System.out.println("===== Корректное создание точек =====");

        Point point1 = new Point(3, 5);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);

        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        System.out.println("\n===== Демонстрация проверок ввода =====");

        try {
            System.out.println("Попытка создать точку с NaN:");
            Point invalid1 = new Point(Double.NaN, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Попытка создать точку с бесконечностью:");
            Point invalid2 = new Point(3, Double.POSITIVE_INFINITY);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Попытка создать точку из строк 'abc', 'def':");
            Point invalid3 = new Point("abc", "def");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Попытка создать точку из строк '3.5', '7.2':");
            Point valid = new Point("3.5", "7.2");
            System.out.println("Успешно создана: " + valid);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n===== Демонстрация сравнения точек =====");

        Point point4 = new Point(3, 5);
        Point point5 = new Point(3, 6);
        Point point6 = new Point(4, 5);

        System.out.println("point1: " + point1);
        System.out.println("point4: " + point4);
        System.out.println("point1.equals(point4): " + point1.equals(point4));

        System.out.println("point1: " + point1);
        System.out.println("point5: " + point5);
        System.out.println("point1.equals(point5): " + point1.equals(point5));

        System.out.println("point1: " + point1);
        System.out.println("point6: " + point6);
        System.out.println("point1.equals(point6): " + point1.equals(point6));
    }
}

package ru.Giniyatov.Main;

import ru.Giniyatov.Weapon.*;

public class ShooterDemonstrate {
    public static void demoShooters() {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ОРУЖИЯ ===\n");

        // Демонстрация работы пистолета
        System.out.println("1. ТЕСТИРОВАНИЕ ПИСТОЛЕТА:");
        Gun pistol = new Gun(10, 5);
        System.out.println(pistol);

        System.out.println("Стрельба 3 раза:");
        for (int i = 0; i < 3; i++) {
            pistol.shoot();
        }
        System.out.println("После стрельбы: " + pistol);

        System.out.println("Перезарядка 8 патронов:");
        int remaining = pistol.reload(8);
        System.out.println("Вернулось патронов: " + remaining);
        System.out.println("После перезарядки: " + pistol);

        System.out.println("\n2. ТЕСТИРОВАНИЕ АВТОМАТА:");
        AutomaticWeapon auto = new AutomaticWeapon(30, 5);
        System.out.println(auto);

        System.out.println("Одиночный выстрел (серия):");
        auto.shoot();
        System.out.println("После стрельбы: " + auto);

        System.out.println("Стрельба в течение 2 секунд:");
        auto.shootForSeconds(2);
        System.out.println("После стрельбы: " + auto);

        System.out.println("\n3. ТЕСТИРОВАНИЕ СТРЕЛКОВ:");
        Shooter shooter1 = new Shooter("Иван", pistol);
        Shooter shooter2 = new Shooter("Петр", new Gun(8, 3));

        System.out.println(shooter1);
        System.out.println(shooter2);

        System.out.println("\nСтрельба стрелков:");
        shooter1.shoot();
        shooter2.shoot();

        System.out.println("\n4. ТЕСТИРОВАНИЕ PISTOLMODIFF:");
        PistolModiff modiff = new PistolModiff(5, 15);
        System.out.println(modiff);

        System.out.println("Перезарядка 10 патронов:");
        int returned = modiff.reload(10);
        System.out.println("Вернулось патронов: " + returned);
        System.out.println("После перезарядки: " + modiff);

    }
}
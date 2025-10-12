package ru.Giniyatov.Weapon;

public class AutomaticWeapon extends PistolModiff {
    private final int fireRate;

    public AutomaticWeapon() {
        super(30);
        this.fireRate = 30;
    }

    public AutomaticWeapon(int maxCapacity) {
        super(maxCapacity);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной");
        }
        this.fireRate = maxCapacity / 2;
    }

    public AutomaticWeapon(int maxCapacity, int fireRate) {
        super(maxCapacity);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной");
        }
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной");
        }
        this.fireRate = fireRate;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            if (bullets > 0) {
                System.out.print("Бах! ");
                bullets--;
            } else {
                System.out.print("Клац! ");
            }
        }
        System.out.println();
    }

    public void shootForSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным");
        }

        int totalShots = seconds * fireRate;
        System.out.println("Стрельба " + seconds + " секунд (" + totalShots + " выстрелов):");

        for (int i = 0; i < totalShots; i++) {
            if (bullets > 0) {
                System.out.print("Бах! ");
                bullets--;
            } else {
                System.out.print("Клац! ");
            }
        }
        System.out.println();
    }

    public int getFireRate() {
        return fireRate;
    }

    @Override
    public String toString() {
        return "Автомат [Патроны: " + bullets + "/" + getCapacity() +
                ", Скорострельность: " + fireRate + " выстр/сек]";
    }
}
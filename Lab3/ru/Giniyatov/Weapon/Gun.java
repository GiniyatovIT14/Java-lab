package ru.Giniyatov.Weapon;

import ru.Giniyatov.Weapon.WeaponAbstract;

public class Gun extends WeaponAbstract {
    private final int maxCapacity;

    public Gun() {
        super(5);
        this.maxCapacity = 10;
    }

    public Gun(int maxCapacity) {
        super(0);
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
    }

    public Gun(int maxCapacity, int initialBullets) {
        super(Math.min(initialBullets, maxCapacity));
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной");
        }
        if (initialBullets < 0) {
            throw new IllegalArgumentException("Начальное количество патронов не может быть отрицательным");
        }
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.print("Бах! ");
            ammo--;
        } else {
            System.out.print("Клац! ");
        }
    }

    public int reload(int bulletsToAdd) {
        if (bulletsToAdd < 0) {
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может");
        }

        int spaceAvailable = maxCapacity - ammo;
        int bulletsActuallyAdded = Math.min(bulletsToAdd, spaceAvailable);
        int bulletsReturned = bulletsToAdd - bulletsActuallyAdded;

        ammo += bulletsActuallyAdded;
        return bulletsReturned;
    }

    // Упрощенный метод разрядки
    public int unload() {
        int bulletsRemoved = ammo;
        ammo = 0;
        return bulletsRemoved;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    @Override
    public String toString() {
        return "Пистолет [Патроны: " + ammo + "/" + maxCapacity + "]";
    }
}
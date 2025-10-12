package ru.Giniyatov.Weapon;

public class PistolModiff {
    protected int bullets;
    private int capacity;

    public PistolModiff() {
        this.bullets = 0;
        this.capacity = 0;
    }

    public PistolModiff(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер обоймы должен быть положительным числом!");
        }

        this.bullets = 0;
        this.capacity = capacity;
    }

    public PistolModiff(int initialBullets, int capacity) {
        if (initialBullets < 0) {
            throw new IllegalArgumentException("Отрицательное число патронов в обойме. Ошибка!");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер обоймы должен быть положительным числом!");
        }
        this.capacity = capacity;
        this.bullets = Math.min(initialBullets, capacity);
    }

    public int getBullets() {
        return bullets;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isLoaded() {
        return bullets > 0;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац");
        }
    }

    public int reload(int bulletsToLoad) {
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Отрицательное число патронов. Ошибка!");
        }

        int space = capacity - bullets;         // вычисляем оставшееся место под патроны
        int bulletsLoaded = Math.min(bulletsToLoad, space);         // сколько смогли вернуть
        int bulletsToReturn = bulletsToLoad - bulletsLoaded;        // сколько возвращаем

        bullets = bullets + bulletsLoaded;
        return bulletsToReturn;
    }

    public int unload() {
        int bulletsToRemove = bullets;
        bullets = 0;
        return bulletsToRemove;
    }

    @Override
    public String toString() {
        return "Пистолет (патронов: " + bullets + "/" + capacity + ")";
    }
}

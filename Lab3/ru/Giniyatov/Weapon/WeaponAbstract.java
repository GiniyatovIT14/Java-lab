package ru.Giniyatov.Weapon;

public abstract class WeaponAbstract {
    protected int ammo;  // изменено с private на protected

    public WeaponAbstract(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int getAmmo() {
        return ammo;
    }

    public boolean useAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public int load(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        int oldAmmo = this.ammo;
        this.ammo = ammo;
        return oldAmmo;
    }
}
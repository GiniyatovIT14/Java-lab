package ru.Giniyatov.Weapon;

public class Shooter {
    private String name;
    private Gun weapon;

    public Shooter(String name, AutomaticWeapon auto) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name.trim();
        this.weapon = null;
    }

    public Shooter(String name, Gun weapon) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name.trim();
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name.trim();
    }

    public Gun getWeapon() {
        return weapon;
    }

    public void setWeapon(Gun weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null) {
            System.out.print(name + " стреляет: ");
            weapon.shoot();
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }

    @Override
    public String toString() {
        String weaponInfo = (weapon != null) ? weapon.toString() : "без оружия";
        return "Стрелок [Имя: " + name + ", Оружие: " + weaponInfo + "]";
    }
}
public class Pistol {
    private int bullets;

    public Pistol() {
        this.bullets = 5;
    }

    public Pistol(int countBullets) {
        this.bullets = countBullets;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int countBullet) {
        this.bullets = countBullet;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац");
        }
    }

    @Override
    public String toString() {
        return "Пистолет (патронов: " + bullets + ")";
    }
}
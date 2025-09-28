public class Employee {
    private String name;
    private String department;
    private Employee boss;

    public Employee(String name, String department, Employee boss) {
        this.name = name;
        this.department = department;
        this.boss = boss;
    }

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        this.boss = this;
    }

    public Employee(String name) {
        this.name = name;
        this.department = null;
        this.boss = null;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Employee getBoss() {
        return boss;
    }

    public boolean isBoss() {
        return boss == this;
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " (не назначен в отдел)";
        }

        if (isBoss()) {
            return name + " началник отдела " + department;
        } else {
            String bossName = (boss != null) ? boss.getName() : " не назначен";
            return name + " работает в отделе " + department + " начальник отдела которого " +
                    bossName;
        }
    }
}

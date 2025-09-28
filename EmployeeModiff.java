import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeModified {
    private String name;
    private String departmentName;
    private EmployeeModified boss;

    private static List<EmployeeModified> allEmployees = new ArrayList<>();

    public EmployeeModified() {
        this.name = "";
        this.departmentName = null;
        this.boss = null;
        allEmployees.add(this);
    }

    public EmployeeModified(String name) {
        this.name = name;
        this.departmentName = null;
        this.boss = null;
        allEmployees.add(this);
    }

    public EmployeeModified(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
        this.boss = this;
        allEmployees.add(this);
    }

    public EmployeeModified(String name, String departmentName, EmployeeModified boss) {
        this.name = name;
        this.departmentName = departmentName;
        this.boss = boss;
        allEmployees.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setBoss(EmployeeModified boss) {
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public EmployeeModified getBoss() {
        return boss;
    }

    public boolean isBoss() {
        return boss == this;
    }

    public List<EmployeeModified> getDepartmentEmployees() {
        List<EmployeeModified> departmentEmployees = new ArrayList<>();

        if (departmentName == null) {
            return departmentEmployees;
        }

        for (EmployeeModified employee : allEmployees) {
            if (departmentName.equals(employee.getDepartmentName())) {
                departmentEmployees.add(employee);
            }
        }
        return departmentEmployees;
    }

    @Override
    public String toString() {
        if (departmentName == null) {
            return name + " (не назначен в отдел)";
        }

        if (isBoss()) {
            return name + " начальник отдела " + departmentName;
        } else {
            String bossName = (boss != null) ? boss.getName() : "не назначен";
            return name + " работает в отделе " + departmentName + ", начальник которого " + bossName;
        }
    }
}
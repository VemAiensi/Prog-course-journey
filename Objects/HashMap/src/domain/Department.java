package domain;

public class Department {
    private String depCode;
    private String depName;
    private Double depTotalSalary;

    public Department(String depCode, String depName)
    {
        this.depCode = depCode;
        this.depName = depName;
    }
    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public Double getDepTotalSalary() {
        return depTotalSalary;
    }

    public void setDepTotalSalary(Double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }
}

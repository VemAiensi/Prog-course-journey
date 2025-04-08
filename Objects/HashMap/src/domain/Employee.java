package domain;

public class Employee {
    private String empNo;
    private String lastName;
    private String firstName;
    private Double salary;

    public Employee(String empNo, String lastName, String firstName) {
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

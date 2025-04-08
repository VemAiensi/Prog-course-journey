package dao;
import domain.Employee;
import java.util.*;
import java.io.*;
public class EmployeeDA {
    private HashMap<String, Employee> employeeMap;
    public HashMap<String, Employee> getEmployeeMap() {return employeeMap;}

    public EmployeeDA(String depCode) throws FileNotFoundException
    {
        Scanner readEmpInfo = new Scanner(new FileReader("src/emp.csv"));

        employeeMap = new HashMap<>();
        int key = 0;

        readEmpInfo.nextLine();
        while(readEmpInfo.hasNext())
        {
            String empStringData = readEmpInfo.nextLine();
            String[] empData = empStringData.split(", ");

            //determine employee's depCode
            String empDep = deptempInfo(empData[0], 0);

            if(empDep.equals(depCode))
            {//empData[0] refers to empNo
                Employee employee = new Employee(empData[0], empData[1], empData[2]);
                employee.setSalary(Double.parseDouble(deptempInfo(empData[0],2)));
                    //returns the salary from deptemp.csv and then converted to double
                employeeMap.put(depCode+key, employee);
                key++;
            }
        }
    }

    private String deptempInfo(String empNo, int col) throws FileNotFoundException
    {
        String data = "";
        Scanner readDeptempInfo = new Scanner(new FileReader("src/deptemp.csv"));

        readDeptempInfo.nextLine();
        while(readDeptempInfo.hasNext())
        {
            String tempStringData = readDeptempInfo.nextLine();
            String[] tempData = tempStringData.split(", ");

            if(tempData[1].equals(empNo))
            {//tempData[1] refers to empNo
                data = (tempData[col]);
            }
        }
        return data;
    }
}

package dao;
import domain.*;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
public class DepartmentDA {
    public DepartmentDA() throws FileNotFoundException
    {
        Scanner readDepInfo = new Scanner(new FileReader("src/dep.csv"));

        int key = 0;

        readDepInfo.nextLine();
        while(readDepInfo.hasNext())
        {
            String depStringData = readDepInfo.nextLine();
            String[] depData = depStringData.split(", ");

            Department department = new Department(depData[0], depData[1]);
            EmployeeDA employees = new EmployeeDA(depData[0]);

            //Calculate Total Salary
            department.setDepTotalSalary(CalculateTotalSalary(employees.getEmployeeMap()));

            //Print the report
            System.out.println(AnalyzedReport(department, employees.getEmployeeMap()));
        }
    }

    private Double CalculateTotalSalary(HashMap<String, Employee> empMap)
    {
        Double tSalary = 0.0;
        for(Map.Entry<String, Employee> entry: empMap.entrySet())
        {
            tSalary += entry.getValue().getSalary();
        }
        return tSalary;
    }
    private String AnalyzedReport(Department dep, HashMap<String, Employee> empMap)
    {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        String report = "Department Code: " + dep.getDepCode() + "\n"
                      + "Department Name: " + dep.getDepName() + "\n"
                      + "Department Salary: " + df.format(dep.getDepTotalSalary()) + "\n";

        report += "------------[ Details ]------------\n"
                + "EmpNo\tEmployee Name\t\t\tSalary\n";

        for(Map.Entry<String, Employee> entry: empMap.entrySet())
        {
            String empName = wordAligner(entry.getValue().getLastName()
                            + ", " + entry.getValue().getFirstName());

            report += entry.getValue().getEmpNo() + "\t"
                    + empName + "\t"
                    + df.format(entry.getValue().getSalary()) + "\n";
        }
        return report;
    }
    static String wordAligner(String word)
    {//this method transforms the word length to a fixed length for alignment purposes
        String fixed = word;
        while(fixed.length() < 20)
            fixed += " ";
        return fixed;
    }
}

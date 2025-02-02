package employee;

public class Employeeinfo 
{
	public static void display_Employee(int count, String employee[][])
	{
		System.out.println("\nEMPLOYEE'S DETAILS");
		System.out.println("Employee Name: " + employee[count][0]);
		System.out.println("Designation: " + employee[count][1]);
		System.out.println("Academic Position: " + employee[count][2]);
	}
}

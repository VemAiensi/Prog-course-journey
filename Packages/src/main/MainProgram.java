package main;
import java.util.*;
import student.Acadinfo;
import student.StudentInfo;
import employee.Employeeinfo;
public class MainProgram 
{
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int count = 0; int slot = 0;
		System.out.print("How many students will you record? ");
		slot = in.nextInt();
		in.nextLine();
		String student[][][] = new String [slot][2][7];
		String employee[][] = new String [slot][3];
		boolean repeater = false;
		do 
		{
			//For Student Details
			System.out.print("Student name: "); //store name in student[0]
			student[count][0][0] = in.nextLine();	//and so on..
			System.out.print("Age: ");
			student[count][0][1] = in.nextLine();
			System.out.print("Gender: ");
			student[count][0][2] = in.nextLine();
			System.out.print("Adress: ");
			student[count][0][3] = in.nextLine();
			System.out.print("Contact Number: ");
			student[count][0][4] = in.nextLine();
			System.out.print("Father's name: ");
			student[count][0][5] = in.nextLine();
			System.out.print("Mother's name: "); 
			student[count][0][6] = in.nextLine();
			
			//For Student Educational Info
			System.out.print("Stundent #: ");
			student[count][1][0] = in.nextLine();
			System.out.println("Student Grade: ");
			System.out.print("Quiz 1: ");
			student[count][1][1] = in.nextLine(); //this must be converted to double for calculations
			System.out.print("Quiz 2: ");
			student[count][1][2] = in.nextLine();
			System.out.print("Midterm: ");
			student[count][1][3] = in.nextLine();
			System.out.print("Final: ");
			student[count][1][4] = in.nextLine();
			System.out.println("Student Attendance");
			System.out.print("Number of overall classes: ");
			student[count][1][5] = in.nextLine();
			System.out.print("Number of classes Attended: ");
			student[count][1][6] = in.nextLine(); 
			
			//For Employee Details
			System.out.println("\nEMPLOYEE INPUT");
			System.out.print("Employee's Name: ");
			employee[count][0] = in.nextLine(); 
			System.out.print("Designation: ");
			employee[count][1] = in.nextLine();
			System.out.print("Academic Position: ");
			employee[count][2] = in.nextLine();
			count++; //will increase student no. for corresponding slot
			
			if (count < slot)
			{
				System.out.println("\nNext Student\n");
				repeater = true;
			}
			else
			{
				repeater = false;
			}
		}
		while(repeater == true);
		System.out.println();
		
		//loop here
		for (count = 0; count < slot;)
		{
			StudentInfo.Studentinfo(count, student);
			StudentInfo.display_student(count, student);
			Employeeinfo.display_Employee(count, employee);
			Acadinfo.AcadInfo(student, count);
			Acadinfo.displayEducDetails(student, count);
			
			count++;
			if (count<slot)
			System.out.println("\n\nNEXT STUDENT");
		}
	}
//Note: I cleared some unnecessary comments for the sake of the program's neatness.
	//-Vem Aiensi
}

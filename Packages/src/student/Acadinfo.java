package student;
import java.text.DecimalFormat;
public class Acadinfo 
{
	public static void AcadInfo(String [][][] student, int count)
	{
		System.out.println("\nSTUDENT'S ACADEMIC DETAILS:");
		System.out.println("Student Number: " + student[count][1][0]);
		System.out.println("Student Grade\nQuiz1: " + student[count][1][1]);
		System.out.println("Quiz 2: " + student[count][1][2]);
		System.out.println("Midterm: " + student[count][1][3]);
		System.out.println("Final: " + student[count][1][4]);
		System.out.println("Number of Attended Classes: " + student[count][1][6]);
	}
	public static void displayEducDetails(String [][][] student, int count)
	{
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("\nSTUDENT EDUCATIONAL STATUS");
		System.out.println("Student Number: " + student[count][1][0]);
		//quiz should have fixed value overall
		double quiz1 = 	Double.parseDouble(student[count][1][1]); //100/100
		double quiz2 = 	Double.parseDouble(student[count][1][2]);//100/100
		double midterm =Double.parseDouble(student[count][1][3]);//100/100
		double finl = 	Double.parseDouble(student[count][1][4]);//100/100
		double averageGrade = ((quiz1+quiz2+midterm+finl)/400)*100;
		System.out.println("Student Average Grade: " + df.format(averageGrade) +"%");
		double numberOfDays = Integer.parseInt(student[count][1][5]);
		double attended	 = Integer.parseInt(student[count][1][6]);
		double attendance = (attended/numberOfDays)*100;
		System.out.println("Student Attendance: " + df.format(attendance) +"%");
	}
}

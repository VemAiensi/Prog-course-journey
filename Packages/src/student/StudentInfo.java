package student;
public class StudentInfo 
{
	public static void Studentinfo(int count ,String [][][] student)
	{
		System.out.println("Student no. " + (count+1));
			//ok this will be the indicator of printing the Student's details
	}
	public static void display_student(int count ,String [][][] student)
	{
		System.out.println("\nSTUDENT DETAILS");
		System.out.println("Student Name: " + student[count][0][0]);
		System.out.println("Student Age: " + student[count][0][1]);
		System.out.println("Student Gender: " + student[count][0][2]);
		System.out.println("Student Adress: " + student[count][0][3]);
		System.out.println("Student Number: " + student[count][0][4]);
		System.out.println("Father's Name: " + student[count][0][5]);
		System.out.println("Mother's Name: " + student[count][0][6]);
	}
}

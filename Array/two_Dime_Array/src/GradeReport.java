package labAct42dArrays;
import java.util.Scanner;
public class GradeReport 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numStud = 0;
		
		String[] subject = {"Physics", "Algebra", "Programming"};
		
		System.out.print("Enter the number of students to process: ");
		numStud = input.nextInt();
		
		String[] studName = new String[numStud];
		double[][] grade = new double[numStud][3];
		double[] totalGrade = new double[numStud];
		
		// Data Entry
		for (int gRow = 0; gRow < numStud; gRow++)
		{
			System.out.print("\nEnter student name: ");
			studName[gRow] = input.next();
			for (int gCol = 0; gCol < 3; gCol++)
			{
				System.out.print("Enter a grade in " + subject[gCol] + ": ");
				grade[gRow] [gCol] = input.nextDouble();
				
				totalGrade[gRow] += grade[gRow][gCol];
			}
		}
		//Display Report
		System.out.println("\nGrade Report");
		System.out.println("---------------");
		for (int dispRow = 0; dispRow < numStud; dispRow++)
		{
			System.out.println("\nStudent name: " + studName[dispRow]);
		
			for (int dispCol = 0; dispCol < 3; dispCol++ )
			{
				System.out.println("Grade in " + subject[dispCol] + " is " + grade[dispRow][dispCol]);
			
			}
			System.out.println("Average grade is: " + totalGrade[dispRow]/3.0);
		}
	}
}

package labAct3Arrays;
//Marasigan, Vem Aiensi A.   1-BSEMC-.1
import java.util.Scanner;
import java.text.DecimalFormat;
public class Salary 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("$#,###.00");
		
		int numEmp = 0;
		String[] name;
		double[] rate;
		double[] hoursWorked;
		
		System.out.print("Enter number of employees to process: ");
		numEmp = input.nextInt();
		
		name = new String[numEmp];
		rate = new double[numEmp];
		hoursWorked = new double[numEmp];
		
		int indexNum = 0;
		while (indexNum < numEmp)
		{
			System.out.print("\nEnter Employee name: ");
			name [indexNum] = input.next();
			
			System.out.print("Enter number of hours worked: ");
			hoursWorked [indexNum] = input.nextDouble();
			
			System.out.print("Enter rate per hour: ");
			rate [indexNum] = input.nextDouble();
			
			indexNum++;
		}
		
		//Printing of Headers
		System.out.println("\nSalary Report");
		System.out.println("----------------");
		System.out.println("Name\tRate per Hour\tHours Worked\tSalary\n");
		
		for (int i = (numEmp - 1); i >= 0; i--)
		{
			System.out.print(name[i] + "\t\t");
			System.out.print(df.format(rate[i])+ "\t\t\t");
			System.out.print(hoursWorked[i]+ "\t\t\t");
			System.out.println(df.format(hoursWorked[i] * rate[i]));
		}
	}
}

package labAct1Loops;
import java.util.Scanner;
public class AverageNumber 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double number = 0, sum = 0, divisor = 0;
		
		while (true)
		{
			System.out.print("Enter number [-1 to quit]: ");
			number = input.nextDouble();
			
			if (number != -1)
			{
				sum += number;
				divisor++;
			}
			else
			{
				break;
			}
		}
		System.out.println("\nAverage number is " + sum/divisor);
	}
}

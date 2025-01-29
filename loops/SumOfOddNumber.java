package loops;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1
//BS Computer Science
import java.util.Scanner;
public class SumOfOddNumber 
{
	public static void main(String[]args)
	{
		Scanner store = new Scanner(System.in);
		int nth = 0; 	//this holds the value of the nth term
		int odd = 1; //this starts the set of odd numbers
		int sum = 0; //will hold the value of the sum of all odd numbers that are created
		
		System.out.print("Enter Number: ");
		nth = store.nextInt();
		int range = nth; //this serves as the range of how many times the program creates odd numbers
		System.out.print("Odd numbers are: "); 
		
		do
		{
			System.out.print(odd + " "); //prints the odd numbers
			sum += odd; // odd numbers are added every time a new odd number is created 
			odd += 2; //this adds to have the next odd number
			range--; //it decrements until it reaches 0
		}
		while (range != 0); // means that the programs stops when range reached 0
		
		//final displaying output
		System.out.print("\nThe sum of odd numbers upto " + nth +" term is  " + sum);
		
	}
}

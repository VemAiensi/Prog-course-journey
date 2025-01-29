package loops;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1
//BS Computer Science
import java.util.*;
public class AlternateReverse 
{
	public static void main(String[] args)
	{
		Scanner store = new Scanner(System.in);
		int number = 0;
		int altnumber = 1; //this is for the alternative numbers between the numbers
		//it is initialized to 1 since the alternative number always starts at 1
		
		System.out.print("Enter Number: ");
		number = store.nextInt(); //stores the input value to variable number
		
		while (number !=0) //boundary: if number reaches 0, the while loop stops
		{
			//for reverse number
			System.out.print(number + " ");
			number--; //decrements until it reaches 0 and stop the loop
			//for the alternative number
			System.out.print(altnumber + " ");
			altnumber++; //it increments so that the next value has 1 added to it
			
		}
	}
}
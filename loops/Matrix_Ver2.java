package loops;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1 : BS Computer Science
import java.util.Scanner;

/*
 * My first matrix program executes to create a sequence of numbers based on the entered number by user
 * However, when the entered number is an odd number, the last row's order changes
 * for example if 5 is entered the order changed from right to left 
 * So, this second version will make the last row's order written from left to right :) 
 */
public class Matrix_Ver2 
{
	public static void main(String[]args)
	{
		Scanner store = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num = store.nextInt(); //num stores the value entered by the user
		
		//initializations here
		int ans = 0, deductor = 0, adder = 1; //set adder to 1 to make the first number = to square - (number entered-1)
		int inians = num * num;
		
		//first loop: variable row controls the number of row that will be created based on the num entered
		for (int row = num; row > 0; row-- )
		{
		//second loop: same as before, but this ones controls the column based on the num entered
			for (int col = num; col > 0; col-- )
			{
				//to be able to make the matrix, the program needs conditional statements
				//this conditional statements worked differently
				if (row == num) //now, the first row must change when the entered number is odd or even
				{//we need to nest another condition
					if (row % 2 == 0) // this way, the separate operation will execute whether the value of row is even or odd
					{
						ans = inians; inians--; 	
					}
					else
					{
						ans = ((inians - num) +  adder); adder++; //this is because there is no adder (adder=0) in the first number
					} //it doesn't work perfectly yet as it affects other rows, and expected last number there is the square of the number which is 25
				}
				else if (row % 2 == 0) //since the upcoming ans is not based on the inians, condition changes 
				{
					ans = ((inians - num)- deductor); deductor++; //this will create a alternative order if next row value is even
				}
				else // just like the else if, this is used for next rows however, it is used when next row value is odd
				{
					ans = ((inians - num) + adder); adder++; 
				}
				System.out.print(ans + "\t");
			}
			System.out.println(); //forces the cursor to go to next line after performing the 2nd loop
			inians = ans; //this is done to set the last resulting number  (or the ans) as the inians to be used for next rows
			adder = 0; deductor = 0; 
			/*this will reset the value of the variables to continue the loops and condition properly 
			*now it works! again! and with the numbers on the last row written from left to right
			*whether the number is even of odd, the order of the sequence doesn't change 
			*Done! Thank you :)
			*/
		}
	}
}

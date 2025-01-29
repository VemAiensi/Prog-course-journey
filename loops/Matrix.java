package loops;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1 : BS Computer Science
import java.util.Scanner;
public class Matrix 
{
	public static void main(String[] args)
	{
		Scanner store = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num = store.nextInt(); //num stores the value entered by the user
		
		//initializations here
		int ans = 0, deductor = 0, adder = 0;
		int inians = num * num;
		
		//first loop: variable row controls the number of row that will be created based on the num entered
		for (int row = num; row > 0; row-- )
		{
		//second loop: same as before, but this ones controls the column based on the num entered
			for (int col = num; col > 0; col-- )
			{
				//to be able to make the matrix, the program needs conditional statements
				//this conditional statements worked differently
				if (row == num) //this is the expected first row
				{
				ans = inians; inians--; 	
				}
				else if ((inians % num) == 0) //this will provide the next rows
				{
					ans = ((inians - num)- deductor); deductor++; //this will create a alternative order if there is no
					//remainder between inians and num
				}
				else // just like the else if, this is used for next rows however, it is used when there is a remainder
				{
					ans = ((inians - num) + adder); adder++; 
				}
				System.out.print(ans + "\t");
			}
			System.out.println(); //forces the cursor to go to next line after performing the 2nd loop
			inians = ans; //this is done to set the last resulting number  (or the ans) as the inians to be used for next rows
			adder = 0; deductor = 0; 
			//this will reset the value of the variables to continue the loops and condition properly
			//now it works!
			//Done! Thank you :)
		}
	}
}

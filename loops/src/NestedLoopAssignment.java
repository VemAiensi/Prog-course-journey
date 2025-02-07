package labAct1Loops;
import java.util.Scanner;
public class NestedLoopAssignment 
{
	public static void main(String[] args)
	{
		Scanner store = new Scanner (System.in);
		String a = " ", answer = " "; //a is the storage for the character input, answer is for the looping question
		char c = ' ', ansChar = ' '; // c gets the char of a, ansChar gets the char for answer
		int ans; //will serve as the counter in the looping questions
		
		do
		{
			System.out.print("Enter Character: "); //user input for character choice
			a = store.next();
			c = a.charAt(0);
			
			for (int imgSize = 5; imgSize > 0; imgSize--) //controls the rows and decrements imgSize 
				//to stop when there are 5 rows already
			{
				for (int order = imgSize; order > 0; order--) //controls the number of characters per row and decrements to
					// have one less character to imitate an inverted triangular shape
				{
				System.out.print(c + " "); //character + one space
				}
				System.out.println();//cursor next line for rows
			}
			
			//question
			System.out.print("Would you like to continue? [Y/N]\t");
			answer = store.next(); answer = answer.toUpperCase();
			ansChar = answer.charAt(0);
			
			//conditional Statement
			if (ansChar == 'Y')
			{
				ans = 1;
			}
			else
			{
				ans =0;
				System.out.println("Terminate the Program");
			}
		}
		while (ans == 1); //this repeats the entire process when the user answered Y or Yes
		
	}
}

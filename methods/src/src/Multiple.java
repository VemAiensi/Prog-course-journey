package methods;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1
//BS Computer Science
import java.util.Scanner;
public class Multiple 
{
	public static void main(String[] args)
	{
		Scanner store = new Scanner(System.in);
		int integer1 = 0, integer2 = 0 ;
		
		//input
		System.out.print("Enter first integer: ");
		integer1 = store.nextInt();
		System.out.print("Enter second integer: ");
		integer2 = store.nextInt();
		
		//Method here
		System.out.println("\n" + isMethod(integer2, integer1));
		
	}//to test whether the 2nd integer is a multiple of the first, we need to know if it has a remainder when divided
	public static String isMethod(int a, int b)
	{
		String answer = ""; //this serves as the return value 
		int r = a % b; //this gets the remainder value
		//if there is a remainder, it means that the integer is not a multiple of the other one, so we make a conditional statements
		if (r == 0)
			answer = a + " is a multiple of " + b;
		else
			answer = a + " is not a multiple of " + b;
		return answer;
	}
}

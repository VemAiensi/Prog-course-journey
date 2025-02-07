package methods;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1
//BS Computer Science
import java.util.Scanner;
public class Dozen 
{
	public static void main(String[] args)
	{
		Scanner store = new Scanner(System.in);
		int eggs = 0;
		
		System.out.println("===Number of Dozen Eggs Calculator=== ");
		//prompt user to enter number of eggs
		System.out.print("\nEnter number of eggs:\t\t");
		eggs = store.nextInt();
		
		//output
		System.out.println("\nNumber of dozen:\t\t\t" + getDozen(eggs));
		System.out.println("Eggs less thann a dozen:\t" + getRemainder(eggs));
	}
	//creating sub programs/methods
	public static int getRemainder(int r) //it will be easier to get the remainder first
	{
		int remainder = r % 12; 				// this also answers the number of eggs less than a dozen
		return remainder;						 //gives the value of remainder
	}
	public static int getDozen(int d)
	{
		int dozen = (d - getRemainder(d)) /12 ;
		//the value of getRemainder method will be subtracted to d(which will refer to eggs) 
		//to obtain a factor of 12 and then be divided by 12 to get a whole number
		return dozen;
	}
}

package two_Dime_Array;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1 - BS Comp Sci
import java.util.Scanner;
public class TwoDimensionalArray 
{
	public static void main (String []args)
	{
		Scanner store = new Scanner(System.in);
		
		//row and columns input
		System.out.println("Enter number of  rows and columns in the matrix");
		int row = store.nextInt();
		int col = store.nextInt();
		
		//Array
		int matrix[][] = new int [row][col];
		System.out.println();//space
		
		//looping statements for element input
		for (row = 0; row < matrix.length; row++)//controls the row value and updates when col is finished
		{
			for (col = 0; col < matrix[row].length; col++)//controls the value of columns
			{
				System.out.print("Enter element: ");
				matrix[row][col] = store.nextInt(); //stores the value of element to the corresponding array
			}
		}
		System.out.println();
		
		//Printing the matrix
		System.out.println("Matrix input:");
		for (row = 0; row < matrix.length; row++)//controls the row value and updates when col is finished
		{
			for (col = 0; col < matrix[row].length; col++)//controls the value of columns
			{
				System.out.print("\t\t" + matrix[row][col]); //loops until all values in the 2nd dimensional array is printed
			}
			System.out.println();//this separates the rows after the values of columns is printed
		}
		
		//for the transposed matrix
		System.out.println("\nTransposed matrix:");
		for (int altcol = 0; altcol < col; altcol++)
		{
			for (int altrow=0; altrow < row; altrow++)
			{
				System.out.print("\t\t" + matrix[altrow][altcol]); 
				//it executes printing like [0][0], [1][0], [2][0], [3],[0]...
			}
			System.out.println();//this separates the rows after the values of columns is printed
		}
	}//done and thank you po!
}

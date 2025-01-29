package loopAssignments;
import java.util.Scanner;
public class OddSquareCube 
{																									//Vem Aiensi A. Marasigan 1-BSCS-.3\1-BSEMC-.1
	public static void main (String[] args)
	{
		//tools
		Scanner store = new Scanner (System.in);
		
		//Storage
		int n = 0;
		int ctr = 1;
		int square = 0;
		int cube = 0;
		int totalSquare=0;
		int totalCube = 0;
		
		System.out.print("Enter number: "  );
		n = store.nextInt();
		
		System.out.println("\nNumber\tSquare\tCube\n");

		
		while (ctr <= n)
		{
			square = ctr * ctr;
			cube = square * ctr;
			System.out.println(ctr + "\t\t" + square + "\t\t" + cube);
			ctr +=2;
			totalSquare += square;
			totalCube +=cube;
		}
		System.out.print("Total\t" + totalSquare + "\t\t" + totalCube);
	}
}

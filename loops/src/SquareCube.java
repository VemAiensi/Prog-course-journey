package labAct1Loops;
import java.util.Scanner;
public class SquareCube 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n, ctr = 1;
		int square = 0, cube = 0;
		
		System.out.print("Enter n:  ");
		n = input.nextInt();
		
		System.out.println("\nInteger\tSquare\tCube\n");
		while (ctr <= n)
		{
			square = ctr * ctr;
			cube = square * ctr;
			System.out.println(ctr + "\t\t" + square + "\t\t" + cube);
			ctr++;
		}
	}
}

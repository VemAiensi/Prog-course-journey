package labAct1Loops;
import java.util.Scanner;
public class SquareHash 
{
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		int hashSize  = 0;
		int row, numHash;
		System.out.print("Enter size of the hash: ");
		hashSize = input.nextInt();
		
		row = 1;
		while (row <= hashSize)
		{
			for (numHash = 1; numHash <= hashSize; numHash++)
			{
				System.out.print("#");
			}
			System.out.println();
			row++;
		}
	}
}

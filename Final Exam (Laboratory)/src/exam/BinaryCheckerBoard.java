package exam;

public class BinaryCheckerBoard 
{
	public static void main(String args)
	{
		int[][] board = new int[8][8];
		
		for (int a = 0; a < board.length; a++)
		{
			for (int b = 0; b < board.length; b++)
			{
				int ans = a + b;
				
				if ( ans % 2 == 0)
				{
					board [a][b] = 0;
				}
				else
				{
					board [a][b] = 1;
				}
				System.out.print( board [a][b] +"  ");
			}
			System.out.println();
		}
	}
}

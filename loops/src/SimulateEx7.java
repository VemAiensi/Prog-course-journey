package labAct1Loops;

public class SimulateEx7 
{
	public static void main(String[] args)
	{
		int x, y, z=1;
		do
		{
			x = 3;
			while (x >= 1)
			{
				for (y = 1; y <=x; y++)
				{
					System.out.print(x + " ");
				}
				System.out.println();
				x--;
			}
			System.out.println();
			z++;
		}
		while(z < 3);
	}
}

package labAct3Arrays;
//Marasigan, Vem Aiensi A.
public class SimulateEx18 
{
	public static void main(String[] args)
	{
		int[] number = {1, 4, 9, 16, 9, 7, 4, 9, 11};
		int i, altSum = 0;
		for (i = 0; i < number.length; i++)
		{
			if ((i + 1)% 2 == 1)
			{
				altSum += number[i];
			}
			else
			{
				altSum -= number[i];
			}
		}
		System.out.print("Sum is " + altSum);
	}
}

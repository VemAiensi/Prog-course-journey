package labAct3Arrays;
//Marasigan, Vem Aiensi A. 1-BSEMC-.1
public class ArrayCabinetV2 
{
	public static void main(String[] args)
	{
		String[] cabinet = {"socks", "underwear", "shirts", "dresser"};
		
		System.out.println("The contents of the cabinet are:");
		
		int i = 0;
		while (i < cabinet.length)
		{
			System.out.println(cabinet[i]);
			i++;
		}
	}
}

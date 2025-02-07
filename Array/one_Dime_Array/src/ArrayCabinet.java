package labAct3Arrays;
//Marasigan, Vem Aiensi A. 1-BSEMC-.1
public class ArrayCabinet 
{
	public static void main(String[] args)
	{
		String[] cabinet = new String[4];
		cabinet[0] = "socks";
		cabinet[1] = "underwear";
		cabinet[2] = "shirts";
		cabinet[3] = "dresser";
		
		System.out.println("The contents of the cabinet are: \n");
		
		int i = 0;
		while (i < cabinet.length)
		{
			System.out.println(cabinet[i]);
			i++;
		}
	}
}

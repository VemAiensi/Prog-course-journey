package labAct42dArrays;

public class Cabinet2v2 
{
	public static void main(String[] args)
	{
		String[][] cabinet2 = new String[3][2];
		cabinet2[0][0] = "gadgets";
		cabinet2[0][1] = "pliers";
		cabinet2[1][0] = "documents";
		cabinet2[1][1] = "CDs";
		cabinet2[2][0] = "manuals";
		cabinet2[2][1] = "candies";
		
		int layer, sub;
		
		for (layer=0; layer<cabinet2.length; layer++)
		{
			for (sub=0; sub<cabinet2[layer].length; sub++)
			{
				System.out.println("Layer " + layer + " and " + "sub "+sub + " has " + cabinet2[layer][sub]);
			}
			System.out.println();
		}
	}
}

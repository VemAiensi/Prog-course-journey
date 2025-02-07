package labAct2Methods;

public class Border 
{
	public static void main(String[] args)
	{
		printBorder();
		System.out.println("Java rocks!");
		printBorder();
	}
	public static void printBorder()
	{
		int x;
		for ( x = 1; x <= 10; x++)
		{
			System.out.print("=");
		}
		System.out.println();
	}
}

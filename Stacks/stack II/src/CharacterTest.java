package stackII;

public class CharacterTest 
{
	public static void main(String [] args)
	{
		String example = "12";
		System.out.println(Double.parseDouble(example));
//		String array[] = {"(", "+", ")"};
//		int index=0, p_open = 0, p_close = 0;
//		for (int count=0; count <array.length; count++)
//		{
//			if (array[count].equals("(") || array[count].equals(")"))
//			{
//				index++;
//				if (array[count].equals("("))
//				{
//					p_open++;
//				}
//				else
//				{
//					p_close++;
//				}
//			}
//		}
//		System.out.println(index + " " + p_open + " " + p_close);
	}
	static String[] Array_InfixS(String infix)
	{
		String infixS[]; 
		infixS = infix.split(" ");
		return infixS;
	}
	
}

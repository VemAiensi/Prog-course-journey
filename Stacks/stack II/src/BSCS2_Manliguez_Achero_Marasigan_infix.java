import java.util.Scanner; 
import java.util.concurrent.TimeUnit;
public class BSCS2_Manliguez_Achero_Marasigan_infix 
{
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("   *Please be careful in typing Infix String.* \n*Kindly use single space for correctness of code*");
		System.out.println();
		System.out.print("Please type infix statement: ");
		String infix = in.nextLine();
		String [] infix_elements = Array_InfixS(infix);

		boolean proceed = Infix_Checker(infix_elements);
		//proceed = true;
		int choice = 0;
		if (proceed)
		{
			do
			{
			System.out.println("Please choose Operation");
			System.out.print("[1]Postfix Notation\t[2]Prefix Notation\nEnter Option: ");
			choice = in.nextInt();
			System.out.println();
			switch (choice)
			{
				case 1: System.out.print("Analyzing Infix");
					Dots();
					
					display_Filtered_Infix(infix_elements);
					System.out.println();
					//display_Precedence_Level(infix_elements); //for testing only
					int pLevel[] = PrecedenceLvlProvider(infix_elements);
					System.out.println();
					System.out.print("Converting - Please wait");
					Dots();
					PostFix(infix_elements, pLevel);
					System.out.println();
					break;
					
				case 2: System.out.print("Reversing Infix");
					Dots();
					
					String reversed_infix = Reverse_Infix(infix_elements);
					String [] reversed_infix_elements = Array_InfixS(reversed_infix);
					
					System.out.println("\nReversed Infix:");
					display_Filtered_Infix(reversed_infix_elements);
					System.out.println();
					//display_Precedence_Level(reversed_infix_elements); for testing only
					int reversed_pLevel[] = PrecedenceLvlProvider(reversed_infix_elements);
					System.out.println();
					System.out.print("Converting - Please wait");
					Dots();
					PreFix(reversed_infix_elements, reversed_pLevel);
					System.out.print("Reversing Prefix String");
					Dots();
					System.out.println(Reverse_Infix(Array_InfixS(absorber)));
					System.out.println();
					break;
				default:
				System.out.println("Please restart the program");
			}
			
			System.out.print("Do you want to continue? [1]Yes [2]No: ");
			choice = in.nextInt();
			System.out.println();
			
			}while (choice == 1);
		}
		else
		{
			System.out.println("Invalid\n");
			System.out.println("Please restart the program");
		}
		System.out.println();
		System.out.println("Thank you po for using our program\n"
				+ " -Marasigan, Vem Aiensi\n"
				+ " -Achero, Noriel\n"
				+ " -Manliguez, Angelica Mae");
		System.out.println("     ,-*-. \n"
				+ "   ,'  .----.   _________ \n"
				+ "   `.     ,' ) (@)__))___) \n"
				+ "    |`-.-'| #       \\ \n"
				+ "     `---'           ^");
	}
	//delay 
	static void Dots()
	{
		try {
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		System.out.println();
		}
		catch (Exception e)
		{
			
		}
	}
	//array maker
	static String[] Array_InfixS(String infix)
	{
		String infixS[]; 
		infixS = infix.split(" ");
		return infixS;
	}
	
	//infix checker
	static boolean Infix_Checker(String array[])
	{
		
		int element_kind[] = PrecedenceLvlProvider(array);
		
		boolean proceed = true;
		int limiter = 0;
		for (int count=0; count <array.length && proceed; count++)
		{
			if (element_kind[count] != 4 )
			{
				limiter++;
			}
		}
		int element_kind_noparenthesis[] = new int [limiter];
		for (int count=0, index = 0; count <array.length && proceed; count++)
		{
			if (element_kind[count] != 4 )
			{
				element_kind_noparenthesis[index] = element_kind[count];
				index++;
			}
		}
		
		for (int count=1; count <limiter && proceed; count++)
		{
			if (element_kind_noparenthesis[0] > 0 )
			{
				System.out.println("Condtion: operator must not be the at the beginning of the operands");
				proceed = false;
			}
			if (element_kind_noparenthesis[count] > 0 && element_kind_noparenthesis[count-1] > 0)
			{
				System.out.println("Condtion: operator must be in between operands");
				proceed = false;
			}
			if (element_kind_noparenthesis[count] == 0 && element_kind_noparenthesis[count-1] == 0)
			{
				System.out.println("Condtion: operands must have operators between them");
				proceed = false;
			}
		}
		
		for (int count=1; count <array.length && proceed; count++)
		{
	
			if ((element_kind[count] > 0 && element_kind[count] < 4  ) && array[count-1].equals("("))
			{
				System.out.println("Conditon: operators must not be next to an open parenthesis");
				proceed = false;
			}
			if ( array[count].equals(")") && (element_kind[count-1] > 0 && element_kind[count-1] < 4  ) )
			{
				System.out.println("Condition: ther must be no operators before closed parenthesis");
				proceed = false;
			}
		}
		
		if (proceed)
		{
			int index = 0 , p_open = 0, p_close = 0;
			for (int count=0; count <array.length; count++)
			{
				if (array[count].equals("(") || array[count].equals(")"))
				{
					index++;
					if (array[count].equals("("))
					{
						p_open++;
					}
					else
					{
						p_close++;
					}
				}
			}
			
			if (index > 0)
			{
				String parenthesis_order[] = new String[index];
				int parenthesisNum = 0;
				for (int count=0; count <array.length; count++)
				{
					if (array[count].equals("(") || array[count].equals(")"))
					{
						parenthesis_order[parenthesisNum] = array[count];
						parenthesisNum++;
					}
				}
				
				if (p_open != p_close)
				{
					System.out.println("Condition: open and close parenthesis must have the same number");
					proceed = false;
				}
		
				else if (parenthesis_order[0].equals(")") || parenthesis_order[index-1].equals("("))
				{
					System.out.println("Condition: close parenthesis is not expected at the beginning and at the end of the infix string");
					proceed = false;
				}
			}
		}
		return proceed;
	}
	
	//Assigns precedence Levels
	static int[] PrecedenceLvlProvider(String array[])
	{
		int precedence[] = new int [array.length];
		for (int count=0; count <array.length; count++)
		{
			if (array[count].equals("^"))
			{
				precedence[count] = 3;
			}
			else if (array[count].equals("*") || array[count].equals("/"))
			{
				precedence[count] = 2;
			}
			else if (array[count].equals("+") || array[count].equals("-"))
			{
				precedence[count] = 1;
			}
			else if (array[count].equals(")") || array[count].equals("("))
			{
				precedence[count] = 4;
			}
			else
			{
				precedence[count] = 0;
			}
		}
		return precedence;
	}
	
	//print characters
	static void display_Filtered_Infix(String array[])
	{
		for (int count=0; count <array.length; count++)
			System.out.print(array[count] + " ");
	}
	//print precedence level
	static void display_Precedence_Level(String array[])
	{
		int precedence[] = PrecedenceLvlProvider(array);
		for (int count=0; count <precedence.length; count++)
			System.out.print(precedence[count] + " ");
	}
	
	static int size = 0;
	//Stack operations
	//PostFix
	static int limit = 0;
	static void PostFix(String elements[], int pLvl[])
	{
		
		for (int count = 0; count < pLvl.length; count++)
		{//don't be mistaken, it only gives the number of operators
			if (pLvl[count] > 0)
			{
				limit++;
			}
		}
		String stack[] = new String[limit];
		int lvl[] = new int[limit]; //stand alone precedence level for stack of operators
		
			
		for (int count = 0; count < elements.length; count++)
		{
			if ((pLvl[count] == 0) && ((elements[count].equals("(")==false) && (elements[count].equals(")")==false)))
			{
				System.out.print(elements[count] + " ");
			}
			else if (elements[count].equals("("))
			{
				count = parenthesis_Checker(stack, lvl, count, elements, pLvl);
			}
			else if (pLvl[count] > 0 && pLvl[count] < 4)
			{
				stack[size] = elements[count];
				lvl[size] = pLvl[count];
					if (size ==0)
					size++;
					
					else if (lvl[size] > lvl[size-1])
					{
						size++;
					}
					else if (lvl[size] <= lvl[size-1])
					{
						do
						{
							System.out.print(stack[size-1] + " ");
							lvl[size-1] = lvl[size];
							stack[size-1] = stack[size];
							size--;
							
						}while ((size > 0) && (lvl[size] <= lvl[size-1]));
						size++;
					}
			}
			
		}
		
		for (int num= size-1; num >-1; num--)
			System.out.print(stack[num] + " ");
		System.out.println();

	}
	static int raiseLvl = 5;
	static int parenthesis_Checker(String stack[], int lvl[], int count, String elements[], int[] pLvl )
	{
		int boundary = size;
		for (count = count+1; count < elements.length; count++)
		{
			if ((pLvl[count] == 0) && ((elements[count].equals("(")==false) && (elements[count].equals(")")==false)))
			{
				System.out.print(elements[count] + " ");
			}
			else if (elements[count].equals("("))
			{
				raiseLvl = raiseLvl+5;
				count = parenthesis_Checker(stack, lvl, count, elements, pLvl);
			}
			else if (elements[count].equals(")"))
			{
				raiseLvl  = raiseLvl-5;
				for (int num= size-1; num >boundary; num--)
				{
					System.out.print(stack[num] + " ");
					size--;
				}
				return count;
			}
			else if (pLvl[count] > 0)
			{
				stack[size] = elements[count];
				lvl[size] = pLvl[count]+raiseLvl;
					if (size ==0)
					size++;
					
					else if (lvl[size] > lvl[size-1])
					{
						size++;
					}
					else if (lvl[size] <= lvl[size-1])
					{
						do
						{
							System.out.print(stack[size-1] + " ");
							lvl[size-1] = lvl[size];
							stack[size-1] = stack[size];
							size--;
							
						}while ((size > 0) && (lvl[size] <= lvl[size-1]));
						size++;
					}
			}
		}
		return count;
	}

	//Infix reverser
	static String Reverse_Infix(String[] infix)
	{
		String reversed_infix = "";
		for (int reversed_index = infix.length-1; reversed_index>-1; reversed_index--)
			reversed_infix = reversed_infix + infix[reversed_index] + " ";
		return reversed_infix;
	}
	
	//PreFix
	static String absorber = "";
	static int sizePre = 0;
	static int limitPre = 0;
	static void PreFix(String elements[], int pLvl[])
	{	
		for (int count = 0; count < pLvl.length; count++)
		{//don't be mistaken, it only gives the number of operators
			if (pLvl[count] > 0)
			{
				limitPre++;
			}
		}
		String stack[] = new String[limitPre];
		int lvl[] = new int[limitPre]; //stand alone precedence level for stack of operators
		
			
		for (int count = 0; count < elements.length; count++)
		{
			if ((pLvl[count] == 0) && ((elements[count].equals("(")==false) && (elements[count].equals(")")==false)))
			{
				System.out.print(elements[count] + " ");
				absorber = absorber + elements[count] + " ";
			}
			else if (elements[count].equals(")"))
			{
				count = parenthesis_CheckerPrefix(stack, lvl, count, elements, pLvl);
			}
			else if (pLvl[count] > 0)
			{
				stack[sizePre] = elements[count];
				lvl[sizePre] = pLvl[count];
					if (sizePre ==0)
					sizePre++;
					
					else if (lvl[sizePre] >= lvl[sizePre-1])
					{
						sizePre++;
					}
					else if (lvl[sizePre] < lvl[sizePre-1])
					{
						do
						{
							System.out.print(stack[sizePre-1] + " ");
							absorber = absorber + stack[sizePre-1] + " ";
							lvl[sizePre-1] = lvl[sizePre];
							stack[sizePre-1] = stack[sizePre];
							sizePre--;
							
						}while ((sizePre > 0) && (lvl[sizePre] < lvl[sizePre-1]));
						sizePre++;
					}
			}
			
		}
		
		for (int num= sizePre-1; num >-1; num--)
		{
			System.out.print(stack[num] + " ");
			absorber = absorber + stack[num] + " ";
		}
		
		System.out.println("\n");
		
		
	}
	static int raiseLvl_forPrefix = 5;
	static int parenthesis_CheckerPrefix(String stack[], int lvl[], int count, String elements[], int[] pLvl )
	{
		int boundary = sizePre;
		for (count = count+1; count < elements.length; count++)
		{
			if ((pLvl[count] == 0) && ((elements[count].equals("(")==false) && (elements[count].equals(")")==false)))
			{
				System.out.print(elements[count] + " ");
				absorber = absorber + elements[count] + " ";
			}
			else if (elements[count].equals(")"))
			{
				raiseLvl_forPrefix = raiseLvl_forPrefix+5;
				count = parenthesis_CheckerPrefix(stack, lvl, count, elements, pLvl);
			}
			else if (elements[count].equals("("))
			{
				raiseLvl_forPrefix  = raiseLvl_forPrefix-5;
				for (int num= sizePre-1; num >boundary; num--)
				{
					System.out.print(stack[num] + " ");
					absorber = absorber + stack[num] + " ";
					sizePre--;
				}
				return count;
			}
			else if (pLvl[count] > 0)
			{
				stack[sizePre] = elements[count];
				lvl[sizePre] = pLvl[count]+raiseLvl_forPrefix;
					if (sizePre ==0)
					sizePre++;
					
					else if (lvl[sizePre] >= lvl[sizePre-1])
					{
						sizePre++;
					}
					else if (lvl[sizePre] < lvl[sizePre-1])
					{
						do
						{
							System.out.print(stack[sizePre-1] + " ");
							absorber = absorber + stack[sizePre-1] + " ";
							lvl[sizePre-1] = lvl[sizePre];
							stack[sizePre-1] = stack[sizePre];
							sizePre--;
							
						}while ((sizePre > 0) && (lvl[sizePre] < lvl[sizePre-1]));
						sizePre++;
					}
			}
		}
		return count;
	}

}

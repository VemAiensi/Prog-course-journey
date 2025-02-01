public class Tools 
{
	//Sorting Tools
		public static boolean sortingChecker(int[] array, int start, int end)
		{
			for (; start < end; start++)
			{
				if (array[start+1] < array[start] )
				{
					return true;//means it's not sorted yet
				}
			}
			return false; //break
			/* Note: since this checker that is responsible for breaks is working properly
		 	I decided to replace the algorithm a little to make use of its effectiveness*/
		}
		public static void passIndicator(int pass)
		{
			if (pass == 1 )
			{
				System.out.print(pass + "st\tPASS");
			}
			if (pass == 2)
			{
				System.out.print(pass + "nd\tPASS");
			}
			if (pass == 3)
			{
				System.out.print(pass + "rd\tPASS");
			}
			if (pass > 3)
			{
				System.out.print(pass + "th\tPASS");
			}
		}
		public static int indexFinder(int value, int[] Array, int start, int end)
		{
			int b;
			for(b = start; b<end; b++)
			{
				if(value == Array[b])
				{
					break;
				}
			}
			return b;
		}
		public static int[] shiftElements(int[]Array, int start, int end)
		{
			for (; end>start; end--)
			{
				Array[end]=Array[end-1];
			}
			return Array;
		}
		public static int findMin(int[] A, int start, int end)
		{
			int min=0; int isLess=0;
			for (int a = start; a<=end; a++)
			{
				for (int b = start; b<=end; b++)
				{
					if (A[a] < A[b])
					{
						isLess++;
					}
				}
				if (isLess == (end-start))
				{
					min = A[a];
					break;
				}
				else
				{
					isLess = 0;
				}
			}
			return min;
		}
		//Designing Tools
		public static void PrintInFormat1(int[] array, String name)
		{
			System.out.print(name);
			Tools.PrintLine(array, 1);
			Tools.Space();
			System.out.print("|");
			Tools.ArrayPrintWithoutBorder(array);
			System.out.print("|");
			Tools.Space();
			System.out.print("+");
			Tools.PrintLine(array, 0);
			Tools.Space();
		}
		public static void PrintInFormat2(int[] array, int pass)
		{
			System.out.print("|");
			Tools.ArrayPrintWithoutBorder(array);
			System.out.print("| ");
			Tools.passIndicator(pass);
			Tools.Space();
		}
		public static void PrintInFormat3(int[] array)
		{
			System.out.print("+");
			Tools.PrintLine(array, 0);
			Tools.Space();
		}
		public static void ArrayPrintWithBorder(int[] array)
		{
			System.out.print("\t\t+");
			for (int i = 0; i < array.length; i++)
			{
				System.out.print("-------+");
			}
			System.out.println();
			
			System.out.print("SORTED ARRAY:\t");
			System.out.print("|");
			for (int i = 0; i < array.length; i++)
			{
					System.out.print(array[i] + "\t|");
			}
			System.out.println();
			
			System.out.print("\t\t+");
			for (int i = 0; i < array.length; i++)
			{
				System.out.print("-------+");
			}
			System.out.println();
		}
		public static void ArrayPrintWithoutBorder(int[] array)
		{
			for (int i = 0; i < array.length; i++)
			{
					System.out.print(array[i] + "\t");
			}
		}
		public static void Space()
		{
			System.out.println();
		}
		public static void PrintLine(int[] array, int start)
		{
			for (int i = start; i < array.length; i++)
			{
				if (i == array.length-1)
				{
					System.out.print("-------+");
				}
				else
				{
					System.out.print("--------");
				}
			}
		}
		public static void Menu()
		{
			System.out.print("Menu\n\t1. Bubble\n"
					+ "\t2. Insertion\n\t3. Selection\n"
					+ "\t4. Exit\nEnter Option[1..4]: ");
		}
		public static void End()
		{
			System.out.print("Thank you po for checking my program ^_^\n"
					+ "\t-Marasigan, Vem Aiensi A.");
			System.exit(0);;
		}
	}


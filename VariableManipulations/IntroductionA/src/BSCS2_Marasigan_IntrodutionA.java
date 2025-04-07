import java.util.Scanner;
public class BSCS2_Marasigan_IntrodutionA 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input, choice = 0;
		char d='N';
		do
		{
			//user input here
			System.out.print("Input Integer Value:\t");
			input = in.nextInt();
				do
				{
					//options here
					System.out.print("\nWhat do you want to do?\n1.\tSum of digits\n2.\tReverse the number"
							+ "\n3.\tDisplay all the prime number from 2 to n (n is the user's input).\n\t"
							+ "  Apply the algorithm of Sieve of Eratosthenese\n"
							+ "4.\tPalindrome Checking\n5.\tOdd or even number"
							+ "\n6.\tExit\n\n Enter option [1..6]:\t");
					choice = in.nextInt();
		
					//make methods for clarity
					switch (choice)
					{
						case 1: 	sumOfDigit(input); 										break;
						case 2:		System.out.println(reverse(input));			  	break;
						case 3: 	seiveOfErathosthenese(input);						break;
						case 4: 	System.out.println(palindrome(input)); 		break;
						case 5: 	System.out.println(oddOrEven(input));		break;
						case 6:  			d = 'N';													break;
					}
				
					if (choice < 6)
					{
						System.out.print("\nWant to try other options? [Y/N]:\t");
						String decide = in.next().toUpperCase();
						d = decide.charAt(0);
					}
					
				}while (d == 'Y');
				
				if (choice < 6)
				{
					System.out.print("Want to try other Integer input? [Y/N]:\t");
					String decide = in.next().toUpperCase();
					d = decide.charAt(0);
					System.out.println();//just a space
				}
			}while (d == 'Y');
			end();
			in.close();
		}
	
								//methods here
	
		//												Tools Here (-.-;)
		//digit analyzer
		static int[] getDigits(int a)
		{
			String numbers = Integer.toString(a);
			long limit = numbers.chars().count();
			int l = (int)limit;
			int storage[] = new int [l];
			for (int set = 0; set < l; set++)
			{
				storage[set] = a % 10;
				a = a /10;
			}
			return storage;
		}
		//get sum of array element (for integer elements only)
		static int arraySum(int []a)
		{
			int w = 0; 
			for (int d = 0; d<a.length; d++)
			{
				w += a[d];
			}
			return w;
		}
		
		//										User choices here (~.~!)
		//choice 1
		static void sumOfDigit(int a)
		{
			System.out.print("The digits are:");
			int[] set = getDigits(a);
			int sum = 0;
			for (int digits = set.length - 1; digits > -1; digits-- )
			{
				System.out.print(" " + set[digits]);
				sum += set[digits]; 
				if (digits != 0)
				{
					System.out.print(" +");
				}
			}
			System.out.println("\nThe sum of the digits is: " + sum);
		}
		
		//choice 2
		static String reverse(int a)
		{
			int [] set = getDigits(a);
			String show = "";
			for (int digits = 0; digits <set.length; digits++)
			{
				show += set[digits];
			}
			return show;
		}
		
		//choice 3 (Oh globb!! I hate you so much!!!)
		static void seiveOfErathosthenese(int a)
		{
			int limit = a; 						//a is integer input
			int deduct = limit-1; 		
			int array[] = new int [limit];
			int arrayBackUp[] = new int [limit];
			int first=1, second=0; //contains the sum of array[] and arrayBackup[] for simple comparison 
			for (int s = 0; s < limit; s++)	//gives the array's elements from 1...a
				{
					array[s] = limit - (deduct);
					deduct--;
				}
			for (int s = 1; s<limit; s++ ) //prints 2..a in the first row
				{
					System.out.print(array[s]+"\t");
				}
			System.out.println();//moves the cursor next line for upcoming array prints
			int remainder;
			for (int n = 1; first != second ; n++)
			{
				if (array[n] !=0)
				{
					for (int s = 0; s < limit; s++) 
					{//this loop is placed here so that if array[n] = 0, it will skip too and won't create backup
						arrayBackUp[s] = array[s]; 
					}//creates a backup of the array[] bago dumaan ung array[] sa paguupdate of elements
					second = arraySum(arrayBackUp); //separate program that adds the value of array elements
				
					for (int s = array[n]; s<limit; s++)
					{
						remainder = array[s] % array[n]; //filters out the numbers that has a factor of whatever the value
						if (remainder == 0)						// of array[n] is.
						{// arrays[s] whatever the number it is will be converted to zero when it has a factor of array[n]
							array[s] = 0; 
						}//this is the array updater I'm talking about in no. 142
					}
					
					first = arraySum(array);
					if (first == second) //this only prints a space if the first and second is already similar
					{
						System.out.println(); 
					}
					for (int s = 1; s<limit; s++ )
					{
						if (array[s] !=0)
						{//this skips the element that is zero
							System.out.print(array[s]+"\t");
						}
					}
					System.out.println();	//This only moves the cursor to next line for upcoming array prints
				}
			}
			System.out.println("Above are the prime numbers inside " + limit);
		}
		
		//choice 4
		static String palindrome(int a)
		{
			String answer = "";
			String comp = reverse(a);
			int b = Integer.parseInt(comp);
			if (b == a)
			{
				answer = comp + " is Palindrome";
			}
			else
			{
				answer = comp + " is not Palindrome";
			}
			return answer;
		}
		
		//choice 5
		static String oddOrEven(int a)
		{
			String answer = "";
			double result = (a % 2);
			if (result == 0)
				answer = a + " is an Even number."; //sorry I forgot to include a space >.<
			else
				answer = a + " is an Odd number.";
			return answer;
		}

		//choice 6
		static void end()
		{
			System.out.println("\n\t\tThank You po for Using my Program\n"
					+ "\t\t\t\t-Vem Aiensi ^_^");
		}
}

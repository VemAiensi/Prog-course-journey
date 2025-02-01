package introduction;
import java.util.*;
public class BSCS2_Marasigan_IntroductionB 
{
	public static void main(String[] args)
	{
		int choice=0; 
		char d ='N';
		Scanner in = new Scanner(System.in);
		do
		{
			System.out.print("INPUT STRING 1:\t");
			String one = in.nextLine();
			System.out.print("INPUT STRING 2:\t");
			String two = in.nextLine();
			String three = "String 3 does not have any value yet.";
			do 
			{
				System.out.print("\nOPTIONS:\n1. String Copy"
						+ "\n2. String concatination\n3. String Comparison"
						+ "\n4. Reverse a string input\n5. Convert a string input "
						+ "(uppercase to lowercase & lowercase to upper case)"
						+ "\n6. Toggle a string\n7. Exit\n\nEnter option [1..7]:\t");
				choice = in.nextInt();
				int ans = 0, ans2= 0;
				String first, second;
				
				switch (choice)
				{	
				case 1: System.out.print("What String do you want to copy?"
							+ "\n Please type String no. [1,2]: "); 
							ans = in.nextInt();
							three = answerFinder(ans, one, two, three);
							System.out.println("String 3 is: " + three);		
							break;
					
				case 2: System.out.print("What String do you want to concatinate?"
							+ "\n Please type two String nos. [1,2,3]: "); 
							ans = in.nextInt(); ans2 = in.nextInt(); 
							first = answerFinder(ans, one, two, three); 
							second=answerFinder(ans2, one, two, three);
							System.out.println(first.concat(second));
							break;
					
				case 3: System.out.print("What String do you want to compare?"
							+ "\n Please type two String nos. [1,2,3]: "); 
							ans = in.nextInt(); ans2 = in.nextInt(); 
							first = answerFinder(ans, one, two, three); 
							second=answerFinder(ans2, one, two, three);
							comparison(first, second);
							break;
					
				case 4: System.out.print("What String do you want to reverse?"
							+ "\n Please type String no. [1,2,3]: "); 
							ans = in.nextInt();
							first = answerFinder(ans, one, two, three);
							StringBuilder r = new StringBuilder();
							r.append(first);
							System.out.println(r.reverse());
							break;
					
				case 5: System.out.print("What String do you want to Convert?"
							+ "\n Please type String no. [1,2,3]: "); 
							ans = in.nextInt();
							first = answerFinder(ans, one, two, three); 
							System.out.println("Uppercase:\t" + first.toUpperCase() 
							+"\nLowercase:\t" + first.toLowerCase());
							break;
					
				case 6: System.out.print("What String do you want to Toggle?"
							+ "\n Please type String no. [1,2,3]: "); 
							ans = in.nextInt();
							first = answerFinder(ans, one, two, three); 
							System.out.println("\nThe toggled word is " + toggler(first));
							break;
							
				case 7:  d = 'N'; break;
				}
				if (choice < 7)
				{
					System.out.print("\nWant to try other options? [Y/N]:\t");
					String decide = in.next().toUpperCase();
					d = decide.charAt(0);
				}
			}while (d == 'Y');
			
			if (choice < 7)
			{
				System.out.print("Want to try other String input? [Y/N]:\t");
				String decide = in.next().toUpperCase();
				d = decide.charAt(0);
				System.out.println();//just a space
			}
			in.nextLine();//fixes the skipping when loop by absorbing the line input of variable char
			
		}while (d == 'Y');
		end();
		in.close();
	}
	static String answerFinder(int a, String one, String two, String three)
	{
		String str = "";
		switch (a)
		{
		case 1:  str = one; break;
		case 2:  str = two; break;
		case 3:  str = three; break;
		}
		return str;
	}
	static void comparison(String a, String b)
	{
		int result =a.compareTo(b);
		switch (result)
		{
		case 0: 		System.out.println("0");
							System.out.println("They are exactly similar!");	
							break;
		case -32: 	System.out.println("-1");
							System.out.println("It is similar, but it differs in Capitalization");	
							break;
		case 32: 		System.out.println("1");
							System.out.println("It is similar, but it differs in Capitalization");	
							break;
		default:  	System.out.println("There are no similarities");	
		}
	}
	static 	String toggler(String choice)
	{
		String toggled = "";
		char letter[] = choice.toCharArray();
		for (int s = 0; s<letter.length; s++)
		{	//There is a difference of 32(dec) between a Capital letter and its lower case
			if (letter[s] >= 'A' && 'Z' >= letter[s])
			{//if 'A' = 65, then 'a' is = 97 so adding 32 converts it to lower case
				letter[s] = (char)((int)letter[s]+32); 
			}
			else if (letter[s] >= 'a' && 'z' >= letter[s])
			{//if 'a' = 97, then subtracting 32 will make it 65 which has the char value of 'A'
				letter[s] = (char)((int)letter[s]-32);
			}
			toggled += letter[s];
		}
		return toggled;
	}
	static void end()
	{
		System.out.println("\n\t\tThank You po for Using my Program\n"
				+ "\t\t\t\t-Vem Aiensi ^_^");
	}
}

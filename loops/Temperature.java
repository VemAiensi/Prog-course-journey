package loops;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1
//BS Computer Science
import java.util.Scanner;
import java.text.DecimalFormat;
public class Temperature 
{
	public static void main (String [] args)
	{
		DecimalFormat d = new DecimalFormat("#.0000");
		Scanner store = new Scanner(System.in);
		// Value holders
		String letter = " "; char choice = ' ';
		
		//loop must start here (using for loop)
		for (; choice != 'c';)
			//as long as the user is not choosing the option 'c' , the program repeats
		{
		System.out.println("Main Menu\n"
				+ "a. Celsius  to Fahreheit\nb. Fahrenheit to Celsius\nc. Exit\n");
		System.out.print("Choose option [a, b, or c]: ");
		letter = store.next().toLowerCase(); //Letter must be lowered case to make sure the input is correct whether it is capitalized or not
		choice = letter.charAt(0); //gets the first letter of input
		System.out.println();
		
		//conditional statements (the program will be using switch case)
		switch (choice)
		{
		case 'a' : 
			System.out.println("Celsius - Fahrenheit Conversion");
			System.out.print("Enter Celsius: "); //next user input for choice 'a'
			double a = store.nextDouble(); //double is used since measurements can have decimal places. a stands for the Celsius that is entered.
			double fah = 9.0/5.0 * a + 32; //the formula for conversion to fahrenheit: fah = fahrenheit 
			System.out.println("Fahrenheit equivalent is " + d.format(fah) +"\n" ); break;
		case 'b' : 
			System.out.println("Fahrenheit - Celsius Conversion");
			System.out.print("Enter Fahrenheit: "); //next user input for choice 'b'
			double b = store.nextDouble(); //double is used since measurements can have decimal places. b stands for the Fahrenheit that is entered.
			double cel = (b - 32) * 5.0/9.0; //the formula for conversion to celsiust: cel = celsius
			// other variable name is used because variable names cannot be repeated
			System.out.println("Celsius equivalent is " + d.format(cel) + "\n" ); break; 
		case 'c' :
			System.out.println("End of Program. Good bye!"); break;
		default: System.out.println("Wrong code, Please try again\n"); 
		//conditional statements done! next will be the loop :)
		}
		//done!
		}
	}
}

package forProfYumiePasiol;

import java.util.Scanner;
import java.text.DecimalFormat;
public class Converter_Switch_Case 
{
	public static void main(String[] args)
	{
		//Hello po and Good po 
		//I'm Vem Aiensi Marasigan po and  I'm glad po that you visited my program :)
		
		//Since the program is the same, I'll be revising my previous program by using switch and case statements
		
		//Tools first
				Scanner store = new Scanner(System.in);
				DecimalFormat d = new DecimalFormat("###,###,###.00");

				
				//My Data Storage
				String name ="initialize!";				char letter ='i';							String unit = "initialize!";
				String choice = "initialize!";				double value = 0;						String newUnit = "initialize!";
				String description ="initialize!";		double newValue = 0;				int correct = 1; //1 means true
				
				
				//user name  input here
				System.out.println("Hi! What is your name?");
				name = store.nextLine();
				System.out.println("\n=====Metric Conversion=====");
				System.out.println("Alright " + name + ", Choose the letter for your conversion:"
						+ "\n[a]kg to pounds\n[b]pounds to kg\n[c]ounces to grams\n[d]grams to ounces");
				
				//choice input here
				System.out.print("\nInput for Conversion: ");
				choice = store.next(); choice = choice.toLowerCase();
				//this way, the value of choice will be forced to be at lower case
				letter = choice.charAt(0); 				//this is make sure that the stored value is a single character
				
				
				//Now for the switch and case statements
				switch (letter)
					{
				case 'a':
					description = "kg to pounds."; unit = " kg"; newUnit = " in pounds"; break;
				case 'b':
					description = "pounds to kg.";  unit = " lb"; newUnit = " in kilograms"; break;
				case 'c':
					description = "ounces to grams.";  unit = " oz"; newUnit = " in grams"; break;
				case 'd':
					description = "grams to ounces.";  unit = " gm"; newUnit = " in ounces"; break;
				default:
					System.out.println(" Not in the choices,  \nThank you"); correct = 0; break; //0 means false
					}
				
				//Let's make the print , since switch statements does not allow boolean data type, 
				//the variable "correct" will be revised into an int
				
				switch (correct)
				{
				case 1:
					{
						System.out.println("You have chosen "+ description);
					
						//value to convert input here
						System.out.print("\nInput the value: ");
						value = store.nextDouble();
				
						//Let's put the calculations here: revised to switch and case statements
						switch (letter)
							{
							case 'a':
								newValue = value * 2.20462; break; //converts kg to pounds
							case 'b':
								newValue = value / 2.20462; break; //converts pounds to kg
							case 'c':
								newValue = value * 28.3495; break;//converts ounces to grams
							case 'd':
								newValue = value / 28.3495; break;//converts grams to ounces
							}
					}
				//This is the final print
				System.out.println("The " + d.format(value) + unit + " is " + d.format(newValue) + newUnit  );
				} // this should do the trick! Thank you!
	}//Done!
}

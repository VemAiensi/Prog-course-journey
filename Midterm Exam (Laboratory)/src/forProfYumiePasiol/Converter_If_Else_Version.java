package forProfYumiePasiol;

import java.util.Scanner;
import java.text.DecimalFormat; //This will be needed later
public class Converter_If_Else_Version 
{
	public static void main(String[] args)
	{
		//Hello po and Good day po, I'm Vem Aiensi Marasigan po
		// And I'm very sorry po for not mentioning my name in my previous programs
		
		//Let's Start!
		
		//Tools first
		Scanner store = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("###,###,###.00");

		
		//My Data Storage
		String name ="initialize!";				char letter ='i';							String unit = "initialize!";
		String choice = "initialize!";				double value = 0;						String newUnit = "initialize!";
		String description ="initialize!";		double newValue = 0;				boolean correct = true;
		
		
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
		
		
		//Now for the if and else Statements
		if (letter == 'a')
			{description = "kg to pounds."; unit = " kg"; newUnit = " in pounds";}
		else if (letter == 'b')
			{description = "pounds to kg.";  unit = " lb"; newUnit = " in kilograms";}
		else if (letter == 'c')
			{description = "ounces to grams.";  unit = " oz"; newUnit = " in grams";}
		else if (letter == 'd')
			{description = "grams to ounces.";  unit = " gm"; newUnit = " in ounces";}
		else
			{System.out.println(" Not in the choices,  \nThank you"); correct = false;}
		
		//Let's make the print , this should also have an if statement
		if (correct == true)
		{
			System.out.println("You have chosen "+ description);
		
		//value to convert input here
		System.out.print("\nInput the value: ");
		value = store.nextDouble();
		
		//Let's put the calculations here: (I guess haha), we need another data
		if (letter == 'a')
			newValue = value * 2.20462; //converts kg to pounds
		else if (letter == 'b')
			newValue = value / 2.20462; //converts pounds to kg
		else if (letter == 'c')
			newValue = value * 28.3495; //converts ounces to grams
		else if (letter == 'd')
			newValue = value / 28.3495; //converts grams to ounces
		
		//This is the final print
		System.out.println("The " + d.format(value) + unit + " is " + d.format(newValue) + newUnit  );
		} // this should do the trick! Thank you!
		
		//Finally it's over
		// Let's do test running in a separate video
		//Thank you po!
	}
}

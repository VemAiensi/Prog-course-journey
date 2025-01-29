package conditionalStatement;
import java.util.Scanner;
import java.text.DecimalFormat;
public class SalesDiscount 
{
	public static void main(String[] args)
	{
		//Variables
		DecimalFormat d = new DecimalFormat("###,###,###.00 PHP");
		Scanner input = new Scanner(System.in);
		String product = "";
		double price = 0.0;
		double discount = 0.0;
		
		//Input data
		System.out.print("Enter product name: ");
		product = input.nextLine();
		System.out.print("Product Price: ");
		price = input.nextDouble();
		
		//Conditional Statements Here
		if (price >= 0 && price <=10000)
			discount = 0;
		
		else if (price >= 10001 && price <=20000)
			discount = price * 0.05;	
		
		else if (price >= 20001 && price <=50000)
			discount = price * 0.10;
		
		else if (price >= 50001 && price <=100000)
			discount = price * 0.15;
		
		else if (price > 10000)
			discount = price * 0.20;
		
		else
			System.out.println("That's weird!");
		
		
		//This will print all the output
		System.out.println("\nThe price of the " + product + " is " + d.format(price));
		/*
		 * this is done to show that there will be no discount for those products 
		 * with price below 10,000 Php
		 * This won't hurt the customer XD
		 * I chose to not show the discount since its just 0
		 * so that the customer won't feel bad for not having a discount
		 * 
		 * By the way lets still try it if there is no if statement below
		 * and see if it still works
		 */
		if (discount > 0)
		{
		System.out.println("Enjoy a Discount of " + d.format(discount) + "!"); 
		System.out.println("The Net Price is now " + d.format(price - discount));
		}
		System.out.println("Thank You for using our system!" );
	}
}

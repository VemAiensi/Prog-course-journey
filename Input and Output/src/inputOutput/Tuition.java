package inputOutput;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Tuition 
{
	public static void main(String[] args)
	{
		//variables
		DecimalFormat decimal =new DecimalFormat("###,###,###.00 dollars");
		Scanner insert = new Scanner(System.in);
		String name;
		int units;
		double price;
		double tuition;
		double payCash;
		double pay2Installment;
		double pay3Installment;
		
		// Prompt user to input information 
		System.out.print("Enter Name: ");
		name = insert.nextLine();
		System.out.print("Number of units taken: ");
		units = insert.nextInt();
		System.out.print("Enter price per unit: ");
		price = insert.nextDouble();
		
		//operations
		tuition = price*units;
		//cash has 10% discount
		payCash = tuition - (tuition*0.10);
		//2 installments has 5% penalty
		pay2Installment = tuition + (tuition*0.05);
		//3 installment has 10% penalty
		pay3Installment = tuition + (tuition*0.10);
		
		//Final print
		System.out.println("\nComputed Tuition fee: " + decimal.format(tuition));
		System.out.println(name + ", you could avail the following payment modes:");
		System.out.println("\nCash Payment:\t" + decimal.format(payCash));
		System.out.println("2-Installment:\t" + decimal.format(pay2Installment));
		System.out.println("3-Installment:\t" + decimal.format(pay3Installment));
		
	}
}

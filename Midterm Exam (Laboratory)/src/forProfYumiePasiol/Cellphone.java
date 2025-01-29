package forProfYumiePasiol;
// Name of Student: Vem Aiensi Marasigan :-)
import java.util.Scanner;
import java.text.DecimalFormat; 
public class Cellphone 
{
	public static void main(String[] args)
	{
		//Tools
		Scanner store = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("$ ###,###,###.00");
		
		//Storage
		String product1 = "initialize!";								double price1 = 0; 						char letter = 'i';	
		String product2 = "initialize!";								double price2 = 0;						int payMode = 0;
		String product3 = "initialize!";								double price3 = 0;						int correct = 1;
		String choice = "initialize!"; 									double price = 0;							int discount = 0;
		String product = "initialize!";									double modifier = 0;					int month3 = 0;
		String payDescription = "initialize!";					double tPrice = 0;							int month6 = 0;
																									double amortization =0;			int month12 = 0;
		
		//Product inputs
		System.out.print("Enter Product 1:\t\t");						product1 = store.nextLine();
		System.out.print("Enter Price:\t\t\t\t$");					price1 = Double.parseDouble(store.nextLine());
		System.out.print("\nEnter Product 2:\t\t");				product2 = store.nextLine();
		System.out.print("Enter Price:\t\t\t\t$");					price2 = Double.parseDouble(store.nextLine());
		System.out.print("\nEnter Product 3:\t\t");				product3 = store.nextLine();
		System.out.print("Enter Price:\t\t\t\t$");					price3 = Double.parseDouble(store.nextLine());
		
		//Mode payment inputs
		System.out.println	("\n\nInput Mode of Payment Terms\n");
		System.out.print		("Cash Discount:\t\t\t");								discount = store.nextInt();
		System.out.println	("\tYou input " 		+ discount 	+ 		"%" 		+ 		" Discount for Cash" );
		System.out.print		("\n3 Months installment:\t");					month3 = store.nextInt();
		System.out.println	("\tYou input " 		+ month3 	+ 		"%"			+ 		" Interest for  3 Months installment" );
		System.out.print		("\n6 Months Installment:\t");					month6 = store.nextInt();
		System.out.println	("\tYou input " 		+	month6	+ 		"%" 		+ 		" Interest for 6 Months Installment" );
		System.out.print		("\n12 Months Installment:\t");				month12 = store.nextInt();
		System.out.println	("\tYou input " 		+ month12 	+ 		"%" 		+ 		" Interest for 12 Months Installment" );
		
		//Choices show case for products with price
		System.out.println("\n\nMain Menu\n");
		System.out.println("Press I/i: " 	+ product1 + 	"\t\t\t\t " 	+ d.format(price1));
		System.out.println("Press S/s: " 	+ product2 + 	"\t\t " 			+ d.format(price2));
		System.out.println("Press X/x: " 	+ product3 + 	"\t\t " 			+ d.format(price3));
		
		//Choice input
		System.out.print("\nEnter Item: \t\t"); 		//makes sure that characters are stored as single lower cased letters			
		choice = store.next(); 											choice = choice.toLowerCase();				letter = choice.charAt(0); 
		
		//switch for the choice done
		switch (letter)	{
			case 'i': product = product1; 	price = price1; break;
			case 's': product = product2; 	price = price2; break;
			case 'x': product = product3; 	price = price3; break;
			default : correct = 0;  System.out.println("\n\t\tWrong code >_<,\n  Please reset the program :-) "); break;}				
			//this way, the program will stop when a wrong code/letter is typed
		
		//switch if there is no wrong code, proceeds if all input are correct (correct=1)
		switch (correct) 	{
			case 1:	 				
			//Choices show case for payment modes
			System.out.println("Your Item is " + product + "\nPrice: \t\t\t\t" + d.format(price));
			System.out.println("\n\nSelect Mode of Payment\n\nPress 1: Cash\t\t\t\t\t\t"	+	(discount)	 +
													"% Discount\nPress 2: 3 Months Installment\t\t" 					 	+	( month3) 	 +
													"% Interest\nPress 3: 4 Months Installment\t	"								+	 (month6 )	 +	 
													"% Interest\nPress 4: 12 Months Installment\t\t"							+	 (month12)  + 		
													"% Interest"); break;}
		
		//switch if there is no wrong code, proceeds if all input are still correct (correct=1)
		switch (correct)	{
			case 1:	
				//Choice input
				System.out.print("\nEnter Mode of Payment: \t\t\t"); 		payMode = store.nextInt();
				switch (payMode)
				{
					case 1:	payDescription = "Cash";											modifier = price * discount/100;
									tPrice = price - modifier;											break;
					case 2:	payDescription = "3 Months Installment";		modifier = price * month3/100;
									tPrice = price + modifier;											amortization = tPrice/3; 							break;
					case 3: payDescription = "6 Months Installment";			modifier = price * month6/100;
									tPrice = price + modifier;											amortization = tPrice/6; 							break;
					case 4:	payDescription = "12 Months Installment";		modifier = price * month12/100;
									tPrice = price + modifier;											amortization = tPrice/12; 							break;
					default: correct = 0;  System.out.println("\n\t\tWrong code >_<,\n  Please reset the program :-) "); break;}
				
			}
				//final output, will only show if all inputs are correct (correct=1)
		switch (correct)	{
			case 1:		
				System.out.println("Mode of Payment:\t\t\t\t\t" 					+ 			payDescription			+
														"\nItem:\t\t\t\t\t\t\t\t" 								+ 			    	product 				+ 
														"\nPrice:\t\t\t\t\t\t\t\t"								+ 		  d.format(price)	 		+
														"\nDiscount/Interest:\t\t\t\t\t"				+		d.format(modifier)		+
														"\nTotal Amount:\t\t\t\t\t\t"						+		   d.format(tPrice)		+
														"\nMonthly Amortization:\t\t\t\t"			+	d.format(amortization) );}
		//test run done! Yehey
			
	}
}

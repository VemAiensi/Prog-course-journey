import java.util.Scanner;
import java.text.DecimalFormat;
public class Fare 
{
	public static void main(String[] args)
	{
		//variables
		Scanner in = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("PHP ###,###,###.00");
		double fare=0, discount=0, charge=0;
		String passType;
		String answer;
		String rightCode ="Yes";
		//input Data
		System.out.print("Enter Fare: ");
		fare = in.nextDouble();
		
		System.out.print("Please refer to the passenger code below: " + 
				"\n\tO: Ordinary\n\tS: Student" +
				"\n\tC: Senior Citizen\nPlease type your passenger code here: ");
		passType = in.next(); passType = passType.toUpperCase();                         
		//This needs to store  a single letter to a char variable and also be upper case
		char passCode = passType.charAt(0);
		
		System.out.print("Are you Traveling in business class?" + 
				"\n\tYes or No: "); //answer must be stored in upper case so:
		answer = in.next();        
		answer = answer.toUpperCase();
		
		
		//for the switch statements
		switch (passCode)
			{
				case 'O' : 
					discount = 0;
					charge = 1000;
					break;
				case 'S' : 
					discount = fare*0.05;
					charge = 700;
					break;
				case 'C' : 
					discount = fare*0.10;
					charge = 500;
					break;
				// code not within the selection must make output 0, so: make another variable
				default: rightCode = "No"; break;
			}
		
		
		//switch statements for the answer in traveling in business class
		switch (answer)
			{
				case "YES": break;
				case "NO": charge =0; break;
				default: rightCode = "No"; break;
			}
		
		
		//final output
		switch (rightCode)
			{
			case "Yes":
				System.out.println("\nDiscount: \t\t\t\t" + 
					d.format(discount));
				System.out.println("Business class charge: \t\t" + 
					d.format(charge) );
				System.out.println("New Fare: \t\t\t\t" + 
					d.format(fare - discount + charge));
				System.out.println("\nEnd of Transaction :-)");
			break;
			case "No":
				System.out.println("\n"+0);	
				//this makes all output 0 if there is a wrong code
			}
		//Done!
	}
}

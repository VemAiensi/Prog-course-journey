package car;
import java.text.DecimalFormat;
import java.util.*;
public class CarUpgrade 
{//Marasigan, Vem Aiensi
	public static void main(String[] args)
	{
		//Instantiations
		DecimalFormat df = new DecimalFormat("#,###,##0.00php");
		Scanner in = new Scanner(System.in);
		Car sasakyan = new Car();
		
		//Owner input
		System.out.print("Owner: ");
		String name = in.nextLine();
		System.out.print("Year Model: ");
		int model = in.nextInt();
		
		//Available amount input
		System.out.print("Please type available amount: ");
		sasakyan.av = in.nextInt();
		System.out.println();
		
		//Process
		sasakyan.owner(name, model);
		System.out.println("Available Amount Before Upgrade: " + df.format(sasakyan.av));
		sasakyan.upgradeAccesories();
		System.out.println("Amount Remaining After Upgrade: " + df.format(sasakyan.av));
	}
}

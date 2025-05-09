import java.text.DecimalFormat;

public class Account
{
	DecimalFormat df = new DecimalFormat("$#,###.00");
	String name = "";
	double balance = 0;
	double withdrawal = 0;
	
	void debit()
	{
		System.out.print("\nSubtracting " + df.format(this.withdrawal) 
		+ " from " + this.name + "'s balance\n");
		
		if (this.balance >= this.withdrawal)
		{
			this.balance -=  this.withdrawal;
		}
		else
		{
			System.out.println("\nDebit amount exceeded account balance.");
		}
	}
	
	void Show_Balance()
	{
		System.out.println(this.name + " balance: " + df.format(this.balance));
	}
}
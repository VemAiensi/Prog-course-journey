import java.util.Scanner;
//Marasigan, Vem Aiensi
public class AccountRun 
{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		//Account 1
		Account account1 = new Account();
		account1.name = "Account 1"; 
		account1.balance = 150;
		account1.Show_Balance();
		
		//Account 2
		Account account2 = new Account();
		account2.name = "Account 2"; 
		account2.balance = 500.53;
		account2.Show_Balance();
		
		System.out.print("\nEnter withdrawal for " +account1.name + ": ");
		account1.withdrawal = scan.nextDouble();
		account1.debit();
		account1.Show_Balance();
		account2.Show_Balance();
		
		System.out.print("\nEnter withdrawal for " +account2.name + ": ");
		account2.withdrawal = scan.nextDouble();
		account2.debit();
		account1.Show_Balance();
		account2.Show_Balance();
	}
}

package car;

public class Car 
{
	public void owner(String n, int cm)
	{
		
		System.out.println("Owner: " + n + "\nYear Model: " + cm);
	}
	int av = 0;

	static int [] upgrades = {21500, 14400, 6250, 3300};
	static String [] uName = {"AC" , "Leather Seats", "Back Wipers", "Fog Lights" };
	static int count = 0;
	
	void upgradeAccesories()
	{
		
		if (this.av > upgrades[count])
		{
			System.out.println("Installed " + uName[count] + ":" + " true");
			av -= upgrades[count];
			count++;
			if (count == 4)
				return;
			upgradeAccesories();
		}
		else
		{
			for (; count < 4; count++)
				System.out.println("Installed " + uName[count] + ":" + " false");
			return;
		}
	}
}

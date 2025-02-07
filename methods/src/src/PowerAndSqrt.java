package labAct2Methods;
import java.text.DecimalFormat;
public class PowerAndSqrt 
{
	public static void main(String [] args)
	{
		DecimalFormat d = new DecimalFormat("#.00");
		double a = 4.0;
		System.out.println("The Power value is "+ d.format(Math.pow(a, 2)));
		System.out.println("The Squareroot value is " + d.format(Math.sqrt(a)));
	}
}

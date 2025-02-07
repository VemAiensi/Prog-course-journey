package labAct2Methods;
import java.text.DecimalFormat;
public class PowerAndSqrt2 
{
	public static void main(String [] args)
	{
		DecimalFormat d = new DecimalFormat("#.00");
		double a = 4.0;
		
		System.out.println("The Power value is " + d.format(calculatePower(a)));
		System.out.println("The Squareroot value is " + d.format(calculateSqrt(a)));
	}
	
	public static double calculatePower(double b)
	{
		return b = Math.pow(b, 2);
	}
	public static double calculateSqrt(double s)
	{
		return s = Math.sqrt(s);
	}
}
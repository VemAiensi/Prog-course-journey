package intermediateProgramming;

public class Test 
{
public static void main(String[] args)
{
	Myclass mc = new Myclass();
	mc.increment();
	Myclass mc1 = new Myclass();
	System.out.println(mc1.count);
}
}

class Myclass
{
	static int count = 101;
	public void increment()
	{
		count++;
	}
}





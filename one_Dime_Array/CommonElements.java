package one_Dime_Array;
//Marasigan, Vem Aiensi A.
//1-BSEMC-.1 - BS Computer Science
import java.util.Scanner;
public class CommonElements 
{
	public static void main(String[] args)
	{
		Scanner store= new Scanner (System.in);
		//size of array input here:
		System.out.print("Enter size of the 1st array: ");
		int s1 = store.nextInt();
		int [] set1 = new int [s1];
		
		System.out.print("Enter size of the 2nd array: ");
		int s2 = store.nextInt();
		int [] set2 = new int [s2];
		
		System.out.print("Enter size of the 3rd array: ");
		int s3 = store.nextInt();
		int [] set3 = new int [s3];
		
		System.out.println(); //space
		
		//input of array elements
		System.out.print("Enter value of the 1st array:\n");
		for (s1 = 0; s1 < set1.length; s1++)
		{
			set1[s1] = store.nextInt(); 
		}
		
		System.out.print("Enter value of the 2nd array:\n");
		for (s2 = 0; s2 < set2.length; s2++)
		{
			set2[s2] = store.nextInt(); 
		}
		
		System.out.print("Enter value of the 3rd array:\n");
		for (s3 = 0; s3 < set3.length; s3++)
		{
			set3[s3] = store.nextInt(); 
		}
		
		System.out.println();//space
		
		//Printing the stored values of the arrays
		System.out.println("Value of arrays:");
		System.out.print("Array 1:  ");
		for (s1 = 0; s1 < set1.length; s1++)
		{
			System.out.print(set1[s1] + "  ");
		}System.out.println();
		
		System.out.print("Array 2:  ");
		for (s2 = 0; s2 < set2.length; s2++)
		{
			System.out.print(set2[s2] + "  ");
		}System.out.println();
		
		System.out.print("Array 3:  ");
		for (s3 = 0; s3 < set3.length; s3++)
		{
			System.out.print(set3[s3] + "  ");
		}System.out.println();
		
		System.out.print("Common elements in sorted arrays: ");
		//Getting the common elements
	// we need something that will sort the common elements
		int se = 0;
		for (s1 = 0; s1 < set1.length; s1++)
		{
			for (s2 = 0; s2 < set2.length; s2++)
			{
				for (s3 = 0; s3 < set3.length; s3++)
				{
					if (set1[s1] == set2[s2])
					{
						int com = set1[s1];
						if (com == set3[s3])
						{
							se++; 
						}
					}
				}
			}
		}
		int [] set_se = new int [se];
		se = 0;
		//store the common values of from the arrays to the new sorting array, the process is just like before
		for (s1 = 0; s1 < set1.length; s1++)
		{
			for (s2 = 0; s2 < set2.length; s2++)
			{
				for (s3 = 0; s3 < set3.length; s3++)
				{
					if (set1[s1] == set2[s2])
					{
						int com = set1[s1];
						if (com == set3[s3])
						{
							set_se[se]=com;
							se++; //updates to store the next upcoming common value in the next element
						}
					}
				}
			}
		}
		for (int se1 = 0; se1 < set_se.length-1; se1++)
		//this will force the loop to loop back when there are still un-arranged  values
		{
			for (se = 0; se < set_se.length-1; se++)//this way the [se+1] won't exceed 2
			{
				if (set_se[se] > set_se[se+1]) //this compares the element and the one next to it
				{
					//if so, its values must swap position
					int reserve = set_se[se]; //the first element's value will be saved here
					set_se[se] = set_se[se+1]; //the first element gets the element next to it 
					set_se[se+1] = reserve; //and this will get the value of the first element before
				}
			}
		}
		for (se = 0; se < set_se.length; se++)
			{
			System.out.print(set_se[se] + " ");
			}
	}
}//Thank you po. I will create po another video for run only

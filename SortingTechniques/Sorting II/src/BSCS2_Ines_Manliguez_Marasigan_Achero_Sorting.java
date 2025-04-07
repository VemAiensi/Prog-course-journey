import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BSCS2_Ines_Manliguez_Marasigan_Achero_Sorting
{
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		Tools.Head();
		System.out.print("   Enter the size of an array:\t");
		int size = in.nextInt();
		int[] A= new int[size], B = new int[size];
						//backup for sorting repetition 
		System.out.print("   Enter " + size + " values: ");
		for (int count = 0; count<size; count++)
		{
			A[count] = in.nextInt();
			B[count] = A[count];
		}
		Tools.Space();
		OptionLoop(A, B);
		in.close();
	}
	
	static void OptionLoop(int[] A, int[] B) 
	{
		Tools.Menu();
		int choice = in.nextInt();
		Tools.Arrow();
		switch (choice)
		{
		case 1: new MergeSort(A); break;
		case 2: new QuickSort(A); break;
		case 3: new HeapHeapHooray(A); break;
		case 4: Tools.End(); break;
		default: OptionLoop(A, B);
		}
		
		A = unsortedRetriever(A, B);
		Tools.Space();
		OptionLoop(A, B);
	}
	static int[] unsortedRetriever(int []sorted, int[]unsorted )
	{
		for (int i = 0; i<sorted.length; i++)
		{
			sorted[i] = unsorted[i];
		}
		return sorted;
	}
}

class MergeSort// Last Edited by Noriel (2022.04.19 - 4:15AM)
{
	static int [] arrA = {3, 1, 5, 4, 2, 12, -1, 10, 7};

	MergeSort(int[] array)
	{
		arrA = array;
		Tools.PrintInFormat1(arrA, "+--[ MERGE SORT ]",2, 40, "+");//5:00pm
		Tools.PrintInFormat3(arrA, 0, "+");
		Tools.Space();
		mergeSort(arrA);
	}
	
	static void mergeSort(int [] A)
	{
		int n = A.length;
		int mid = n/2;
		
		if(n < 2)
		{
			return;
		}
		
		int [] left =  new int [mid];
		int [] right = new int [n-mid];
		
		for(int i = 0; i < mid; i++)
		{
			left[i] = A[i];
		}
		
		for(int i = mid; i < n; i++)
		{
			right[i-mid] = A[i];
		}
		
		if (left.length == 1 && right.length == 1) 
		{
			Tools.PrintInFormat1(left,"Left-----", 1, 20, ".");
			Tools.PrintInFormat3(left, 20, "'");
		}
		else 
		{
			Tools.PrintInFormat1(left,"Left-----", 1, 20, ".");
			Tools.PrintInFormat3(left, 20, "'");
			System.out.println();
		}
		
		mergeSort(left);
		Tools.PrintInFormat1(right,"Right----", 1, 20, ".");
		Tools.PrintInFormat3(right, 20, "'");
		System.out.println();
		
		mergeSort(right);
		merge(left, right, A, mid);
	}
	
	static int ctrl = 0;
	
	static void merge(int [] L, int [] R, int [] A, int m)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < L.length && j < R.length)
		{
			if(L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < L.length)
		{
			A[k] = L[i];
			k++;
			i++;
		}
		while(j < R.length)
		{
			A[k] = R[j];
			k++;
			j++;
		}
		
		if(A.length < m && A.length > 2)
		{
			ctrl = 1;
		}	
		String description = " ";
		int start = 0;
		if(A.length == arrA.length)
		{
			Tools.Space();
			Tools.PrintInFormat1(A,"Final Output-----", 2, 60, "+");
			Tools.PrintInFormat3(A, 20, "+");	
			return;
		}
		
		else if(ctrl == 0)
		{
			description = "Left-----";
			start = 1;
			ctrl = 1;
		}
		
		else if(ctrl == 1)
		{
			description = "Right----";
			start = 1;
			ctrl = 0;
		}
		
		Tools.PrintInFormat1(A, description, start, 20, ".");
		Tools.PrintInFormat3(A, 20, "'");	
	}
}

class QuickSort
{
static int [] array = {5, 6, 7,4 , 3,2 ,1, 10, -3};
	
	QuickSort(int [] A) 
	{
		array = A;
		Tools.PrintInFormat1(array,"+--[ QUICK SORT ]", 2, 40, "+" );
		Tools.PrintInFormat3(array, 0, "+");
		quick(0, array.length-1, array.length, array.length-1);
		
		Tools.PrintInFormat1(array,"+----Sorted Array", 2, 40, "+" );
		Tools.PrintInFormat3(array, 0, "+");
	}
	
	static void quick(int start, int end, int partition, int limit)
	{	
	//	System.out.println("Start: " + start + " End: " + end + " Partition: " + partition);
		if (start<partition && partition != array.length)
		{
			CustomPrint(partition, start, limit, "+----Left","\t+---Right" );
			System.out.println();
			PrintArray(array, start, partition-1, 20);
			System.out.print("\t");
			if(partition != array.length)
			{
				PrintArray(array, partition, limit, 20);	
			}
			System.out.println();
			CustomPrint(partition, start, limit, "+--------","\t+--------" );
			System.out.println();
		}
		else
		{
//			PrintArray(array, start,start, 20);
//			System.out.print("\t\t");
//			PrintArray(array, partition+2, limit+2, 20);
//			System.out.println();
		}
		if (start < end)
		{
			int pivotIndex = pivotAlligner(start, end);
			//System.out.println("Pivot Index: " + pivotIndex);
			quick(start, pivotIndex-1, pivotIndex, end);
			//System.out.println("Pivot Index: " + pivotIndex);
			quick(pivotIndex+1, end, array.length, limit);
		}	
	}

	static int pivotAlligner(int start, int end)
	{
		int pivot = array[start];
		int pivotIndex = start;
		System.out.print("\t\t.--------");
		PrintLine(end-start, 0, 20, ".");
		System.out.println();
		System.out.print("Initial Segment ");
		PrintArray(array, start, end, 20);
		System.out.println();
		int i = start+1, j = end;
		for (; i < j; )
		{
			while (pivot >= array[i] && i < end)
				i++;
			
			while (pivot < array[j])
				j--;
			
			if (i < j)
			{
				int swap = array[j];
				array[j] = array[i];
				array[i] = swap;
			}
		}
		if (array[j] < pivot)
		{
			int swap = array[j];
			array[j] = array[pivotIndex];
			array[pivotIndex] = swap;
		}
		System.out.print("Arranged Segment");
		PrintArray(array, start, end, 20);
		System.out.println();
		System.out.print("\t\t'--------");
		PrintLine(end-start, 0, 20, "'");
		System.out.println();
		return j;
	}
	
	static void PrintArray(int[] array,int start, int end, int speed)
	{
		try
		{
			System.out.print("|\t");
			for (int i = start; i < end+1; i++)
			{
				System.out.print(array[i] + "\t");
				TimeUnit.MILLISECONDS.sleep(speed);
			}
			System.out.print("|");
		}
		catch (Exception e)
		{
			
		}
	}
	static void CustomPrint(int pivotIndex, int start, int end, String word1, String word2)
	{
		System.out.print(word1);
		PrintLine(pivotIndex-start, 1, 10, "+");
//		for (int count = start; count<pivotIndex; count++)
//		{
//			
//			System.out.print("\t");
//		}
		if (pivotIndex != array.length)
		{
			System.out.print(word2);
			PrintLine(end-start, pivotIndex-start, 10, "+");
		}
		
	}
	static void PrintLine(int limit, int start, int speed, String end)
	{
		try{
			for (int i = start-1; i < limit; i++)
			{
				if (i == limit-1)
				{
					for (int count = 0; count<7;count++)
					{
					System.out.print("-");
					TimeUnit.MILLISECONDS.sleep(speed);
					}
					System.out.print(end);
				}
				else
				{
					for (int count = 0; count<8;count++)
					{
					System.out.print("-");
					TimeUnit.MILLISECONDS.sleep(speed);
					}
				}
			}
		}
		catch(Exception e){
			
		}
	}

}
class HeapHeapHooray//Updated by Noriel Achero (2022.04.16 - 1:58AM) revised by Vem (2022.04.16.8:00AM)
{
	static int arr[]= {82, 90, 10, 12, 15, 100};//Just initialization for testing purposes
	static int tempSwapper;
	static int endIndex = 0;// This is to limit the end of the loop (Example: You already placed the largest at the end, the second to the end will now be the end. This is for the largest number index will considered be sorted)
	static int countDown = endIndex;//for tree print limiter only
	HeapHeapHooray(int[] array)
	{
		arr = array;
		endIndex = array.length-1;
		countDown = endIndex;
		Tools.PrintInFormat1(arr, "+--[ HEAP SORT ]-",2, 40, "+");
		Tools.PrintInFormat3(arr, 0, "+");
		Tools.Space();
		System.out.print("\t\t\t\tLoading\n\t|+");
		Tools.PrintLine(6,0, 20, "+");
		System.out.println("|\n\t\t\t\tLEZ GO!!\n");
		heapSort(arr.length);
		Tools.Space();
		Tools.PrintInFormat1(arr, "+--SORTED ARRAY--",2, 40, "+");
		Tools.PrintInFormat3(arr, 0, "+");
	}
	public static void heapSort(int limit)
	{
		if(countDown >= 0)//The loop or putting the largest number to the end will always perform in n of the size of array
		{
			Tree_Print(arr, limit);
			Tools.Space();
			Tools.Space();
			maxHeapHeapHooray();
			Tools.PrintInFormat1(arr, ".--MAXED HEAP----",2, 5, ".");
			Tools.PrintInFormat3(arr, 10, "'");
			Tools.Space();
			
			Tree_Print(arr, limit);
			heapHeapify();
			Tools.Space();
			Tools.Space();
			Tools.PrintInFormat1(arr, ".--HEAPIFIED-----",2, 5, ".");
			Tools.PrintInFormat3(arr, 10, "'");
			System.out.println();
			countDown--;
			limit--;
			heapSort(limit);
		}
		else
			return;
	}
	static void maxHeapHeapHooray()
	{
		int parentIndex;
		int leftChildIndex;
		int rightChildIndex;
		
		for(int i = 0; i <= endIndex; i++)
		{
			parentIndex = i;
			leftChildIndex = (i+1)*2-1;
			rightChildIndex = (i+1)*2;
			
			if(leftChildIndex < endIndex)
			{
				heapChildParentComparison(leftChildIndex, rightChildIndex, parentIndex);
			}
			else if(leftChildIndex == endIndex)
			{
				if (arr[leftChildIndex] > arr[parentIndex])
				{
					tempSwapper = arr[leftChildIndex];
					arr[leftChildIndex] = arr[parentIndex];
					arr[parentIndex] = tempSwapper;
				}
			}
		}	
	}	
	static void heapChildParentComparison(int leftChildIndex, int rightChildIndex, int parentIndex)//Can also perform swapping
	{
		int swappedChildIndex = 0;
		if (arr[leftChildIndex] >= arr[rightChildIndex])
		{
			tempSwapper = arr[leftChildIndex];
			swappedChildIndex = leftChildIndex;
		}
		else
		{
			tempSwapper = arr[rightChildIndex];
			swappedChildIndex = rightChildIndex;
		}
		if(tempSwapper > arr[parentIndex])
		{
			arr[swappedChildIndex] = arr[parentIndex];
			arr[parentIndex] = tempSwapper;
		}			
	}
	static void heapHeapify()
	{
		tempSwapper = arr[0];
		arr[0] = arr[endIndex];
		arr[endIndex] = tempSwapper;
		endIndex--;// decrement the index of the end after the swap of the index 0 to the endIndex.
	}
	
	/*Custom design that enables Tree Printing:by Vem
	 * I am humbly apologizing for the long code as the tree printing
	 *  uses a lot of lines including its connecting lines as it requires
	 *  many conditional statements and formulas so that the tree print
	 *  could be achieved -_-!
	*/
	static void Tree_Print(int[] Array, int limit) 
	{
		int[] IS = new int[2]; //Indent and Space
		
		int level = LevelFinder(Array.length, 1, 2, 1);
		IS =  ISProvider(IS, level, 0, 2);
		tree(Array, 0, 1, 2, IS[0], IS[1], limit, 1);
	}
	static void tree(int[]a, int start, int end, int add, int indent, int space, int limit, int s)
	{//                     print the elements of the array       formatting
		System.out.print("\t");
		if (limit<=end)
		{
			for (int count = 0; count<indent; count++)
			{
				System.out.print("\t");
			}
			for (; start<limit; start++)
			{
				System.out.print(a[start]);
				for (int count = 0; count<space; count++)
				{
					System.out.print("\t");
				}
			}
			return;
		}
		else
		{
			for (int count = 0; count<indent; count++)
			{
				System.out.print("\t");
			}
			for (; start<end; start++)
			{
				System.out.print(a[start]);
				for (int count = 0; count<space; count++)
				{
					System.out.print("\t");
				}
			}
		}
		int siblings = s;
		boolean noRightChild = false;
		int remainingChild = limit - start;
		indent = indent - space/4;
		space = space/2;
		System.out.println();
		
		int newEnd = end+add;
		add *= 2;
		
		if (limit<newEnd)
		{
			siblings = remainingChild;
			if (remainingChild > 1)
			{
				siblings = (remainingChild+1)/2;
			}
			if ((limit-1)%2 == 1)
			{
				noRightChild = true;
			}
		}
		
		Connection(indent, 3, space, 1, space, noRightChild, siblings, limit);	
		siblings = siblings + siblings;
		tree(a, end, newEnd, add, indent, space, limit, siblings);
		
	}
	static int LevelFinder(int size, int end, int add, int level)
	{
		if (size>end)
		{
			level++;
			int newEnd = end+add;
			add *= 2;
			level = LevelFinder(size, newEnd, add, level);	
		}
		return level;
	}
	static int[] ISProvider(int[] IS, int level, int indent, int space)
	{
		if(level>1)
		{
			level--;
			indent = indent+space/2;
			space = space*2;
			IS[0] = indent;
			IS[1] = space;
			ISProvider(IS, level, indent, space);
		}
		return IS;
	}
	static void Connection(int indent, int layer, int space, int adder, int balance, boolean noRightChild, int siblings, int limit)
	{
		System.out.print("\t");
	
		for(int tabs = indent; tabs>0; tabs--)
		{
			System.out.print("\t");
		}
		
		for (int repeat = 0; repeat < siblings; repeat++)
		{
			for (int left = layer*space; left>0; left--)
			{
				System.out.print(" ");
			}
			System.out.print("-");
			for(int count = balance-1; count > 0; count--)
			{
				System.out.print(" ");
			}
			//System.out.println("repeat: " + repeat);
			if (repeat == siblings-1 && noRightChild)
			{
				for (int right = 0; right<space+adder; right++)
				{
					System.out.print(" ");
				}
				System.out.print(" ");
				
				for (int left = layer*space-2; left>0; left--)
				{
					System.out.print(" ");
				}
				for (int tabs = space; tabs>0; tabs--)
				{
					System.out.print("\t");
				}
			}
			else
			{
				for (int right = 0; right<space+adder; right++)
				{
					System.out.print(" ");
				}
				System.out.print("-");
				
				for (int left = layer*space-2; left>0; left--)
				{
					System.out.print(" ");
				}
				for (int tabs = space; tabs>0; tabs--)
				{
					System.out.print("\t");
				}
			}	
		}
		
		balance = balance+space;
		adder = adder + space;
		System.out.println();
		try 
		{
			TimeUnit.MILLISECONDS.sleep(200);
		}
		catch (Exception e)
		{
			
		}
		if (layer == 1)
		{
			return;
		}
		layer--;
		Connection(indent, layer, space, adder,  balance, noRightChild, siblings, limit);
	}
}

class Tools//Improved version -by Vem
{//sorting tools

	//Designing Tools
		static void PrintInFormat1(int[] array, String name, int start, int speed, String end)
		{
			System.out.print("\t" +name);
			Tools.PrintLine(array.length, start, speed, end);
			Tools.Space();
			System.out.print("\t|");
			Tools.PrintArray(array, speed*5);
			System.out.print("|");
			Tools.Space();
		}

		static void PrintInFormat3(int[] array, int speed, String end)
		{
			System.out.print("\t" + end);
			Tools.PrintLine(array.length, 0, speed, end);
			Tools.Space();
		}
		static void PrintArray(int[] array, int speed)
		{
			try
			{
				System.out.print("\t");
				for (int i = 0; i < array.length; i++)
				{
					System.out.print(array[i] + "\t");
					TimeUnit.MILLISECONDS.sleep(speed);
				}
			}
			catch (Exception e)
			{
				
			}
		}
		static void Space()
		{
			System.out.println();
		}
		static void Arrow()
		{
			String a = "'-------.";
			try {
				System.out.print("\t\t\t   |\n");
				TimeUnit.MILLISECONDS.sleep(20);
				System.out.print("\t.------------------'\n");
				TimeUnit.MILLISECONDS.sleep(20);
				System.out.print("\t|\n\t");
				for (int count = 0, speed = 20; count< a.length(); count++)
				{
					System.out.print(a.charAt(count));
					TimeUnit.MILLISECONDS.sleep(speed);
					speed += 25;
				}
				System.out.print("\n\t\t|\n\t\tV");
			}
			catch(Exception e)
			{
				
			}
			
			System.out.println();
		}
		static void PrintLine(int limit, int start, int speed, String end)
		{
			try{
				for (int i = start-1; i < limit; i++)
				{
					if (i == limit-1)
					{
						for (int count = 0; count<7;count++)
						{
						System.out.print("-");
						TimeUnit.MILLISECONDS.sleep(speed);
						}
						System.out.print(end);
					}
					else
					{
						for (int count = 0; count<8;count++)
						{
						System.out.print("-");
						TimeUnit.MILLISECONDS.sleep(speed);
						}
					}
				}
			}
			catch(Exception e){
				
			}
		}
		static void Head()
		{//https://patorjk.com/software/taag/
			String sorting = "              ___          ___          ___      ___                   ___          ___     \r\n"
					+ "             /\\  \\        /\\  \\        /\\  \\    /\\  \\        ___      /\\__\\        /\\  \\  \r\n"
					+ "            /::\\  \\      /::\\  \\      /::\\  \\   \\:\\  \\      /\\  \\    /::|  |      /::\\  \\    \r\n"
					+ "           /:/\\ \\  \\    /:/\\:\\  \\    /:/\\:\\  \\   \\:\\  \\     \\:\\  \\  /:|:|  |     /:/\\:\\  \\  \r\n"
					+ "          _\\:\\ \\ \\  \\  /:/  \\:\\  \\  /::\\ \\:\\  \\  /::\\  \\    /::\\__\\/:/|:|  |__  /:/  \\:\\  \\ \r\n"
					+ "         /\\ \\:\\ \\ \\__\\/:/__/ \\:\\__\\/:/\\:\\ \\:\\__\\/:/\\:\\__\\__/:/\\/__/:/ |:| /\\__\\/:/__/_\\:\\__\\ \r\n"
					+ "         \\:\\ \\:\\ \\/__/\\:\\  \\ /:/  /\\/_|::\\/:/  /:/  \\/__/\\/:/  /  \\/__|:|/:/  /\\:\\  /\\ \\/__/ \r\n"
					+ "          \\:\\ \\:\\__\\   \\:\\  /:/  /    |:|::/  /:/  /    \\::/__/       |:/:/  /  \\:\\ \\:\\__\\ \r\n"
					+ "           \\:\\/:/  /    \\:\\/:/  /     |:|\\/__/\\/__/      \\:\\__\\       |::/  /    \\:\\/:/  /  \r\n"
					+ "            \\::/  /      \\::/  /      |:|  |              \\/__/       /:/  /      \\::/  /   \r\n"
					+ "             \\/__/        \\/__/        \\|__|                          \\/__/        \\/__/   ";
			try {
				for (int i = 0; i < sorting.length(); i++)
				{
					System.out.print(sorting.charAt(i));
					TimeUnit.MILLISECONDS.sleep(1);
				}
			}
			catch (Exception e){
			}
			Tools.Space();
			System.out.print("  +");
			Tools.PrintLine(11, 0, 25, "+");
			Tools.Space();
		}
		static void Menu()
		{
			System.out.print("\tMenu\n\t\t1. Merge\n"
					+ "\t\t2. Quick\n\t\t3. Heap\n"
					+ "\t\t4. Exit\n\tEnter Option[1..4] ");
		}
		static void End()
		{
			System.out.println(" ______ __  __  ___  __  __ __ __    _  _   ___   __ __   ");
			System.out.println(" | || | ||  || // \\\\ ||\\ || || //    \\\\//  // \\\\  || ||   ");
			System.out.println("   ||   ||==|| ||=|| ||\\\\|| ||<<      )/  ((   )) || ||   ");
			System.out.println("   ||   ||  || || || || \\|| || \\\\    //    \\\\_//  \\\\_//   ");
			System.out.println("                                                          ");
			
			System.out.println("\t   EXEMPTED NA PO KAMI SA PROJECT/EXAM!");
			System.out.println();
			System.out.println();
			
			System.out.println("\t                  .odbo.");
			System.out.println("\t              .od88888888bo.");
			System.out.println("\t          .od8888888888888888bo.");
			System.out.println("\t      .od888888888888888888888888bo.");
			System.out.println("\t   od88888888888888888888888888888888bo");
			System.out.println("\t    `~888888888888888888888888888888~'");
			System.out.println("\t       `~888888888888888888888888~'|");
			System.out.println("\t          `~888888888888888888~'   |");
			System.out.println("\t            |`~888888888888~'|     |");
			System.out.println("\t            \\   `~888888~'   /     A");
			System.out.println("\t             `-_   `~~'   _-'      H");
			System.out.println("\t                `--____--'");
			
			
			
			System.out.println("\n\t\t   Sorting developed by:");
			System.out.println("\n\t\t  Ines, Samantha Pauline");
			System.out.println("\t\t  Manliguez, Angelica Mae");
			System.out.println("\t\t   Marasigan, Vem Aiensi");
			System.out.println("\t\t      Achero, Noriel");
			
			Tools.PrintLine(6, 0, 50, "+");
			System.out.println("\n\t  Special Thanks also to: patorjk.com for the ASCII art"
					+ "\n\t\t   https://patorjk.com/software/taag/");
			System.exit(0);
		}
}

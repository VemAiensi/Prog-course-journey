import java.util.*;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class BSCS2_Marasigan_Achero_Manliguez_Array 
{
	public static void main(String [] args)
	{
		Scanner scan =  new Scanner(System.in);
		
		int option;
		
		System.out.println("   ___   ___  ___  _____  __");
		System.out.println("  / _ | / _ \\/ _ \\/ _ \\ \\/ /");
		System.out.println(" / __ |/ , _/ , _/ __ |\\  / ");
		System.out.println("/_/ |_/_/|_/_/|_/_/ |_|/_/  ");
		
		System.out.println("\nPrepared by:\nMarasigan;\nAchero;\nManliguez;");


		System.out.println("\n\nOPTIONS:");
		System.out.println("1 - Sum of Numbers in Array");
		System.out.println("2 - Maximum and Minimum in Array");
		System.out.println("3 - Student Grade Book");
		System.out.println("4 - Delete duplicate values in array");
		
		System.out.print("\nEnter option number [1-4] ");
		option = scan.nextInt();
		
		switch(option)
		{
			case 1:
				option1();
				break;
			case 2:
				option2();
				break;
			case 3:
				option3();
				break;
			case 4:
				option4();
				break;
			default:
				System.out.println("\nYou've input a number that is not in the options!");
				System.out.println("\nPrepared by 1BSCS2\nMarasigan, Vem Aeinsi; \nAchero, Noriel; \nManliguez, Angelica Mae;");
				break;
		}
		
	}
	
	static void option1()
	{
		System.out.println();
		
		Scanner scan1 =  new Scanner(System.in);
		int[] arr;
		int arrSize;
		int sum = 0;
		
		System.out.print("\nInput array size: ");
		arrSize = scan1.nextInt();
		
		arr = new int [arrSize];
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print("Enter Number " + (i+1) + ": ");
			arr[i] = scan1.nextInt();
			sum = sum + arr[i];
		}
		
		System.out.println("\nThe Sum of " + arrSize + " values is " + sum);
	
		
	}
	
	static void option2()
	{
		System.out.println();
		
		Scanner scan2 =  new Scanner(System.in);
		int[] arr;
		int arrSize;
		int max;
		int min;
		
		System.out.print("\nInput array size: ");
		arrSize = scan2.nextInt();
		
		arr = new int [arrSize];
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print("Enter Number " + (i+1) + ": ");
			arr[i] = scan2.nextInt();
		}
		
		for(int j=0, ctrl = 0; j < arr.length; j++)
		{
			
			for(int i=0; i < arr.length; i++)
			{
				if(arr[j] == arr[i])
				{
					//Do Nothing 
				}
				else if(arr[j] > arr[i])
				{
					ctrl++;
				}
				else if (arr[j] < arr[i])
				{
					//Do Nothing
				}
			}
					
			if(ctrl != arr.length - 1)
			{
				ctrl = 0;
			}
			else
			{
				max = arr[j];
				System.out.println("\nMaximum Value = " + max);
				break;
			}
		}
		
		
		for(int j=0, ctrl = 0; j < arr.length; j++)
		{
			
			for(int i=0; i < arr.length; i++)
			{
				if(arr[j] == arr[i])
				{
					
				}
				else if(arr[j] < arr[i])
				{
					ctrl++;
				}
				else if (arr[j] > arr[i])
				{

				}
			}
						
			if(ctrl != arr.length - 1)
			{
				ctrl = 0;
			}
			else
			{
				min = arr[j];
				System.out.println("Minimum Value = " + min);
				break;
			}
		}
		
		
	}
	static void option3()
	{
		System.out.println();
		
		Scanner scan3 =  new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###,###.00");
		
		double [][] arr;
		int studentNum;
		int quizNum;
		double sum = 0;
		double average;
		int passedNum = 0;
		int failedNum = 0;
		int gradeBookOption;
		
		
		System.out.println("Select Grade Book Options:");
		System.out.println("1 - Create a new Grade Book");
		System.out.println("2 - Open an existing Grade Book");
		System.out.println("3 - Edit an existing Grade Book");
		
		System.out.print("\n\nEnter Grade Book option: [1-3] ");
		gradeBookOption = scan3.nextInt();
		
		
		switch(gradeBookOption)
		{
			case 1:
				Scanner gradeBookScanner1 =  new Scanner(System.in);
				String Name=  "";
				
				System.out.print("\nInput Name of File (Files are automatically saved in workspace folder): ");
				Name = gradeBookScanner1.nextLine();
				try 
				{
					File myObj = new File(Name);
					if(myObj.createNewFile())
					{
						System.out.println("\nGrade Book created: " + myObj.getName());
						
						System.out.print("\nEnter Number of Students: ");
						studentNum = scan3.nextInt();
						
						System.out.print("Enter Number of Quizzes: ");
						quizNum = scan3.nextInt();
						
						arr = new double [studentNum][quizNum];
						
						for(int row = 0; row < studentNum; row++)
						{
							System.out.print("\nStudent #" + (row+1));
							System.out.println();
							for(int col = 0; col < quizNum; col++)
							{
								System.out.print("Enter Grade of Quiz " + (col+1) + ": ");
								arr[row][col] = scan3.nextDouble();
							}
						}
						FileWriter myWriter = new FileWriter(Name);
						System.out.println();
						System.out.println(Name);
						myWriter.write(Name + "\n");
						System.out.print("\t\t\t");
						myWriter.write("\t\t\t");
						
						for(int i = 0; i < quizNum; i++)
						{
							System.out.print("Quiz " + (1 + i) + "\t\t");
							myWriter.write("Quiz " + (1 + i) + "\t\t");
						}
						
						System.out.print("Average\t\tRemarks");
						myWriter.write("Average\t\tRemarks");
						
						for(int row = 0; row < studentNum; row++, average = 0, sum = 0)
						{
							System.out.print("\nStudent #" + (row+1) + "\t\t");
							myWriter.write("\nStudent #" + (row+1) + "\t\t");

							for(int col = 0; col < quizNum; col++)
							{
								System.out.print(df.format(arr[row][col]) + "\t\t");
								myWriter.write(df.format(arr[row][col]) + "\t\t");
								sum = arr[row][col] + sum;
							}
							
							average = sum/quizNum;
							
							System.out.print(df.format(average) + "\t\t");
							myWriter.write(df.format(average) + "\t\t");
							
							if(average >= 75.00)
							{
								System.out.print("Passed");
								myWriter.write("Passed");
								passedNum++;
								
							}
							
							else if(average < 75.00)
							{
								System.out.print("Failed");
								myWriter.write("Failed");
								failedNum++;
							}
						}
						
						System.out.println("\n\nNumber of Students passed: " + passedNum);
						myWriter.write("\n\nNumber of Students passed: " + passedNum + "\n");
						System.out.println("Number of Students failed: " + failedNum);
						myWriter.write("Number of Students failed: " + failedNum);
						
						
						myWriter.close();
						
					}
					else
					{
						System.out.println("File already exists, please restart and choose other filename");
						break;
					}
				}
				catch (IOException e)
				{
					System.out.println("An error occurred, please restart and choose other filename.");
					e.printStackTrace();
					break;
				}
				

				
				break;
				
				
			case 2:
				Scanner gradeBookScanner2 =  new Scanner(System.in);
				String readFileName=  "";
				
				System.out.print("\nInput Name of File to Open: ");
				readFileName = gradeBookScanner2.nextLine();
				
				try
				{
					File myObj = new File (readFileName);
					Scanner myReader = new Scanner (myObj);
					System.out.println();
					while (myReader.hasNextLine())
					{
						String data = myReader.nextLine();
						System.out.println(data);
					}
					myReader.close();
				}
				catch (FileNotFoundException e)
				{
					System.out.println("An error occured");
					e.printStackTrace();
				}
				
				break;
			case 3:
				Scanner gradeBookScanner3 =  new Scanner(System.in);
				String editFileName=  "";
				
				System.out.print("\nInput Name of file to edit: ");
				editFileName = gradeBookScanner3.nextLine();
				try
				{
					System.out.println("\nNow editing " + editFileName);
					
					System.out.print("\nEnter Number of Students: ");
					studentNum = scan3.nextInt();
					
					System.out.print("Enter Number of Quizzes: ");
					quizNum = scan3.nextInt();
					
					arr = new double [studentNum][quizNum];
					
					for(int row = 0; row < studentNum; row++)
					{
						System.out.print("\nStudent #" + (row+1));
						System.out.println();
						for(int col = 0; col < quizNum; col++)
						{
							System.out.print("Enter Grade of Quiz " + (col+1) + ": ");
							arr[row][col] = scan3.nextDouble();
						}
					}
					FileWriter myWriter = new FileWriter(editFileName);
					System.out.println();
					System.out.println(editFileName);
					myWriter.write(editFileName + "\n");
					System.out.print("\t\t\t");
					myWriter.write("\t\t\t");
					
					for(int i = 0; i < quizNum; i++)
					{
						System.out.print("Quiz " + (1 + i) + "\t\t");
						myWriter.write("Quiz " + (1 + i) + "\t\t");
					}
					
					System.out.print("Average\t\tRemarks");
					myWriter.write("Average\t\tRemarks");
					
					for(int row = 0; row < studentNum; row++, average = 0, sum = 0)
					{
						System.out.print("\nStudent #" + (row+1) + "\t\t");
						myWriter.write("\nStudent #" + (row+1) + "\t\t");

						for(int col = 0; col < quizNum; col++)
						{
							System.out.print(df.format(arr[row][col]) + "\t\t");
							myWriter.write(df.format(arr[row][col]) + "\t\t");
							sum = arr[row][col] + sum;
						}
						
						average = sum/quizNum;
						
						System.out.print(df.format(average) + "\t\t");
						myWriter.write(df.format(average) + "\t\t");
						
						if(average >= 75.00)
						{
							System.out.print("Passed");
							myWriter.write("Passed");
							passedNum++;
							
						}
						
						else if(average < 75.00)
						{
							System.out.print("Failed");
							myWriter.write("Failed");
							failedNum++;
						}
					}
					
					System.out.println("\n\nNumber of Students passed: " + passedNum);
					myWriter.write("\n\nNumber of Students passed: " + passedNum + "\n");
					System.out.println("Number of Students failed: " + failedNum);
					myWriter.write("Number of Students failed: " + failedNum);
					
					myWriter.close();
				}
				catch (IOException e)
				{
					System.out.println("An error occured");
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("You've Entered a Number that is not in the options!");
				break;
		}
	}

	
	static void option4()
	{
		System.out.println();
		
		Scanner scan4 =  new Scanner(System.in);
		int[] arr;
		int arrSize;
		
		System.out.print("\nInput array size: ");
		arrSize = scan4.nextInt();
		
		arr = new int [arrSize];
		
		System.out.println("\nInput " + arrSize + " value:");
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print("Enter Number " + (i+1) + ": ");
			arr[i] = scan4.nextInt();
		}
		
		
		for(int j = 0; j < arr.length; j++)
		{
				for(int i = 0; i < arr.length; i++)
				{
					if(i == j)
					{
						//do nothing
					}
					else if(arr[j] == arr[i])
					{
						arr[i] = -100000;

					}
					else if(arr[j] != arr[i])
					{
						//do nothing
					}
					
				}

		}	
		
		System.out.print("\nDistinct Values of Array: ");
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] != -100000)
			{
			System.out.print(arr[i] + " ");
			}
			else if(arr[i] == -100000)
			{
				//skip
			}
		}
	}
	
}
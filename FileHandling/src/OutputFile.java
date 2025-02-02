//Marasigan, Vem Aiensi A. | 1-BSCS-.2
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OutputFile 
{
	static Scanner scan = new Scanner(System.in);
	static int choice = 0;
	public static void main(String[] args)
	{
		optionLoop();
		Tools.end();
	}
	
	static void optionLoop()
	{
		System.out.print("[1] Write data to file [2] Show File in console\n"
					   + "[3] Analyze file       [4] Exit\n"
					   + "Please choose operation: ");
		choice = scan.nextInt();
		System.out.println();
		
		switch(choice)
		{
		case 1: new Append(); break;
		case 2: new ScanData(); break;
		case 3: new Analyze(); break;
		case 4: return;
		}
		optionLoop();
	}
}

class Analyze
{
	Analyze()
	{
		openFile();
		analyzeFile();
		close();
	}
	static Scanner scanner1;
	static PrintWriter writer;
	static File file;
	static String[] words;
	static String scannedText, statement;
	
	static void openFile()
	{
		try 
		{
			file = new File ("../intermediateProgramming/fileHandling/SampleText.txt");
			scanner1 = new Scanner(new FileReader("../intermediateProgramming/fileHandling/SampleText.txt"));
			writer = new PrintWriter("../intermediateProgramming/fileHandling/SampleOutputText.txt");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File creation failed");
		}
	}
	
	static void analyzeFile()
	{
		scannedText = ""; //resets the data for a new fresh scan
		
		while(scanner1.hasNextLine())
		{
			scannedText += scanner1.nextLine();
			scannedText += " "; //essential for word separations
		}
		words = scannedText.split(" ");
		
		writer.println("File length: " + file.length());
		writer.println("File path: " + file.getPath());
		writer.println("Number of words: " + words.length);
		
		Tools.printInStyle("Analyzation of file is stored to SampleOutputText.txt. \n\n");
	}
	
	static void close()
	{
		writer.close();
		scanner1.close();
	}
}

class Append
{
	static Scanner scan = new Scanner(System.in);
	static PrintWriter writer;

	Append()
	{
		openFile();
		writeData();
		closeFile();
	}
	
	static void openFile()
	{
		try 
		{
			writer = new PrintWriter(new BufferedWriter(new FileWriter("../intermediateProgramming/fileHandling/SampleText.txt", true)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	static void writeData()
	{
		Tools.printInStyle("Please type the statement you want to save:\n");
		String statement = scan.nextLine();
		writer.println(statement);
		Tools.printInStyle("Statement saved.\n\n");
	}
	
	static void closeFile()
	{
		writer.close();
	}
}

class ScanData 
{
	static Scanner scan;
	static Scanner scanInConsole = new Scanner(System.in);
	
	ScanData()
	{
		Tools.printInStyle("Enter file name: ");
		openFileScanner(scanInConsole.nextLine());
		scanFile();
		close();
	}
	
	static void openFileScanner(String fileName)
	{
		try 
		{
			scan = new Scanner(new FileReader("../intermediateProgramming/fileHandling/"  + fileName));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File is not found");
		}
	}
	
	static void scanFile()
	{
		while(scan.hasNextLine())
		{
			Tools.printInStyle(scan.nextLine());
			System.out.println();
		}
		System.out.println();
	}
	
	static void close()
	{
		scan.close();
	}
}

class Tools
{
	static void printInStyle(String s)
	{
		try
		{
			for (int count = 0; count<s.length(); count++)
			{
				System.out.print(s.charAt(count));
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	static void end()
	{
		printInStyle("Thank you for checking the program\n"
				+ " -Vem Aiensi Marasigan, 1-BSCS-.2");
	}
}
package ticTacToe;
import java.util.*;
public class BSCS2_Marasigan_Achero_Manliguez 
{
	public static void main(String [] args)
	{
		//This program is better looking at consolas font
		asciiArt("TICTACTOE");
		
		//program variables
		int gameMode = 0;		int restart = 0;							
		Scanner in = new Scanner(System.in);
		do
		{
		//choose game modes
		System.out.print("\nChoose Mode: [1] Vs. MAM [2] 2-Player:  ");
		gameMode = in.nextInt();
		System.out.println();
		switch (gameMode)
		{
			case 1: vsMAM(in);break;
			case 2: twoPlayer(in); break;
		}
		System.out.print("Do you want to play again? [1]Yes [2]No: ");
		restart = in.nextInt();
		}while (restart == 1);
		asciiArt("Credits");
		in.close();
	}
	
	//VS AI
	static void vsMAM(Scanner in)
	{
		int [] coordinate = {0,0};
		String board[][] = {{" " ," " ," "},{" " ," " ," "},{" " ," " ," "}};
		List<Integer> rec1 = new ArrayList<Integer>();
		List<Integer> rec2 = new ArrayList<Integer>();
		boolean winner = false;
		int n =0;
		int choice2=0;
		int choiceI = 0;
		System.out.print("Please choose your preferred controls\n+-+-+-+\t\t+-+-+-+\n"+ "|Q|W|E|\t\t|7|8|9|\n+-+-+-+\t\t+-+-+-+\n"+ "|A|S|D|\t\t|4|5|6|\n+-+-+-+\t\t+-+-+-+\n"+ "|Z|X|C|\t\t|1|2|3|\n+-+-+-+\t\t+-+-+-+\n"+ "CONTROLLER 1\tCONTROLLER 2\n"+ "[1 or 2]: ");
		int controller = in.nextInt();
		System.out.print("Please choose difficulty: [1]Easy [2]Undefeatable: ");
		int difficulty = in.nextInt();
		System.out.println();
		
			do
			{	//player
				do {
					choiceI = choiceProcessor(in, controller, rec1);
					if (rec2.contains(choiceI))
					{
						System.out.println("Invalid turn, please enter another position.");
					}
					}while (rec2.contains(choiceI));
				
				coordinate = positionPicker(choiceI);
				rec1.add(choiceI);
				board[coordinate[0]][coordinate[1]] = "0";
				boardPrinter(board);
				winner = winnerChecker(rec1);
				if (winner == false) 
				{
					asciiArt("U win");
				
				}
				else if (winner == true)
				{
				//MAM
				switch (difficulty)
				{
				case 1: choice2 = marAchMan(rec1,rec2,choice2); break;
				case 2: choice2 = marAchManV2(rec1,rec2,choice2); break;
				}
				if (choice2 < 10) 
				{
				rec2.add(choice2);
				coordinate = positionPicker(choice2);
				board[coordinate[0]][coordinate[1]] = "X";
				System.out.println("\n\tMAM's Turn");
				boardPrinter(board);
				}
				winner = winnerChecker(rec2);
				
					if (winner == false)
					{
						asciiArt("AI");
					}
					
				}n++;
			}while (winner && n<5);
			if (n == 5)
			{
				asciiArt("Tie");
			}
			
	}
	//2-Player 
	static void twoPlayer(Scanner in)
	{
		int [] coordinate = {0,0}; int n = 0;
		String board[][] = {{" " ," " ," "},{" " ," " ," "},{" " ," " ," "}};
		List<Integer> rec1 = new ArrayList<Integer>();
		List<Integer> rec2 = new ArrayList<Integer>();
		boolean repeat = false;		
		int choice1 = 0; char choiceC = ' '; int choice2 = 0; int choiceI = 0;
		System.out.print("\tCONTROLS\n+-+-+-+\t\t+-+-+-+\n"+ "|Q|W|E|\t\t|7|8|9|\n+-+-+-+\t\t+-+-+-+\n"+ "|A|S|D|\t\t|4|5|6|\n+-+-+-+\t\t+-+-+-+\n"+ "|Z|X|C|\t\t|1|2|3|\n+-+-+-+\t\t+-+-+-+\n"+ "PLAYER 1\tPLAYER 2\n");
		System.out.println();
		do 
		{//player 1
			do {
				do {
					do {
						System.out.print("P1:What letter do you want to mark:");
						String decide = in.next().toUpperCase();
						choiceC = decide.charAt(0);
						if ((choiceC != 'Q') && (choiceC != 'W') && (choiceC != 'E')
								&& (choiceC != 'A')&&(choiceC != 'S')&& (choiceC != 'D')
								&& (choiceC != 'Z')&&(choiceC != 'X')&&(choiceC != 'C'))
						{
							System.out.println("Turn is not valid, please enter another position.");
						}
					}while((choiceC != 'Q') && (choiceC != 'W') && (choiceC != 'E')
						&& (choiceC != 'A')&&(choiceC != 'S')&& (choiceC != 'D')
						&& (choiceC != 'Z')&&(choiceC != 'X')&&(choiceC != 'C'));//verifies if P1 don't input unnecessary characters
					
					choice1 = charToInt(choiceC);
					if (rec1.contains(choice1))
					{
						System.out.println("Turn is not valid, please enter another position.");
					}
				}while (rec1.contains(choice1));//verify that P1 does not repeat his turn, if so, loop back
				if (rec2.contains(choice1))
				{
					System.out.println("Turn is not valid, please enter another position.");
				}
			}while (rec2.contains(choice1));//verifying that P2 didn't turn on that particular position, if so, loop back
				
		rec1.add(choice1);
		coordinate = positionPicker(choice1);
		board[coordinate[0]][coordinate[1]] = "0";
		boardPrinter(board);
		repeat = winnerChecker(rec1);
		n++;
			if (repeat == false) 
			{
			asciiArt("P1");
			}
			else if ((repeat == true)&& n<5)
			{	
			//player 2
				do {
					do {	
						do {
							System.out.print("P2:What number do you want to mark:");
							choiceI = in.nextInt();
							if (choiceI > 9 || choiceI <0)
							{
								System.out.println("Turn is not valid, please enter another position.");
							}
							
						}while (choiceI > 9 || choiceI <0);
					choice2 = intToInt(choiceI);
					if (rec2.contains(choice2))
					{
						System.out.println("Turn is not valid, please enter another position.");
					}
					}while (rec2.contains(choice1));//verify that P2 does not repeat his turn, if so, loop back
					if (rec1.contains(choice2))
					{
						System.out.println("Turn is not valid, please enter another position.");
					}
				}while (rec1.contains(choice2));//verifying that P1 didn't turn on that particular position, if so, loop back
				rec2.add(choice2);
				coordinate = positionPicker(choice2);
				board[coordinate[0]][coordinate[1]] = "X";
				boardPrinter(board);
				repeat = winnerChecker(rec2);
				
				if (repeat == false)
				{
				asciiArt("P2");
				}
			}
			
		}while (repeat && n<5);
		if (n == 5)
		{
			asciiArt("Tie");
		}
		
	}
	
									//Tools here
	//choiceProcessor
	static int choiceProcessor(Scanner in, int controller, List<Integer>test)
		{
		int choice = 0;
			char choiceC = ' ';
			int choiceI = 0;
			switch (controller)
			{
			case 1:
				do 
				{
					do
					{
					System.out.print("What letter do you want to mark:");
					String decide = in.next().toUpperCase();
					choiceC = decide.charAt(0);
						if ((choiceC != 'Q') && (choiceC != 'W') && (choiceC != 'E')
							&& (choiceC != 'A')&&(choiceC != 'S')&& (choiceC != 'D')
							&& (choiceC != 'Z')&&(choiceC != 'X')&&(choiceC != 'C'))
						{
							System.out.println("Turn is not valid, please enter another position.");
						}
						
					} while ((choiceC != 'Q') && (choiceC != 'W') && (choiceC != 'E')
								&& (choiceC != 'A')&&(choiceC != 'S')&& (choiceC != 'D')
								&& (choiceC != 'Z')&&(choiceC != 'X')&&(choiceC != 'C'));
								choiceI = charToInt(choiceC);
					if (test.contains(choiceI))
					{
						System.out.println("Turn is not valid, please enter another position.");
					}
				}while (test.contains(choiceI));
				
			
			break;
			
			case 2: 
				do {
					do{
						System.out.print("What number do you want to mark:");
						choice = in.nextInt();
					} while (choice > 9 || choice <0);
					choiceI = intToInt(choice);
				}while (test.contains(choiceI));
				break;
			}
			return choiceI;
			
		}	
	//choice converters
	//letter (QWE) converter to integer
	static int charToInt( char choice) 
	{
		int equivalent = 0;
		switch (choice)
		{
		case 'Q': 	equivalent = 1; 	break;
		case 'W': 	equivalent = 2; 	break;
		case 'E': 	equivalent = 3; 	break;
		case 'A': 	equivalent = 4; 	break;
		case 'S': 	equivalent = 5; 	break;
		case 'D': 	equivalent = 6;		break;
		case 'Z': 	equivalent = 7;		break;
		case 'X': 	equivalent = 8;		break;
		case 'C':	equivalent = 9; 	break;
		}
		return equivalent;
	}
	//number pad converter to integer
	static int intToInt( int choice) 
		{
			int equivalent = 0;
			switch (choice)
			{
			case 7: 	equivalent = 1; 	break;
			case 8: 	equivalent = 2; 	break;
			case 9: 	equivalent = 3; 	break;
			case 4: 	equivalent = 4; 	break;
			case 5: 	equivalent = 5; 	break;
			case 6: 	equivalent = 6;		break;
			case 1: 	equivalent = 7;		break;
			case 2: 	equivalent = 8;		break;
			case 3:	equivalent = 9; 	break;
			}
			return equivalent;
		}
	//coordinate provider
	static int[] controlNumbers( int choice)
	{
		int[] coordinates = new int[2];
		switch (choice)
		{
		case 1: coordinates[0] = 0; coordinates[1]=0; break;
		case 2: coordinates[0] = 0; coordinates[1]=1;break;
		case 3: coordinates[0] = 0; coordinates[1]=2;break;
		case 4: coordinates[0] = 1; coordinates[1]=0;break;
		case 5: coordinates[0] = 1; coordinates[1]=1;break;
		case 6: coordinates[0] = 1; coordinates[1]=2;break;
		case 7: coordinates[0] = 2; coordinates[1]=0;break;
		case 8: coordinates[0] = 2; coordinates[1]=1;break;
		case 9:coordinates[0] = 2; coordinates[1]=2; break;
		}
		return coordinates;
	}
	//position picker
	static int[] positionPicker(int choiceI)
	{
		int [] coordinates = {0,0};
		coordinates = controlNumbers(choiceI);
		return coordinates;
	}
	//Printer here
	static void boardPrinter(String [][]board)
	{
		System.out.println("\t+-+-+-+");
		for (int n1=0; n1<3; n1++)
		{
			System.out.print("\t");
			for (int n=0; n<3; n++)
			{
				System.out.print("|"+board[n1][n]);
			}
			System.out.print("|");
			System.out.println("\n\t+-+-+-+");
		}
	}
	//winner=Checker
	static boolean winnerChecker(List<Integer> test)
	{
		boolean declare = true; 
		//(1,2,3)
		if (test.contains(1) && test.contains(2) && test.contains(3))
		{
					declare =false;
		}
		else if (test.contains(4) && test.contains(5) && test.contains(6))
		{
					declare =false;
		}
		else if (test.contains(7) && test.contains(8) && test.contains(9))
		{
					declare =false;
		}
		else if (test.contains(1) && test.contains(5) && test.contains(9))
		{
					declare =false;
		}
		else if (test.contains(2) && test.contains(5) && test.contains(8))
		{
					declare =false;
		}
		else if (test.contains(7) && test.contains(5) && test.contains(3))
		{
					declare =false;
		}
		else if (test.contains(3) && test.contains(6) && test.contains(9))
		{
					declare =false;
		}
		else if (test.contains(1) && test.contains(4) && test.contains(7))
		{
					declare =false;
		}
		else
		{
		}
		return declare;
	}
	//AI
	static int marAchMan(List<Integer> test, List <Integer> test2, int choice)
	{
		int counter = 1;
		
		
		if ((test2.contains(1)==false) && ((test.contains(2) && test.contains(3)) || (test.contains(5) && test.contains(9)) || (test.contains(4) && test.contains(7))))
		{
				counter = 1;
		}
		else if ((test2.contains(2)==false) && ((test.contains(1) && test.contains(3)) || ( test.contains(5) && test.contains(8))))
		{
				counter = 2;
		}
		else if ((test2.contains(3)==false) &&((test.contains(1) && test.contains(2)) || (test.contains(7) && test.contains(5)) || (test.contains(6) && test.contains(9))))
		{
				counter = 3;
		}
		else if ((test2.contains(4)==false) && ((test.contains(5) && test.contains(6)) || (test.contains(1) && test.contains(7))))
		{
				counter = 4;
		}
		else if ((test2.contains(5)==false) &&((test.contains(4)&& test.contains(6)) || (test.contains(1) && test.contains(9)) || (test.contains(2) && test.contains(8)) || (test.contains(7) && test.contains(3))))
		{
			counter = 5;
		}
		else if ((test2.contains(6)==false) &&((test.contains(4) && test.contains(5)) || (test.contains(3) && test.contains(9))))
		{
				counter = 6;
		}
		else if ((test2.contains(7)==false) && ((test.contains(8) && test.contains(9)) || (test.contains(5) && test.contains(3)) || (test.contains(1) && test.contains(4))))
		{
				counter = 7;
		}
		else if ((test2.contains(8)==false) && ((test.contains(7)  && test.contains(9)) || (test.contains(2) && test.contains(5))))
		{
					counter = 8;
		}
		else if ((test2.contains(9)==false) && ((test.contains(7) && test.contains(8)) || (test.contains(1) && test.contains(5)) || (test.contains(3) && test.contains(6))))
		{
				counter = 9;
		}
		else if (test.contains(5)==false	&& test2.contains(choice)==false)
		{
			counter = 5;
		}
		else
		{
			int n =0;
			do 
			{
					n++;
			}
			while (test.contains(n) || test2.contains(n));
			counter =n;
		}
		return counter;
	}
	static int marAchManV2(List<Integer> test, List <Integer> test2, int choice)
	{
		int counter = 1;
			//Game initializer (Scripted first turn)
		 	if (test.contains(5)==false && test2.contains(choice)==false)
		 	{
			counter = 5;
			}
		 	//First Analysis (winning move analyzer)
			else if (((test.contains(1)||test2.contains(1))==false) && ((test2.contains(2) && test2.contains(3)) || (test2.contains(5) && test2.contains(9)) || (test2.contains(4) && test2.contains(7))))
		 	{
					counter = 1;
			}
			else if (((test.contains(2)||test2.contains(2))==false) && ((test2.contains(1) && test2.contains(3)) || ( test2.contains(5) && test2.contains(8))))
			{
					counter = 2;
			}
			else if (((test.contains(3)||test2.contains(3))==false) &&((test2.contains(1) && test2.contains(2)) || (test2.contains(7) && test2.contains(5)) || (test2.contains(6) && test2.contains(9))))
			{
					counter = 3;
			}
			else if (((test.contains(4)||test2.contains(4))==false) && ((test2.contains(5) && test2.contains(6)) || (test2.contains(1) && test2.contains(7))))
			{
					counter = 4;
			}
			else if (((test.contains(5)||test2.contains(5))==false) &&((test2.contains(4)&& test2.contains(6)) || (test2.contains(1) && test2.contains(9)) || (test2.contains(2) && test2.contains(8)) || (test2.contains(7) && test2.contains(3))))
			{
					counter = 5;
			}
			else if (((test.contains(6)||test2.contains(6))==false) &&((test2.contains(4) && test2.contains(5)) || (test2.contains(3) && test2.contains(9))))
			{
					counter = 6;
			}
			else if (((test.contains(7)||test2.contains(7))==false) && ((test2.contains(8) && test2.contains(9)) || (test2.contains(5) && test2.contains(3)) || (test2.contains(1) && test2.contains(4))))
			{
					counter = 7;
			}
			else if (((test.contains(8)||test2.contains(8))==false) && ((test2.contains(7)  && test2.contains(9)) || (test2.contains(2) && test2.contains(5))))
			{
					counter = 8;
			}
			else if (((test.contains(9)||test2.contains(9))==false) && ((test2.contains(7) && test2.contains(8)) || (test2.contains(1) && test2.contains(5)) || (test2.contains(3) && test2.contains(6))))
			{
					counter = 9;
			}
		 	//Second analysis (combo blocker)
		 	else if (((test.contains(1)||test2.contains(1))==false) && ((test.contains(2) && test.contains(3)) || (test.contains(5) && test.contains(9)) || (test.contains(4) && test.contains(7))))
		 	{
					counter = 1;
			}
			else if (((test.contains(2)||test2.contains(2))==false) && ((test.contains(1) && test.contains(3)) || ( test.contains(5) && test.contains(8))))
			{
					counter = 2;
			}
			else if (((test.contains(3)||test2.contains(3))==false) &&((test.contains(1) && test.contains(2)) || (test.contains(7) && test.contains(5)) || (test.contains(6) && test.contains(9))))
			{
					counter = 3;
			}
			else if (((test.contains(4)||test2.contains(4))==false) && ((test.contains(5) && test.contains(6)) || (test.contains(1) && test.contains(7))))
			{
					counter = 4;
			}
			else if (((test.contains(5)||test2.contains(5))==false) &&((test.contains(4)&& test.contains(6)) || (test.contains(1) && test.contains(9)) || (test.contains(2) && test.contains(8)) || (test.contains(7) && test.contains(3))))
			{
					counter = 5;
			}
			else if (((test.contains(6)||test2.contains(6))==false) &&((test.contains(4) && test.contains(5)) || (test.contains(3) && test.contains(9))))
			{
					counter = 6;
			}
			else if (((test.contains(7)||test2.contains(7))==false) && ((test.contains(8) && test.contains(9)) || (test.contains(5) && test.contains(3)) || (test.contains(1) && test.contains(4))))
			{
					counter = 7;
			}
			else if (((test.contains(8)||test2.contains(8))==false) && ((test.contains(7)  && test.contains(9)) || (test.contains(2) && test.contains(5))))
			{
					counter = 8;
			}
			else if (((test.contains(9)||test2.contains(9))==false) && ((test.contains(7) && test.contains(8)) || (test.contains(1) && test.contains(5)) || (test.contains(3) && test.contains(6))))
			{
					counter = 9;
			}
		 	
		 	//Third Analysis (advance combo prevention)
			else if (((test.contains(1)||test2.contains(1))==false) && ((((test.contains(9)&&test2.contains(5))||(test2.contains(9)&&test.contains(5)))==false)&&
												    (((test.contains(7)&&test2.contains(4))||(test2.contains(7)&&test.contains(4)))==false)&&
												 	(((test.contains(3)&&test2.contains(2))||(test2.contains(3)&&test.contains(2)))==false)))
			{
				counter = 1;
			}
			else if (((test.contains(2)||test2.contains(2))==false) && ((((test.contains(8)&&test2.contains(5))||(test2.contains(8)&&test.contains(5)))==false)&&
												    (((test.contains(5)&&test.contains(9))||(test2.contains(1)&&test.contains(3)))==false)&&
												    ((test.contains(1)&&test2.contains(3))==false)))
			{
				counter = 2;
			}
			else if (((test.contains(3)||test2.contains(3))==false) &&((((test.contains(9)&&test2.contains(6))||(test2.contains(9)&&test.contains(6)))==false)&&
													(((test.contains(7)&&test2.contains(5))||(test2.contains(7)&&test.contains(5)))==false)&&
													(((test.contains(1)&&test2.contains(2))||(test2.contains(1)&&test.contains(2)))==false)&&
													((test.contains(1)&&test.contains(8))==false)))
			{
				counter = 3;
			}
			else if (((test.contains(4)||test2.contains(4))==false) && ((((test.contains(5)&&test2.contains(6))||(test2.contains(5)&&test.contains(6)))==false)&&
												 	(((test.contains(1)&&test2.contains(7))||(test2.contains(1)&&test.contains(7)))==false)))
			{
				counter = 4;
			}
			else if (((test.contains(5)||test2.contains(5))==false) &&((((test.contains(4)&&test2.contains(6))||(test2.contains(4)&&test.contains(6)))==false)&&
												   (((test.contains(2)&&test2.contains(8))||(test2.contains(2)&&test.contains(8)))==false)&&
												   (((test.contains(1)&&test2.contains(9))||(test2.contains(1)&&test.contains(9)))==false)&&
												   (((test.contains(7)&&test2.contains(3))||(test2.contains(7)&&test.contains(3)))==false)))
			{
				counter = 5;
			}
			else if (((test.contains(6)||test2.contains(6))==false) &&((((test.contains(4)&&test2.contains(5))||(test2.contains(4)&&test.contains(5)))==false)&&
					   							   (((test.contains(3)&&test2.contains(9))||(test2.contains(3)&&test.contains(9)))==false)))
			{
				counter = 6;
			}
			else if (((test.contains(7)||test2.contains(7))==false) &&((((test.contains(3)&&test2.contains(5))||(test2.contains(3)&&test.contains(5)))==false)&&
					   							   (((test.contains(8)&&test2.contains(9))||(test2.contains(8)&&test.contains(9)))==false)&&
					   							   (((test.contains(1)&&test2.contains(4))||(test2.contains(1)&&test.contains(4)))==false)))
			{
				counter = 7;
			}
			else if (((test.contains(8)||test2.contains(8))==false) && ((((test.contains(2)&&test2.contains(5))||(test2.contains(2)&&test.contains(5)))==false)&&
					   							   (((test.contains(7)&&test2.contains(9))||(test2.contains(7)&&test.contains(9)))==false)))
			{
				counter = 8;
			}
			else if (((test.contains(9)||test2.contains(9))==false) && ((((test.contains(1)&&test2.contains(5))||(test2.contains(1)&&test.contains(5)))==false)&&
				 								   (((test.contains(7)&&test2.contains(8))||(test2.contains(7)&& test.contains(8)))==false)&&
				 								   (((test.contains(3)&&test2.contains(6))||(test2.contains(3)&& test.contains(6)))==false)))							
			{
				counter = 9;
			}
		
			else //when there are no suspicious turn
			{
				int n =0;
				do 
				{
					n++;
				}
				while (test.contains(n) || test2.contains(n));
				counter =n;
			}
		return counter;
	}
	static void asciiArt(String description)
	{
		switch (description)
		{
		case "TICTACTOE":
					System.out.println("  ________________   _________   ______   __________  ______");
					System.out.println(" /_  __/  _/ ____/  /_  __/   | / ____/  /_  __/ __ \\/ ____/");
					System.out.println("  / /  / // /        / / / /| |/ /        / / / / / / __/   ");
					System.out.println(" / / _/ // /___     / / / ___ / /___     / / / /_/ / /___   ");
					System.out.println("/_/ /___/\\____/    /_/ /_/  |_\\____/    /_/  \\____/_____/ ");
					System.out.println("                                                            ");
					break;
		case "P1": 
					System.out.println("  ____  _                         _            _           _ ");
					System.out.println(" |  _ \\| | __ _ _   _  ___ _ __  / | __      _(_)_ __  ___| |");
					System.out.println(" | |_) | |/ _` | | | |/ _ \\ '__| | | \\ \\ /\\ / / | '_ \\/ __| |");
					System.out.println(" |  __/| | (_| | |_| |  __/ |    | |  \\ V  V /| | | | \\__ \\_|");
					System.out.println(" |_|   |_|\\__,_|\\__, |\\___|_|    |_|   \\_/\\_/ |_|_| |_|___(_)");
					System.out.println("                |___/                                        ");
					break;
		case "P2": 
					System.out.println("  ____  _                         ____             _           _ ");
					System.out.println(" |  _ \\| | __ _ _   _  ___ _ __  |___ \\  __      _(_)_ __  ___| |");
					System.out.println(" | |_) | |/ _` | | | |/ _ \\ '__|   __) | \\ \\ /\\ / / | '_ \\/ __| |");
					System.out.println(" |  __/| | (_| | |_| |  __/ |     / __/   \\ V  V /| | | | \\__ \\_|");
					System.out.println(" |_|   |_|\\__,_|\\__, |\\___|_|    |_____|   \\_/\\_/ |_|_| |_|___(_)");
					System.out.println("                |___/                                            ");
					break;
		case "AI":
					System.out.println("    __  ______    __  ___   _       _______   _______");
					System.out.println("   /  |/  /   |  /  |/  /  | |     / /  _/ | / / ___/");
					System.out.println("  / /|_/ / /| | / /|_/ /   | | /| / // //  |/ /\\__ \\ ");
					System.out.println(" / /  / / ___ |/ /  / /    | |/ |/ // // /|  /___/ / ");
					System.out.println("/_/  /_/_/  |_/_/  /_/     |__/|__/___/_/ |_//____/  ");
					System.out.println("                                                     ");
					break;
		case "Tie":
					System.out.println("    _   ______     _       _______   ___   ____________  _____");
					System.out.println("   / | / / __ \\   | |     / /  _/ | / / | / / ____/ __ \\/ ___/");
					System.out.println("  /  |/ / / / /   | | /| / // //  |/ /  |/ / __/ / /_/ /\\__ \\ ");
					System.out.println(" / /|  / /_/ /    | |/ |/ // // /|  / /|  / /___/ _  _/___/ / ");
					System.out.println("/_/ |_/\\____/     |__/|__/___/_/ |_/_/ |_/_____/_/ |_|/____/  ");
					System.out.println("                                                              ");
					break;
		case "U win":
					System.out.println("__  ______  __  __   _       _______   __");
					System.out.println("\\ \\/ / __ \\/ / / /  | |     / /  _/ | / /");
					System.out.println(" \\  / / / / / / /   | | /| / // //  |/ / ");
					System.out.println(" / / /_/ / /_/ /    | |/ |/ // // /|  /  ");
					System.out.println("/_/\\____/\\____/     |__/|__/___/_/ |_/   ");
					System.out.println("                                         ");
					break;
		case "Credits":
			System.out.println("\t-=Thank you po for playing Tic Tac Toe=-\n"
					+ "\t\t\t By:\n\t\t Marasigan, Vem Aiensi\n\t\t     Achero, Noriel\n\t        Manliguez, Angelica Mae");
					break;
		}
	}
}

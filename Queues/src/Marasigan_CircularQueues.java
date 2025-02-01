package queues;

import java.util.Scanner;

public class Marasigan_CircularQueues 
{
	static Scanner in = new Scanner(System.in);
	//variables
	static int [] queue;
	static int rear=-1;
	static int front=-1;
	static int choice = 0;
	
	public static void main(String[] args) 
	{
		System.out.print("Enter the size of the Queue:\t");
		queue = new int[in.nextInt()];
		do 
		{	
			System.out.println();
			System.out.print("Menu\n\t1. Enqueue\n\t2. Dequeue\n"
					+ "\t3. Display Queue\n\t4. Exit\nEnter Choice [1..4]: ");
			choice = in.nextInt();
			switch (choice)
			{
			case 1: Enqueue(); break;
			case 2: Dequeue(); break;
			case 3: //Display_Queue.CircleBeta();
					Display_Queue.ArrayPrint();
					Display_Queue.Status();
					break;
			case 4: Exit(); break;
			default: choice = 5; break;
			}
		}
		while (choice < 6 ); 
	}
	
	static void Enqueue()
	{
		
		System.out.println();
		System.out.println("\t-=ENQUEUE=-");
		do 
		{
			System.out.print("Enter a number: ");
			int data = in.nextInt();
			int backup = rear;
			rear = (rear+1)% queue.length;
		
			if (front == rear)
			{
				System.out.println("Queue is full");
				rear = backup;
				choice = 0;
			}
			else
			{
				queue[rear] = data;
				System.out.print("Want to add more? Yes[1] No[0]: ");
				choice = in.nextInt();
			}
			if (front == -1)
			{
				front = 0; rear = 0;
			}
		}
		while (choice == 1);
		Display_Queue.ArrayPrint();
		Display_Queue.Status();
	}
	
	static void Dequeue()
	{
		System.out.println();
		System.out.println("\t-=DEQUEUE=-");
		do 
		{
			if (front==-1)
			{
				System.out.println("Queue is empty");
			}
			else
			{
				System.out.print(queue[front] + " is removed");
				queue[front] = 0;
			}
			if (rear == front)
			{
				front= -1;
				rear = -1;
			}		
			else
			{
				front = (front+1)%queue.length;
			}
			
			System.out.print("\nDo you want to Dequeue again? Yes[1] No[0]: ");
			choice = in.nextInt();
			
		}while (choice == 1);
		
		Display_Queue.ArrayPrint();
		Display_Queue.Status();
	}
	
	class Display_Queue
	{
		//Array printing
		static void ArrayPrint()
		{
			System.out.println();
			System.out.print("\t+");
			for (int i = 0; i < queue.length; i++)
			{
				System.out.print("-------+");
			}
			System.out.println();
			
			System.out.print("QUEUE:\t");
			System.out.print("|");
			for (int i = 0; i < queue.length; i++)
			{
				if (queue[i] == 0)
					System.out.print(" " + "\t|");
				else
					System.out.print(queue[i] + "\t|");
			}
			System.out.println();
			
			System.out.print("\t+");
			for (int i = 0; i < queue.length; i++)
			{
				System.out.print("-------+");
			}
			System.out.println();
			
			System.out.print("INDEX:\t");
			System.out.print("|");
			for (int i = 0; i < queue.length; i++)
			{
				System.out.print(i + "\t|");
			}
			System.out.println();
			
			System.out.print("\t+");
			for (int i = 0; i < queue.length; i++)
			{
				System.out.print("-------+");
			}
			System.out.println();
		}
			
		//Linear printing
		static void LinearPrint()
		{
			int i = front;
			if (i == -1)
			{
				System.out.println("Queue is Empty");
			}
			else
			{
				do
				{
				System.out.print(queue[i]);
				i= (i+1)%queue.length;
			
				if (i != (rear+1)%queue.length)
				System.out.print("-"); //prints dashes only in between
			
				}while (i != (rear+1)%queue.length);
				System.out.println();
			}
		}
		
		static void Status()
		{
			System.out.println();
			System.out.print("[Status]\nQueue: ");
			Display_Queue.LinearPrint();
			
			
			System.out.print("Front index: " + front + "\t\t");
			if (Marasigan_CircularQueues.front == -1)
			{
			System.out.print("Data: No Data");
			}
			else
			{
				System.out.print("Data: " + queue[front]);
			}
			
			System.out.print("\nRear  index: " + rear + "\t\t");
			if (Marasigan_CircularQueues.rear == -1)
			{
				System.out.print("Data: No Data");
			}
			else
			{
				System.out.print("Data: " + queue[rear]);
			}
			System.out.println();
		}
		
		static void CircleBeta()
		{
			System.out.println();
			System.out.println("   7    0");
			System.out.println("6   " + queue[0] + "  " + queue[1]+ "   1");
			System.out.println("  " +queue[2] + "      " + queue[3]);
			System.out.println("  "+ queue[4] + "      " +  queue[5]);
			System.out.println("5   " + queue[6] + "  " + queue[7] + "   2");
			System.out.println("   4    3");
		}
	}
	
	static void Exit()
	{
		System.out.println();
		System.out.println("\tThank you po ^_^\n"
				+ "   By: Marasigan, Vem Aiensi");
		System.exit(1);
	}
	

}

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class BSCS_2_Marasigan_Stack 
{
	static Scanner in = new Scanner(System.in);
	static int size = 0;
	static int limit = 0; 
	static int choice = 0;
	static int push = 0;
	static JTextField scope = new JTextField();
	
	public static void main(String[] args)
	{
		boolean repeat = true;
		do {
		try
		{
			System.out.println("[1] Console Mode\t[2]GUI-Beta");
			System.out.print("Choose mode: ");
			choice  = in.nextInt();
			switch (choice)
			{
				case 1: consoleMode(); break;
				case 2:	System.out.println("Stack (Beta) is now launched...");
						stackGUIbeta(); break;
				default: System.out.println("Wrong input, Please try again\n"); break;
			}
			if ((choice == 1)|| (choice ==2) )
				repeat = false;
		}
		catch (Exception e)
		{
			in.next();
			System.out.println("Wrong input, Please try again\n");
		}
		}while (repeat);
		
	}
	
	static void consoleMode()
	{
		boolean repeat=true;
		while (repeat)
		{
			try{
				System.out.print("How many elements will the stack have: ");
				limit = in.nextInt();
			}
			catch (Exception e){
				limit = 0; in.next();
				System.out.println("Wrong input, Please try again\n");
			}
			if (limit > 0)
				repeat = false;
		}
		
		int [] stack = new int[limit];
		int choice = 0;
		System.out.println("Stack Created!");
		do {
			try {
				System.out.println("MENU\n1. PUSH\n2. POP\n3. TOP\n4."
						+ " SIZE\n5. EMPTY\n6. DISPLAY STACK\n7. EXIT");
				System.out.print("Enter Choice [1..7]: ");
				choice = in.nextInt();
				
				switch (choice)
				{
					case 1: System.out.print("Enter number to add to the stack: ");
					push = in.nextInt();
					pusher(stack, limit, push); displayStack(stack); break;
					case 2: poper(stack); break;
					case 3: showTop(stack);break;
					case 4: stackSize(); break;
					case 5: stackChecker(stack); break;
					case 6: displayStack(stack); break;
					case 7: System.out.println("Thank you po for using my program\n"
							+ "-by Vem Aiensi A. Marasigan");break;
					default:System.out.println("Wrong input, Please try again\n"); break;
				}
			}
			catch (Exception e)
			{
				choice = 0; in.next();
				System.out.println("Wrong input, Please try again\n");
			}
		}while (choice != 7);
	}
	
	static void stackGUIbeta()
	{	//Note: I learned some of GUI from Alex Lee and Bro Code's Java GUI tutorial
		//All credits to them ^_^;
		//And I am very Grateful >v< to our Very Kind Professor for extending the deadline
		JFrame createStack = new JFrame();
		
		scope.setBounds(50, 80, 100, 25);
		
		JLabel elements = new JLabel("How many elements will the stack have?");
		elements.setBounds(45, 40, 400, 25);
		
		JButton insert = new JButton("CREATE");
		insert.setBounds(170, 80, 100, 25);
		ActionListener make = new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
					{
						limit = Integer.parseInt(scope.getText());
						System.out.println("Stack Created!\n" + 
						limit + " elements can be stored in the stack.\n");	
					
						int [] stack = new int[limit];
						JLabel ask=new JLabel("Please type number here:"); 
						ask.setBounds(50, 45, 220, 25);
						
						JTextField input = new JTextField();
						input.setBounds(220, 45, 170, 25);
						
						JButton button1 = new JButton("PUSH");
						button1.setBounds(50, 90, 100, 25);
						ActionListener one = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								push = Integer.parseInt(input.getText());
						    	 pusher(stack, limit, push); displayStack(stack);
						     }
						    };
						button1.addActionListener(one);
						
						JButton button2 = new JButton("POP");
						button2.setBounds(170, 90, 100, 25);
						ActionListener two = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
						    	 poper(stack);
						     }
						    };
						button2.addActionListener(two);
						
						JButton button3 = new JButton("TOP");
						button3.setBounds(290, 90, 100, 25);
						ActionListener three = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								 showTop(stack);
						     }
						    };
						button3.addActionListener(three);
						
						JButton button4 = new JButton("SIZE");
						button4.setBounds(50, 135, 100, 25);
						ActionListener four = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								stackSize(); 
						     }
						    };
						button4.addActionListener(four);
						
						JButton button5 = new JButton("EMPTY");
						button5.setBounds(170, 135, 100, 25);
						ActionListener five = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								stackChecker(stack); 
						     }
						    };
						button5.addActionListener(five);
						
						JButton button6 = new JButton("DISPLAY");
						button6.setBounds(290, 135, 100, 25);
						ActionListener six = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								displayStack(stack); 
						     }
						    };
						button6.addActionListener(six);
						
						JButton button7 = new JButton("END");
						button7.setBounds(170, 180, 100, 25);
						ActionListener seven = new ActionListener() {
							public void actionPerformed(ActionEvent e)
						     {
								System.out.println("\t\t-=StackGUI-Beta=-\n"
										+ "\t   by Vem Aiensi Marasigan >.<\n\n\n"
										+ "\n Note: I'm new po to GUI and it may lack features");
							System.exit(0);
						     }
						    };
						button7.addActionListener(seven);
						
						createStack.setVisible(false);
						
						JPanel panel = new JPanel();
						panel.setLayout(null);
						panel.add(button1);
						panel.add(button2);
						panel.add(button3);
						panel.add(button4);
						panel.add(button5);
						panel.add(button6);
						panel.add(button7);
						panel.add(input);
						panel.add(ask);
						
						JFrame mainWindow = new JFrame();
						mainWindow.setTitle("Stack -Beta");
						//mainWindow.setDefaultCloseOperation(1);
						mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						mainWindow.setSize(450, 300);
						mainWindow.setVisible(true);
						mainWindow.setResizable(false);
						mainWindow.add(panel);
					}	
				};
		insert.addActionListener(make);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(null);
		firstPanel.add(insert);
		firstPanel.add(elements);
		firstPanel.add(scope);
		
		createStack.setTitle("Stack -Beta");
		//createStack.setDefaultCloseOperation(1);
		createStack.setSize(350, 200);
		createStack.setVisible(true);
		createStack.setResizable(false);
		createStack.add(firstPanel);
	}
	
	//Methods Here
 	static void pusher(int[] stack, int limit, int push)
	{
		if (size==limit)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			System.out.println("Stack data:  " + push + " successfully pushed\n");
			stack[size]=push;
			size++;
		}
	}
	static void poper(int[] stack)
	{
		if (size > 0)
		{
			System.out.println(stack[size-1] +" is removed from the stack.\n");
			size--;
		}
		else
		{
			System.out.println("Stack is Empty\n");
		}
	}
	static void showTop(int[] stack)
	{
		if (size > 0)
		{
			System.out.println(stack[size-1] +" is the top value of the stack.\n");
		}
		else
		{
			System.out.println("Stack is Empty\n");
		}
	}
	static void stackSize()
	{
		if (size>0)
		{
			System.out.println("The stack has a size of "+size + ".\n");
		}
		else
		{
			System.out.println("Size is 0: Stack is Empty.\n");
		}
	}
	static void stackChecker(int[] stack)
	{
		if (size==0){
			System.out.println("TRUE: The Stack is Empty\n");
			}
		else
			System.out.println("FALSE: The Stack contains " + size + " elements.\n");
		
	}
	static void displayStack(int[] stack)
	{
		if(size==0)
		{
			System.out.println("Stack is Empty\n");
		}
		else
		{
			System.out.println("The stack contains: ");
			for (int n=0; n<size; n++)
			{
				System.out.print("+-------");
			}
			System.out.println("+");
			for (int n=0; n<size; n++)
			{
				System.out.print("|"+stack[n]+"\t");
			}
			System.out.println("|");
			for (int n=0; n<size; n++)
			{
				System.out.print("+-------");
			}
			System.out.println("+");
		}
	}
}

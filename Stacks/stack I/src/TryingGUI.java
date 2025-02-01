package stack;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class TryingGUI
{
	static Scanner in = new Scanner(System.in);
	static JTextField input = new JTextField();
	
	public static void main(String args[])
	{
		System.out.println("Just trying Hard Here:");
	     GUI();
	}
	
	static void GUI()
	{
		JFrame stack = new JFrame();
		
		ActionListener one = new ActionListener() {
			public void actionPerformed(ActionEvent e)
		     {
		    	 yah();
		     }
		    };
		ActionListener two = new ActionListener() {
			public void actionPerformed(ActionEvent e)
			 {
			     stack.setDefaultCloseOperation(0);
			  }
			  };
		
		
		
		JButton button = new JButton("One");
		button.setBounds(50, 90, 80, 25);
		button.addActionListener(one);
	    
	    JButton button2 = new JButton("Two");
	    button2.setBounds(150, 90, 80, 25);
	    button2.addActionListener(two);
	    
	    input.setBounds(150, 50,80,25);
	    
	    JLabel label = new JLabel("Hey uhm....");
	    label.setBounds(150, 10, 200, 25);
	    
	    JLabel promptUser = new JLabel("^_^");
	    promptUser.setBounds(50, 50, 80, 25);

	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      panel.add(promptUser);
	      panel.add(label);
	      panel.add(input);
	      panel.add(button); panel.add(button2);
	      
	     stack.setTitle("Stack - Beta");
		 stack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 stack.setSize(500,300);
		 stack.setResizable(false);
	     stack.setVisible(true);
	     stack.add(panel);
	}
static void hey()
{
	System.out.println("new word");
}
static void yah()
{
	int hey =Integer.parseInt(input.getText());
	System.out.println(hey - 2+ ", input trial");
}

}



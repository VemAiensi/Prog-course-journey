import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "000001";

        System.out.println("---[ Welcome to DFA ]---\n" +
                "by Marasigan, Vem Aiensi : 3BSCS-1\n\n" +
                "Note* Accepts Binary strings ending only in '01'\n");

        while(true) {
            System.out.print("Enter Binary String: ");
            input = in.next();
            DFA(input);
        }
    }

    static void DFA(String input)
    {
        String state = "q0";

        for(int i = 0; i<input.length(); i++)
        {
            if(state.equals("q0") && input.charAt(i) == '0')
                state = "q1";

            else if(state.equals("q0") && input.charAt(i) == '1')
                state = "q0";

            else if(state.equals("q1") && input.charAt(i) == '0')
                state = "q1";

            else if(state.equals("q1") && input.charAt(i) == '1')
                state = "q2";

            else if(state.equals("q2") && input.charAt(i) == '1')
                state = "q0";

            else if(state.equals("q2") && input.charAt(i) == '0')
                state = "q1";
        }

        if(state.equals("q2"))
            System.out.println("String Accepted :)\n");
        else
            System.out.println("String not Accepted :(\n");
    }
}
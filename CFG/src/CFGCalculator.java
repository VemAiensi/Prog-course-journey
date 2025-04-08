import java.util.ArrayList;
import java.util.Scanner;

public class CFGCalculator {

    private static ArrayList<Variable> variables;  // Set of Variables
    private static ArrayList<String> T;  // Set of Terminals

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input - Set of Variables (V)
        System.out.print("Enter the set of variables (separated by commas): ");
        String[] vars = sc.nextLine().split(",");
        variables = new ArrayList<>();
        for (String var : vars) {
            Variable v = new Variable(var.trim());
            variables.add(v);
        }


        // User Input - Set of Terminals (T)
        System.out.print("Enter the set of terminals (separated by commas): ");
        String[] terms = sc.nextLine().split(",");
        T = new ArrayList<>();
        for (String term : terms) {
            T.add(term.trim());
        }

        // User Input - Production or Rule (P)
        System.out.println("\n---Type the production rules---. \nIndicate Variable name first, then '->' and its production." +
                "\nType & to indicate epsilon" +
                "\nRefer to this example: S->rule" +
                "\nPlease indicate rules seperately");
        String production = sc.nextLine();
        while (!production.isEmpty()) {
            String n = String.valueOf(production.charAt(0));
            for (int i = 0; i < variables.size(); i++) {
                if (n.equals(variables.get(i).getName())) {
                    variables.get(i).addRules(production.substring(3));
                }
            }
            production = sc.nextLine();
        }

        System.out.println("Production rule");
        for(int i =0; i<variables.size(); i++)
        {
            System.out.println(variables.get(i).showRules());
        }

        // User Input - Starting Symbol (S)
        System.out.print("\nEnter the starting symbol: ");
        String start  = sc.nextLine();
        for(int i=0; i<variables.size(); i++)
        {
            if (start.equals(variables.get(i).getName()))
            {
                variables.get(i).setClas();
            }
        }

        String answer = "yes";
        // User Input - CFG to test whether it matches with the Production
        do {
            System.out.print("Enter the CFG to test: ");
            String cfg = sc.nextLine();

            processCFG(cfg);

            System.out.print("Want to continue? ");
            answer = sc.nextLine();
        }while (answer.equals("yes"));

    }

    public static void processCFG(String string)
    {
        String proc = "";
        String sol = "";
        //look at start variable
        for(int i = 0; i < variables.size(); i++)
        {
            if(variables.get(i).getClas().equals("Start"))
            {
                sol += variables.get(i).getName();
                proc = bestMatch(string, variables.get(i));
                sol += "->" + proc + "\n";

                if (proc.equals(string))
                    System.out.println("\nThe string is accepted");
            }
        }

        while(!proc.equals(string) && proc.length()<string.length()+3) {
            for (int i = 0; i < proc.length(); i++) {
                if (Character.isUpperCase(proc.charAt(i))) {
                    for (int j = 0; j < variables.size(); j++) {
                        if (variables.get(j).getName().equals(String.valueOf(proc.charAt(i)))) {
                            proc = bestMatch2(string, variables.get(j).getName(), variables.get(j).getRules(), proc);
                            sol += " ->" + proc +"\n";
                            if(epsilonChecker(proc))
                            {
                                proc = replaceVar(proc, "&", "");
                                sol += " ->" + proc +"\n";
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (proc.equals(string))
            System.out.println(sol + "\nThe string is accepted");
        else System.out.println("\nThe string is rejected");
    }

    public static String bestMatch(String string, Variable var)
    {
        String rule = "no rule";

        ArrayList<Rule> rules = var.getRules();
        for(int i = 0; i < rules.size(); i++)
        {
            if(rules.get(i).getKind().equals("w/o var"))
            {
                if(rules.get(i).getRule().equals(string))
                {
                    rule = rules.get(i).getRule();
                }
            }
        }
        if(rule.equals("no rule"))
        for(int i = 0; i < rules.size(); i++)
        {
            if (rules.get(i).getKind().equals("w/ var"))
            {
                rule = rules.get(i).getRule();
            }
        }
        return rule;
    }

    public static boolean epsilonChecker(String string)
    {
        boolean thereIs = false;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == '&')
            {
                thereIs = true;
            }
        }
        return thereIs;
    }
    public static String bestMatch2(String string, String var, ArrayList<Rule> rules, String proc)
    {
        String test = proc;
        for(int i = 0; i < rules.size(); i++)
        {
            if(rules.get(i).getKind().equals("w/o var"))
            {
                if(replaceVar(proc, var, rules.get(i).getRule()).equals(string))
                {
                    test = replaceVar(proc, var, rules.get(i).getRule());
                }
            }
        }
        if(test.equals(proc))
            for(int i = 0; i < rules.size(); i++)
            {
                if (rules.get(i).getKind().equals("epsilon"))
                {
                    if(replaceVar(proc, var,"").equals(string))
                    {
                        test = replaceVar(proc, var, rules.get(i).getRule());
                    }
                }
            }
        if(test.equals(proc))
            for(int i = 0; i < rules.size(); i++)
            {
                if (rules.get(i).getKind().equals("w/ var"))
                {
                    test = replaceVar(proc, var, rules.get(i).getRule());
                }
            }
        return test;

    }
    public static String replaceVar(String string, String tbr, String tbi)
    {
        String result = "";
        for(int i = 0; i < string.length(); i++)
        {
            if (String.valueOf(string.charAt(i)).equals(tbr))
            {
                result += tbi;
            }
            else result += string.charAt(i);
        }
        return result;
    }
}
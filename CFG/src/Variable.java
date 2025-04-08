import java.util.ArrayList;

public class Variable {

    private String name;
    private ArrayList<Rule> rules = new ArrayList<>();
    private String clas = "notStart";

    public void setClas()
    {
        clas = "Start";
    }
    public ArrayList<Rule> getRules()
    {
        return rules;
    }
    public Variable(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void addRules(String rule)
    {
        Rule r = new Rule(rule);
        rules.add(r);
    }


    public String showRules() {
        String rules = name + "-> ";
        for (int i = 0; i < this.rules.size(); i++)
        {
            rules += this.rules.get(i).getRule();
            if (i != this.rules.size()-1)
            {
                rules +=  " | ";
            }
        }
        return rules;
    }

    public String getClas() {
        return clas;
    }
}

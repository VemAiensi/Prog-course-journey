public class Rule {
    private String rule;
    private String kind = "w/o var";

    public Rule(String rule)
    {
        this.rule = rule;

        for(int i = 0; i<rule.length(); i++)
        {//only checks if there is a variable in the rule
            if (Character.isUpperCase(rule.charAt(i)))
            {
                kind = "w/ var";
            }
        }

        if(rule.equals("&"))
        {
            kind = "epsilon";
        }
    }

    public String getRule(){return rule;}
    public String getKind() {return kind;}
}

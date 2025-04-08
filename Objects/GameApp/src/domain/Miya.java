package domain;

import domain.Warrior;

public class Miya implements Warrior {
    private String warriorID;
    private String weapon;
    private Integer arrowsLeft;
    private Integer noOfKills;

    @Override
    public String showWarriorAndKills() {
        String string =  "Miya is using " + this.weapon + "! has "
                + this.arrowsLeft + " arrows left and killed " + this.noOfKills;
        return string;
    }
    public void setWarriorID(String warriorID) {
        this.warriorID = warriorID;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public void setArrowsLeft(Integer arrowsLeft) {
        this.arrowsLeft = arrowsLeft;
    }
    public void setNoOfKills(Integer noOfKills) {
        this.noOfKills = noOfKills;
    }
}

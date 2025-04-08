package domain;

import domain.Warrior;

public class Vexana implements Warrior {
    private String warriorID;
    private String weapon;
    private Integer bombsLeft;
    private Integer noOfKills;

    @Override
    public String showWarriorAndKills() {
        String string =  "Vexana is using " + this.weapon + "! has "
                + this.bombsLeft + " bombs left and killed " + this.noOfKills;
        return string;
    }
    public void setWarriorID(String warriorID) {
        this.warriorID = warriorID;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public void setBombsLeft(Integer bombsLeft) {
        this.bombsLeft = bombsLeft;
    }
    public void setNoOfKills(Integer noOfKills) {
        this.noOfKills = noOfKills;
    }
}

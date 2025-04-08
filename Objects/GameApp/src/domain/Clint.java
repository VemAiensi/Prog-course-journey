package domain;

import domain.Warrior;

public class Clint implements Warrior {
    private String warriorID;
    private String weapon;
    private Integer bulletsLeft;
    private Integer noOfKills;

    @Override
    public String showWarriorAndKills() {
        String string = "Clint is using " + this.weapon + "! has "
                        + this.bulletsLeft + " bullets left and killed " + this.noOfKills;
        return string;
    }
    public void setWarriorID(String warriorID) {
        this.warriorID = warriorID;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public void setBulletsLeft(Integer bulletsLeft) {
        this.bulletsLeft = bulletsLeft;
    }
    public void setNoOfKills(Integer noOfKills) {
        this.noOfKills = noOfKills;
    }
}

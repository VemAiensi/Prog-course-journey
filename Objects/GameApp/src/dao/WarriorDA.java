package dao;

import domain.*;

import java.io.*;
import java.util.*;

public class WarriorDA {
    private List<Warrior> warriorList;
    public List<Warrior> getWarriorList() {
        return warriorList;
    }
    public WarriorDA(String teamID) throws FileNotFoundException
    {
        Scanner teamStatInfo = new Scanner(new FileReader("src/teamStatInfo.csv"));
        warriorList = new ArrayList<Warrior>();

        while (teamStatInfo.hasNext())
        {
            String warriorString = teamStatInfo.nextLine();
            String [] warriorData = new String [4];
            warriorData = warriorString.split(",");

            //warriorData[0] - teamID
            //warriorData[1] - warriorID
            //warriorData[2] - ammunationsLeft
            //warriorData[3] - number of kills

            if (teamID.equals(warriorData[0]))
            {
                switch(warriorData[1])
                {
                    case "warrior1":
                        Warrior clint = new Clint();
                        ((Clint)clint).setWarriorID(warriorData[1]);
                        ((Clint)clint).setWeapon("Guns");
                        ((Clint)clint).setBulletsLeft(Integer.parseInt(warriorData[2]));
                        ((Clint)clint).setNoOfKills(Integer.parseInt(warriorData[3]));
                        warriorList.add(clint);
                        break;

                    case "warrior2":
                        Warrior miya = new Miya();
                        ((Miya)miya).setWarriorID(warriorData[1]);
                        ((Miya)miya).setWeapon("Archery");
                        ((Miya)miya).setArrowsLeft(Integer.parseInt(warriorData[2]));
                        ((Miya)miya).setNoOfKills(Integer.parseInt(warriorData[3]));
                        warriorList.add(miya);
                        break;

                    case "warrior3":
                        Warrior vexana = new Vexana();
                        ((Vexana)vexana).setWarriorID(warriorData[1]);
                        ((Vexana)vexana).setWeapon("Bombs");
                        ((Vexana)vexana).setBombsLeft(Integer.parseInt(warriorData[2]));
                        ((Vexana)vexana).setNoOfKills(Integer.parseInt(warriorData[3]));
                        warriorList.add(vexana);
                        break;
                    default:
                        System.exit(0);
                }
            }
        }
    }
}

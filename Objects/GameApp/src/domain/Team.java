package domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamID;
    private String teamName;
    private Integer totalKills;

    private List<Warrior> warriorList;

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills() {
        this.totalKills = 0;
        for (int count = 0; count < warriorList.size(); count++)
        {
            String data = warriorList.get(count).showWarriorAndKills();
            data = String.valueOf(data.charAt(data.length()-1));
            this.totalKills += Integer.parseInt(data);
        }
    }

    public List<Warrior> getWarriorList() {
        return warriorList;
    }

    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorList = warriorList;
    }
}

package dao;

import domain.Team;
import domain.Warrior;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamDA {
    private List<Team> teamList;
    public List<Team> getTeamList() {
        return teamList;
    }
    public TeamDA() throws FileNotFoundException
    {
        Scanner teamInfo = new Scanner(new FileReader("src/teamInfo.csv"));
        teamList = new ArrayList<Team>();

        while (teamInfo.hasNext())
        {
            String teamString = teamInfo.nextLine();
            String [] teamData = new String [2];
            teamData = teamString.split(",");

            //teamData[0] - teamID
            //teamData[1] - teamName

            Team team =  new Team();
            WarriorDA warriorDA = new WarriorDA(teamData[0]);

            team.setTeamID(teamData[0]);
            team.setTeamName(teamData[1]);
            team.setWarriorList(warriorDA.getWarriorList());
            team.setTotalKills();
            teamList.add(team);
        }
    }
}

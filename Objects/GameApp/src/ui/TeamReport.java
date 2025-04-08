package ui;

import dao.TeamDA;

import java.io.FileNotFoundException;


public class TeamReport {
    public static void main(String[] args) throws FileNotFoundException
    {
        TeamDA teamDA = new TeamDA();
        String output = "GameApp 2 {OOP Laboratory Assignment 3}\n" +
                "-Vem Aiensi A. Marasigan [2 BSCS 1]\n" +
                "===========================================================\n";

        for(int count = 0; count<teamDA.getTeamList().size(); count++)
        {
            output += "Team ID: " + teamDA.getTeamList().get(count).getTeamID() + "\n" +
                    "Team Name: " + teamDA.getTeamList().get(count).getTeamName() + "\n" +
                    "Total Kills: " + teamDA.getTeamList().get(count).getTotalKills() + "\n";
            for (int count1 = 0; count1<teamDA.getTeamList().get(count).getWarriorList().size(); count1++)
            {
                output += "\t"+ teamDA.getTeamList().get(count).getWarriorList().get(count1).showWarriorAndKills() + "\n";
            }
            output += "\n";
        }
        System.out.print(output);
    }
}
package ui;

import dao.BlockSectionDA;

import java.io.FileNotFoundException;

public class COMReportVersion2 {
    public static void main (String [] args) throws FileNotFoundException {
        String report = "COM Report Version 2 {OOP Laboratory Assignment 2}\n" +
                "-Vem Aiensi A. Marasigan [2 BSCS 1]\n" +
                "===============================================================================================\n";

        BlockSectionDA blockSection = new BlockSectionDA();
        for(int count0 = 0; count0 < blockSection.getBlockList().size(); count0++)
        {
            report += "\nBlock Section Code: " + blockSection.getBlockList().get(count0).getBlockCode()
                +"\nDescription: " + blockSection.getBlockList().get(count0).getDescription()
                +"\nAdviser: " + blockSection.getBlockList().get(count0).getAdviser()
                +"\n\n"
                +"Total Students: " + blockSection.getBlockList().get(count0).getTotalStudents()
                +"\n-----------------------------------------------------------------------------------------------\n";
            for(int count1 = 0; count1<blockSection.getBlockList().get(count0).getTotalStudents();count1++)
            {
                report += "Student Number: " + blockSection.getBlockList().get(count0).getStudentList().get(count1).getStudentNumber()
                    +"\nStudent Name: " + blockSection.getBlockList().get(count0).getStudentList().get(count1).getName()
                    +"\nProgram: " + blockSection.getBlockList().get(count0).getStudentList().get(count1).getProgram()
                    +"\nTotal Units enrolled: " + blockSection.getBlockList().get(count0).getStudentList().get(count1).getTotalUnitsEnrolled()
                    +"\n\n"
                    +"Course Code\t\tDescription\t\t\t\t\tUnits\tDay\t\tTime\n";

                for(int count2 = 0; count2<blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().size(); count2++)
                {
                    report += blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().get(count2).getCourseCode()
                    +"\t\t" + wordAligner(blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().get(count2).getDescription())
                    +"\t\t" + blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().get(count2).getUnit()
                    +"\t\t" + blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().get(count2).getDay()
                    +"\t\t" + blockSection.getBlockList().get(count0).getStudentList().get(count1).getCourseList().get(count2).getTime()
                    +"\n";
                }
                report += "\n";
            }
            report += "\n===============================================================================================\n";
        }
        System.out.println(report);
    }
    static String wordAligner(String word)
    {//this method transforms the word length to a fixed length for alignment purposes
        String fixed = word;
        while(fixed.length() < 20)
            fixed += " ";

        return fixed;
    }
}
package ui;
import dao.DepartmentDA;
import java.io.*;
public class DepartmentReport {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("        +-------------------+\n" +
                         "--------| Department Report |--------\n" +
                         "        +-------------------+\n\n");
        new DepartmentDA();
    }
}

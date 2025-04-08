package dao;

import domain.Course;
import domain.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class StudentDA
{
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentDA(String blockCode) throws FileNotFoundException
    {
        Scanner studentInfo = new Scanner (new FileReader("src/studentInfo.csv"));
        studentList = new ArrayList<Student>();

        while (studentInfo.hasNext())
        {
            String studentString = studentInfo.nextLine();
            String [] studentData = new String [4];
            studentData = studentString.split(",");

            if (blockCode.equals(studentData[0]))
            {
                Student student = new Student();
                CourseDA courseDA = new CourseDA(studentData[1]);
                List<Course> courses= courseDA.getCourseList();

                //getting the total units the student enrolled based on courseList
                int totalUnits = 0;
                for(int count = 0; count < courses.size(); count++)
                {
                    totalUnits += courses.get(count).getUnit();
                }

                student.setStudentNumber(studentData[1]);
                student.setName(studentData[2]);
                student.setProgram(studentData[3]);
                student.setTotalUnitsEnrolled(totalUnits);
                student.setCourseList(courses);

                studentList.add(student);
            }
        }
    }

}

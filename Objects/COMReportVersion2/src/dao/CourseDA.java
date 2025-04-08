package dao;

import domain.Course;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CourseDA {

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public CourseDA(String studentNumber) throws FileNotFoundException
    {
        Scanner schedInfo = new Scanner(new FileReader("src/scheduleInfo.csv"));
        courseList = new ArrayList<Course>();

        while (schedInfo.hasNext())
        {
            String courseString = schedInfo.nextLine();
            String [] courseData = new String [6];
            courseData = courseString.split(",");

            if (studentNumber.equals(courseData[0]))
            {
                Course course = new Course();
                course.setCourseCode(courseData[1]);
                course.setDescription(courseData[2]);
                course.setUnit(Integer.parseInt(courseData[3]));
                course.setDay(courseData[4]);
                course.setTime(courseData[5]);

                courseList.add(course);
            }
        }
    }
}

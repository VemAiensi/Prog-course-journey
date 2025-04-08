package domain;

import java.util.List;

public class Student {
    private String studentNumber;
    private String name;
    private String program;
    private Integer totalUnitsEnrolled;
    private List<Course> courseList;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


    public Integer getTotalUnitsEnrolled() {
        return totalUnitsEnrolled;
    }

    public void setTotalUnitsEnrolled(Integer totalUnitsEnrolled) {
        this.totalUnitsEnrolled = totalUnitsEnrolled;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}

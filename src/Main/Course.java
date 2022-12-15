package Main;

import java.util.List;
import java.util.Vector;

import Employees.Teacher;
import Students.Student;

public class Course {
    private int id;
    private String nameOfCourse;
    private List<Student> students;
    private List<Teacher> teachers;
    private int numOfCredits;
    private Vector<Course> prerequisites;

    public Course(int id, String nameOfCourse, List<Student> students, List<Teacher> teachers, int numOfCredits, Vector<Course> prerequisites) {
        this.id = id;
        this.nameOfCourse = nameOfCourse;
        this.students = students;
        this.teachers = teachers;
        this.numOfCredits = numOfCredits;
        this.prerequisites = prerequisites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    public Vector<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Vector<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void getFullData(){}
}

package Employees;

import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import Main.Course;

public class Teacher extends Employee {
    private Vector<Course> courses;
    private TeacherType type;

    public Teacher(int id, String login, String password, String name, double salary, Employees.Date hireDate, Vector<Course> courses, TeacherType type) {
        super(id, login, password, name, salary, hireDate);
        this.courses = courses;
        this.type = type;
    }
    
    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public TeacherType getType() {
        return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public void openAttendance() {
    }

    public void viewStudents() {
    }

    public void manageCourseFiles() {
    }

    public void generateReport() {
    }

    public void addFile() {
    }

    public void removeFile() {
    }

    public void searchStudent() {
    }

    public void viewStudentInfo() {
    }

    public void startAttendance() {
    }

    public void doManualAttendance() {
    }

}

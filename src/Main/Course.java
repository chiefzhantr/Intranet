package Main;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

import Employees.Teacher;

public class Course {
    private int id;
    private String nameOfCourse;
    private List<Student> students;
    private int numOfCredits;
    private Vector<Course> prerequisites;

    public Course() {
    	
    }

	public Course(String nameOfCourse) {
    	this.nameOfCourse = nameOfCourse;
    }
    
    public Course(int id, String nameOfCourse, List<Student> students, int numOfCredits, Vector<Course> prerequisites) {
        this.id = id;
        this.nameOfCourse = nameOfCourse;
        this.students = students;
        this.numOfCredits = numOfCredits;
        this.prerequisites = prerequisites;
    }

    
    
    
    
    
    
    
    
    
    
    
    

	public int hashCode() {
		return Objects.hash(id, nameOfCourse, numOfCredits, prerequisites, students);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(nameOfCourse, other.nameOfCourse);
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

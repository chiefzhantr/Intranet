package Main;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

import Employees.Teacher;
import System.UniSystem;

public class Course implements Serializable{
    private int id;
    private String nameOfCourse;
    public List<Student> students;
    private int numOfCredits;
    private Vector<Course> prerequisites;
    private Faculty faculty;
    private CourseType courseType;
    public int capacity;
    
    {
    	this.students = new Vector<Student>();
    }
    
    public Course() {
    	
    }
    
    public Course(int id) {
    	this.id = id;
    }
    
	public Course(String nameOfCourse) {
    	this.nameOfCourse = nameOfCourse;
    }
    
    public Course(int id, String nameOfCourse, int numOfCredits, Vector<Course> prerequisites, Faculty faculty, CourseType courseType, int capacity) {
        this.id = id;
        this.nameOfCourse = nameOfCourse;
        this.capacity = capacity;
        this.numOfCredits = numOfCredits;
        this.prerequisites = prerequisites;
        this.faculty = faculty;
        this.courseType = courseType;
    }

    
    
    public static Vector<Course> getCourseOf(Faculty faculty, Student student) {
		Vector<Course> availableCourses = new Vector<Course>();
		Collection<Course> courses = UniSystem.db.courses.values();
		
		for(Course course : courses) {
			if( (course.faculty == faculty || course.courseType != CourseType.MAJOR)) {
				for(int i = 0;i <= student.getSemester();i++) {
					if(student.takenCourses.size() != 0 && !student.takenCourses.elementAt(i).contains(course)) {
						if(course.prerequisites == null) {
							availableCourses.add(course);
							System.out.println("null pre");
						}
						else {
							boolean ok = true;
							System.out.println("not null pre");
							for(Course course2 : course.prerequisites) {
								if(!student.takenCourses.elementAt(i).contains(course2)) {
									ok = false;
								}
							}
							if(ok) {
								availableCourses.add(course);
							} 
						}
					}
					else if(student.takenCourses.size() == 0){
						if(course.prerequisites == null) {
							availableCourses.add(course);
//							System.out.println("null pre");
						}
						else {
							boolean ok = true;
//							System.out.println("not null pre");
//							System.out.println(course);
							for(Course course2 : course.prerequisites) {
								if(student.takenCourses.isEmpty()) {
									ok = false;
									break;
								}
								if(!student.takenCourses.elementAt(i).contains(course2)) {
									ok = false;
								}
							}
							if(ok) {
								availableCourses.add(course);
							} 
						}
					}
				}
			}
		}
		
		return availableCourses;
	}
    
    public static void showCourses(Vector<Course> courses) {
		System.out.println("Courses: ");
		int i = 0;
		for(Course course : courses) {
			System.out.println(i+")" + course);
			i++;
		}
	}
	
	public static void showAllCourses() {
		Collection<Course> courses = UniSystem.db.courses.values();
		for(Course course : courses) {
			System.out.println(course);
		}
	}
    
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return this.id == other.id;
	}
    
	public String toString() {
		return "Course: id = " + id + ", Faculty = "+ faculty +", " + nameOfCourse + ", costs " + numOfCredits + " credits"  
				 + ", prerequisites = " + prerequisites + ", capacity = " + capacity;
	}
    
    
    
    
    
    

	public int hashCode() {
		return Objects.hash(id);
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

	public Faculty getFaculty() {
		return faculty;
	}

	
	
	
}
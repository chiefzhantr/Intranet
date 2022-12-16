package Employees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import Interfaces.MenuAction;
import Main.Course;

public class Teacher extends Employee {
	
    private Vector<Course> courses;
    private TeacherType type;

    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private int option;
    
    private MenuAction[] menu = new MenuAction[] {
            new MenuAction() { public void action() { openAttendance(); } public String actionName() { return "Open Attendance";}},
            new MenuAction() { public void action() { manageCourseFiles(); } public String actionName() { return "Manage Course Files";}},
            new MenuAction() { public void action() { generateReport(); } public String actionName() { return "Generate Report";} },
            new MenuAction() { public void action() { viewStudents(); } public String actionName() { return "View Students";} },
            new MenuAction() { public void action() { logout(); } public String actionName() { return "Logout";} },
        };
    
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

    

    

    

    public void generateReport() {
    }

    
    public void manageCourseFiles() {
    }
    public void addFile() {
    }
    public void removeFile() {
    }
    
    
    public void viewStudents() {
    }
    public void searchStudent() {
    }
    public void viewStudentInfo() {
    }
    
    
    public void openAttendance() {
    }
    public void startAttendance() {
    }
    public void doManualAttendance() {
    }
    
    public void viewMenu() {
    	System.out.println("Choose option: ");
    	for(int i = 0;i < menu.length;i++) {
    		System.out.println(i+1+") " + menu[i].actionName());
    	}
    	try {
    		while(true) {
    			option = bf.read() - 49;
    			if(option >= 0 && option < menu.length) break;
    			else System.out.println("Wrong Data");
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	menu[option].action();
    }
    
}

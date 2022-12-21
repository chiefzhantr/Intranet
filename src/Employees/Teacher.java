package Employees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Interfaces.MenuAction;
import Main.Course;
import Main.Faculty;
import Main.Mark;
import Main.MarkType;
import Main.Student;
import Main.User;
import System.UniSystem;

public class Teacher extends Employee {
	
    private Vector<Course> courses;
    private TeacherType type;
    private Faculty faculty;
    
    private int option;
    
    private MenuAction[] menu = new MenuAction[] {
    		new MenuAction() { public void action() { putMarks(); } public String actionName() { return "Put Marks";}},
            new MenuAction() { public void action() { openAttendance(); } public String actionName() { return "Open Attendance";}},
            new MenuAction() { public void action() { manageCourseFiles(); } public String actionName() { return "Manage Course Files";}},
            new MenuAction() { public void action() { generateReport(); } public String actionName() { return "Generate Report";} },
            new MenuAction() { public void action() { viewStudents(); } public String actionName() { return "View Students";} },
            new MenuAction() { public void action() { openChat(); } public String actionName() { return "Open Chat";}},
	        new MenuAction() { public void action() { changePassword() ; } public String actionName() { return "Change password";} },
	        new MenuAction() { public void action() { logout() ; } public String actionName() { return "Logout";} },
    };
	
    
    {
    	courses = new Vector<Course>();
    }
    
    public Teacher() {
    	super();
    }
    
    public Teacher(int id) {
    	this.setId(id);
    }
    
    public Teacher(int id, String login, String password, String name, double salary, Date hireDate, TeacherType type, Faculty faculty) {
        super(id, login, password, name, salary, hireDate);
        this.type = type;
        this.faculty = faculty;
    }
    
    public Teacher(Employee employee, Faculty faculty) {
    	super(employee);
    	this.type = TeacherType.PROFESSOR;
    	this.faculty = faculty;
    }
    
    public Vector<Course> getCourses() {
        return courses;
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public TeacherType getType() {
        return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    

    
	public void putMarks() {
    	System.out.println("OK, type id of discipline you want to open the journal");
    	Course.showCourses(courses);
    	int id = Integer.parseInt(scan());
    	if(!courses.contains(new Course(id))) {
    		System.out.println("Please enter the name of the course correct");
    		putMarks();
    		return;
    	}
    	System.out.println("OK, what is the student's id");
    	Course course = new Course(id);
    	int studentId;
    	while(true) {
    		studentId = Integer.parseInt(scan());
	    	if(UniSystem.db.students.contains(new Student(studentId))) break;
    	}
//    	System.out.println("OK, what is the attestation you want to put(1 - first att, 2 - second att, 0 - final) and  score you wanna give him and ");
//		int attestation = Integer.parseInt(scan());
//		while(attestation < 0 || attestation > 2) {
//			System.out.println("Wrong attestation");
//			attestation = Integer.parseInt(scan());
//		};
//		double score = Double.parseDouble(scan());
//		while( ((score < 0 || score > 30) && (attestation != 0)) || ( (score < 0 || score > 40) && attestation == 0)) {
//			System.out.println("Wrong score");
//			score = Double.parseDouble(scan());
//		};
//		
//		Mark mark = student.marks.get(course);
//		mark.putMark(score, Mark.attestations.elementAt(attestation));
//		student.marks.put(course,mark);
//		viewMenu();
//		return;
    	
//    	for(Course course : courses) {
//    		if(course.equals(new Course(id))) {
//				Vector<Student> students = new Vector<Student>(); 
////				System.out.println((Vector<Student>)UniSystem.db.getStudents().stream().filter(s -> s.getTakingCourses().contains(course)).collect(Collectors.toList()));
//    	    	for(Student student : UniSystem.db.getStudents()) {
//    	    		if(student.getTakingCourses().contains(course)) students.add(student);
//    	    	}
//    			
//				for(Student student : students) {
//    	    		if(student.getId() == studentId) {
//    	    			
//    	    		}
//    	    	}
//    	    	
//    		}
//    	}
    	
    	
    	
    }
    

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(menu);
		result = prime * result + Objects.hash(courses, option, type);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return this.getId() == other.getId();
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
    	int option;
    	System.out.println("\nChoose option: ");
    	for(int i = 0;i < menu.length;i++) {
    		System.out.println(i+1+") " + menu[i].actionName());
    	}
    	option = Integer.parseInt(scan())-1;
    	if(!(option >= 0 && option < menu.length)) {
    		System.out.println("Wrong Data");
    		viewMenu();
    	}
    	menu[option].action();
    }

	public Faculty getFaculty() {
		return faculty;
	}
    
}

//p_shamoi@kbtu.kz
//pakita
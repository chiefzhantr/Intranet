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

    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private int option;
    
    private MenuAction[] menu = new MenuAction[] {
    		new MenuAction() { public void action() { putMarks(); } public String actionName() { return "Put Marks";}},
            new MenuAction() { public void action() { openAttendance(); } public String actionName() { return "Open Attendance";}},
            new MenuAction() { public void action() { manageCourseFiles(); } public String actionName() { return "Manage Course Files";}},
            new MenuAction() { public void action() { generateReport(); } public String actionName() { return "Generate Report";} },
            new MenuAction() { public void action() { viewStudents(); } public String actionName() { return "View Students";} },
            new MenuAction() { public void action() { logout(); } public String actionName() { return "Logout";} },
    };
    {
    	courses = new Vector<Course>();
    	courses.add(new Course("OOP"));
    }
    public Teacher() {
    	super();
    }
    
    public Teacher(int id, String login, String password, String name, double salary, Date hireDate, Vector<Course> courses, TeacherType type) {
        super(id, login, password, name, salary, hireDate);
        this.courses = courses;
        this.type = type;
    }
    
    public Teacher(Employee employee) {
    	super(employee);
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

    

    
	public void putMarks() {
    	System.out.println("OK, for which discipline do you want to see the journal");
    	String name = scan();
    	if(!courses.contains(new Course(name))) {
    		System.out.println("Please enter the name of the course correct");
    		putMarks();
    		return;
    	}
    	System.out.println("OK, what is the student's id");
    	int studentId = Integer.parseInt(scan());
    	for(Course course : courses) {
    		if(course.equals(new Course(name))) {
				Vector<Student> students = new Vector<Student>(); 
//				System.out.println((Vector<Student>)UniSystem.db.getStudents().stream().filter(s -> s.getTakingCourses().contains(course)).collect(Collectors.toList()));
    	    	for(Student student : UniSystem.db.getStudents()) {
    	    		if(student.getTakingCourses().contains(course)) students.add(student);
    	    	}
    			
				for(Student student : students) {
    	    		if(student.getId() == studentId) {
    	    			System.out.println("OK, what is the attestation you want to put(1 - first att, 2 - second att, 0 - final) and  score you wanna give him and ");
    	    			int attestation = Integer.parseInt(scan());
    	    			while(attestation < 0 || attestation > 2) {
    	    				System.out.println("Wrong attestation");
    	    				attestation = Integer.parseInt(scan());
    	    			};
    	    			double score = Double.parseDouble(scan());
    	    			while( ((score < 0 || score > 30) && (attestation != 0)) || ( (score < 0 || score > 40) && attestation == 0)) {
    	    				System.out.println("Wrong score");
    	    				score = Double.parseDouble(scan());
    	    			};
    	    			
    	    			Mark mark = student.marks.get(course);
    	    			mark.putMark(score, Mark.attestations.elementAt(attestation));
    	    			student.marks.put(course,mark);
//    	    			System.out.println(student.getName());
//    	    			System.out.println(student.marks.get(course));
    	    			viewMenu();
    	    			return;
    	    		}
    	    	}
    	    	
    		}
    	}
    	
    	
    	
    }
    

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(menu);
		result = prime * result + Objects.hash(bf, courses, option, type);
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
		return Objects.equals(bf, other.bf) && Objects.equals(courses, other.courses) && Arrays.equals(menu, other.menu)
				&& option == other.option && type == other.type;
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
    	System.out.println("Choose option: ");
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
    
}

//p_shamoi@kbtu.kz
//pakita

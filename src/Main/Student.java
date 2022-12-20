package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.lang.reflect.Method;

import Employees.LibrarySubscription;
import Interfaces.MenuAction;
import System.UniSystem;

public class Student extends User {
    private Faculty faculty;
    private Date yearOfPostuplenye;
    private double feeUchebny;
    private double gpa;
    private Vector<Course> takingCourses = new Vector<Course>();;
    public HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
    private Vector<Book> books;
    private Vector<Book> takenBooks;
    private List<LibrarySubscription> librarySubscriptions;
    
    private MenuAction[] menu = new MenuAction[] {
    	new MenuAction() { public void action() { viewMarks(); } public String actionName() { return "View Marks";}},	
        new MenuAction() { public void action() { viewCourses(); } public String actionName() { return "View Courses";}},
        new MenuAction() { public void action() { viewOrganizations(); } public String actionName() { return "View Organizations";}},
        new MenuAction() { public void action() { viewAttendance(); } public String actionName() { return "View Attendance";} },
        new MenuAction() { public void action() { viewTranscript(); } public String actionName() { return "View Transcript";} },
        new MenuAction() { public void action() { rateTeachers(); } public String actionName() { return "Rate Teachers";} },
        new MenuAction() { public void action() { openLibrary(); } public String actionName() { return "Open Library";} },
        new MenuAction() { public void action() { changePassword() ; } public String actionName() { return "Change password";} },
        new MenuAction() { public void action() { logout(); } public String actionName() { return "Logout";} },
    };
    
    {	
//    	takingCourses.add(new Course("OOP"));
//    	marks.put(takingCourses.firstElement(), new Mark());
//    	marks.get(takingCourses.firstElement()).putMark(12, Mark.attestations.elementAt(0));
    }
    public Student() {
    	
    }
    
    public Student(int id, String name) {
    	this.setId(id);
    	this.setName(name);
    }
    
    public Student(int id, String login, String password, String name, Faculty faculty) {
        super(id, login, password, name);
        this.faculty = faculty;
    }
    
    public Student(User user, Faculty faculty) {
    	super(user);
    	this.faculty = faculty;
    }
    
    //operations
    public void viewMarks() {
    	System.out.println("OK, for which discipline do you want to see the journal");
    	String name = scan();
    	if(!takingCourses.contains(new Course(name))) {
    		System.out.println("Please enter the name of the course correct");
    		viewMarks();
    		return;
    	}
    	for(Course course : takingCourses) {
    		if(course.equals(new Course(name))) System.out.println(marks.get(course));
    	}
    	viewMenu();
    }

    
    
    public void viewTranscript() {
    	
    }
    public void downloadTranscript() {
    	
    }

    
    public void viewOrganizations() {
    	
    }

    
    public void rateTeachers() {
    	
    }


    public void viewAttendance() {
    	
    }

    public void signAttendance() {
    	
    }

    
    
    public void openOrganizations() {
    	
    }

    public void joinOrganization() {
    }

    public void quitOrganization() {
    }

    
    public void viewCourses() {
    	System.out.println("Hello");
    	viewMenu();
    }
    public void viewCourseInfo() {
    	
    }
    public void registerForCourse() {
    
    }
    
    
    public void openLibrary() {
    	
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //get,set
    public HashMap<Course, Mark> getMarks() {
    	return marks;
    }
    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    public Date getYearOfPostuplenye() {
        return yearOfPostuplenye;
    }
    public void setYearOfPostuplenye(Date yearOfPostuplenye) {
        this.yearOfPostuplenye = yearOfPostuplenye;
    }
    public double getFeeUchebny() {
        return feeUchebny;
    }
    public void setFeeUchebny(double feeUchebny) {
        this.feeUchebny = feeUchebny;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public Vector<Course> getTakingCourses() {
        return takingCourses;
    }
    public void setTakingCourses(Vector<Course> takingCourses) {
        this.takingCourses = takingCourses;
    }
    public Vector<Book> getBooks() {
        return books;
    }
    public void setBooks(Vector<Book> books) {
        this.books = books;
    }
    public Vector<Book> getTakenBooks() {
        return takenBooks;
    }
    public void setTakenBooks(Vector<Book> takenBooks) {
        this.takenBooks = takenBooks;
    }
    public List<LibrarySubscription> getLibrarySubscriptions() {
        return librarySubscriptions;
    }
    public void setLibrarySubscriptions(List<LibrarySubscription> librarySubscriptions) {
        this.librarySubscriptions = librarySubscriptions;
    }

	@Override
	public String toString() {
		return "Student:" + this.getId() + " - " + this.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(menu);
		result = prime * result + Objects.hash(books, faculty, feeUchebny, gpa, librarySubscriptions, marks,
				takenBooks, takingCourses, yearOfPostuplenye);
		return result;
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}
 }

//z_svanov@kbtu.kz
//zhantore2004
//
//p_shamoi@kbtu.kz
//pakita

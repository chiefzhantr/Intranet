package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.lang.reflect.Method;

import Employees.LibrarySubscription;
import Interfaces.MenuAction;
import Main.Book;
import Main.Course;
import Main.Faculty;
import Main.Journal;
import Main.Mark;
import Main.UniSystem;
import Main.User;

public class Student extends User{
    private Faculty faculty;
    private Date yearOfPostuplenye;
    private double feeUchebny;
    private double gpa;
    private Vector<Course> takingCourses;
    private HashMap marks = new HashMap<Course, Journal>();
    private Vector<Book> books;
    private Vector<Book> takenBooks;
    private List<LibrarySubscription> librarySubscriptions;

    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private int option;
    
    private MenuAction[] menu = new MenuAction[] {
        new MenuAction() { public void action() { viewCourses(); } public String actionName() { return "View Courses";}},
        new MenuAction() { public void action() { viewOrganizations(); } public String actionName() { return "View Organizations";}},
        new MenuAction() { public void action() { viewAttendance(); } public String actionName() { return "View Attendance";} },
        new MenuAction() { public void action() { viewTranscript(); } public String actionName() { return "viewTranscript";} },
        new MenuAction() { public void action() { rateTeachers(); } public String actionName() { return "Rate Teachers";} },
        new MenuAction() { public void action() { openLibrary(); } public String actionName() { return "Open Library";} },
        new MenuAction() { public void action() { logout(); } public String actionName() { return "Logout";} },
    };
    
    public Student() {
    	
    }
    
    public Student(int id, String login, String password, String name, Faculty faculty, Date yearOfPostuplenye, double feeUchebny, double gpa, Vector<Course> takingCourses, Vector<Book> books, Vector<Book> takenBooks, List<LibrarySubscription> librarySubscriptions) {
        super(id, login, password, name);
        this.faculty = faculty;
        this.yearOfPostuplenye = yearOfPostuplenye;
        this.feeUchebny = feeUchebny;
        this.gpa = gpa;
        this.takingCourses = takingCourses;
        this.books = books;
        this.takenBooks = takenBooks;
        this.librarySubscriptions = librarySubscriptions;
    }
    
    //operations
    public void openJournal() {
    	System.out.println("OK, for which discipline do you want to see the journal");
    	String discipline = scan();
//    	if(UniSystem.db)
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
    

 }

//z_svanov@kbtu.kz
//zhantore2004

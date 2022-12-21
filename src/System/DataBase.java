package System;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Employees.Manager;
import Employees.Teacher;
import Employees.TeacherType;
import Main.Course;
import Main.CourseType;
import Main.Faculty;
import Main.Mail;
import Main.Message;
import Main.New;
import Main.Student;
import Main.User;

public class DataBase implements Serializable {
	
	private static final long serialVersionUID = -1175920159699221042L;

	private static DataBase db;
	
	public Vector<New> news;
	public Vector<User> users;
	public HashMap<String, User> userByLogin;
	public HashMap<String, String> passwordByLogin;
	public Vector<Student> students;
	public Vector<Teacher> teachers;
	public HashMap<Integer, Course> courses;
	public HashMap<Integer, Mail > mails;
	public Stack<User> requests;
	
	public boolean registrationAvailable;
	
	transient public static Vector<Faculty> faculties = new Vector<Faculty>();
	
	static {
		faculties.add(Faculty.FIT);
		faculties.add(Faculty.BS);
		faculties.add(Faculty.ISE);
		faculties.add(Faculty.OMA);
		faculties.add(Faculty.SCM);
		faculties.add(Faculty.OR);
	}
	
	{
		requests = new Stack<User>();
		news = new Vector<New>();
		users = new Vector<User>();
		students = new Vector<Student>();
		teachers = new Vector<Teacher>();
		courses = new HashMap<>();
		userByLogin = new HashMap<>();
		passwordByLogin = new HashMap<>();;
		mails = new HashMap<Integer, Mail>();
		
	}
	
	private DataBase() {
		
	}
	
	public static DataBase getDataBase() {
		if(db == null) {
			db =  new DataBase();
		}
		return db;
	}
	
	public boolean isRegOpen() {
		return registrationAvailable;
	}
	
	public void initialize() {
		passwordByLogin.put("z_svanov@kbtu.kz","zhantore2004");
		passwordByLogin.put("p_shamoi@kbtu.kz","pakita");
		passwordByLogin.put("manager@kbtu.kz","manager");
		passwordByLogin.put("admin@kbtu.kz","admin");
		
		userByLogin.put("p_shamoi@kbtu.kz", new Teacher());
		userByLogin.put("manager@kbtu.kz", new Manager());
		userByLogin.put("admin@kbtu.kz", new Admin());
		
		Student stud = new Student(19,"Zhantore");
		userByLogin.put("z_svanov@kbtu.kz", stud);
		students.add(stud);
		Admin newAdmin = new Admin(321, "newadmin", "newadmin", "serikbol", 9999, new Date());
		Manager newManager = new Manager(111, "newmanager", "newmanager", "madina", 10000, new Date(), Faculty.FIT);
		Teacher teacher = new Teacher(222, "teacher", "teacher", "dina", 11000, new Date(), TeacherType.PROFESSOR,Faculty.FIT);
		users.add(newAdmin);
		users.add(newManager);
		users.add(teacher);
		teachers.add(teacher);
		passwordByLogin.put(newAdmin.getLogin(),newAdmin.getPassword());
		passwordByLogin.put(newManager.getLogin(),newManager.getPassword());
		userByLogin.put(newAdmin.getLogin(), newAdmin);
		userByLogin.put(newManager.getLogin(), newManager);
		
		
//		courses.put(1, new Course());
//		courses.put(1, new Course());
//		courses.put(1, new Course());
//		courses.put(1, new Course());
//		courses.put(1, new Course());
//		courses.put(1, new Course());
//		courses.put(1, new Course());
		
		news.add(new New("BAKHERDIN PRODAL MED!!", new Date()));
		news.add(new New("HAPPY NEW YEAR!!", new Date()));
//		System.out.println("123");
//		courses = new HashMap<>();
		
//		System.out.println(courses);
		Student zhantore = new Student(9,"zhantore","zhantore","Zhantore",Faculty.FIT);
		users.add(zhantore);
		userByLogin.put(zhantore.getLogin(), zhantore);
		students.add(zhantore);
		passwordByLogin.put(stud.getLogin(), stud.getPassword());
		Vector<Course> adspre = new Vector<Course>();
		adspre.add(new Course(4, "Discrete Math",4,null,Faculty.FIT, CourseType.MAJOR, 300));
		adspre.add(new Course(5, "PP1",5,null,Faculty.FIT, CourseType.MAJOR, 600));

		Vector<Course> ooppre = new Vector<Course>();
		ooppre.add(new Course(6, "PP2",5,null,Faculty.FIT, CourseType.MAJOR, 600)); 

		Vector<Course> phypre = new Vector<Course>();
		phypre.add(new Course(9, "Physics 1",4,null,Faculty.ISE, CourseType.REQUIRED, 200));

		Vector<Course> phypre2 = new Vector<Course>();
		phypre2.add(new Course(10, "Physics 2",4,phypre,Faculty.ISE, CourseType.MAJOR, 100));

		courses.put(1, new Course(1, "ADS",6,adspre,Faculty.FIT, CourseType.MAJOR, 300));
		courses.put(2, new Course(2, "OOP",6,null,Faculty.FIT, CourseType.MAJOR, 300));
		courses.put(3, new Course(3, "History",3,null,Faculty.BS, CourseType.REQUIRED, 100));
		courses.put(4, new Course(4, "Discrete Math",4,null,Faculty.SCM, CourseType.REQUIRED, 300));
		courses.put(5, new Course(5, "PP1",5,null,Faculty.FIT, CourseType.MAJOR, 600));
		courses.put(6, new Course(6, "PP2",5,null,Faculty.FIT, CourseType.MAJOR, 600));
		courses.put(7, new Course(7, "Olympiad Math",3,null,Faculty.SCM, CourseType.MINOR, 50));
		courses.put(8, new Course(8, "Psychology",2,null,Faculty.OMA, CourseType.MINOR, 70));
		courses.put(9, new Course(9, "Physics 1",4,null,Faculty.ISE, CourseType.REQUIRED, 200));
		courses.put(10, new Course(10, "Physics 2",4,phypre,Faculty.ISE, CourseType.MAJOR, 100));
		courses.put(11, new Course(11, "Physics 3",4,phypre2,Faculty.ISE, CourseType.MINOR, 100));
	}

	public Vector<New> getNews() {
		return news;
	}

	public Vector<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Vector<Student> students) {
		this.students = students;
	}
	
	public String toString() {
		return "DataBase: users " + users + ", news" + news + ", teachers " + teachers + ", students " + students + '\n' + courses; 
	}
	
//	public String toString() {
//		return "DataBase " + courses; 
//	}
	
	
	
	
	
}

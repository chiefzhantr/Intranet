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
import Main.Course;
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
	private Vector<Student> students;
	private Vector<Teacher> teachers;
	transient private Vector<Course> courses;
	public HashMap<Integer, Mail > mails;
	public Stack<User> requests;
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
	
	public Vector<New> getNews() {
		return news;
	}

	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public Vector<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Vector<Student> students) {
		this.students = students;
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
		users.add(newAdmin);
		passwordByLogin.put(newAdmin.getLogin(),newAdmin.getPassword());
		userByLogin.put(newAdmin.getLogin(), newAdmin);
		
		news.add(new New("BAKHERDIN PRODAL MED!!", new Date()));
	}


	public String toString() {
		return "DataBase " + users + ", news" + news; 
	}
	
	
	
	
	
	
}

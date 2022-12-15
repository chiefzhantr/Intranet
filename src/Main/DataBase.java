package Main;
import java.util.*;

import Students.Student;

public class DataBase {
	
	public Vector<User> users;
	public HashMap<String, User> userByLogin;
	public HashMap<String, String> passwordByLogin;
	public Vector<New> news;
	public Vector<Student> students;
	public Map<Integer,Vector<Message> > messages;
	
	{
		
		news = new Vector<New>();
		users = new Vector<User>();
		userByLogin = new HashMap<>();
		passwordByLogin = new HashMap<>();
		students = new Vector<Student>();
		passwordByLogin.put("z_svanov@kbtu.kz","zhantore2004");
		userByLogin.put("z_svanov@kbtu.kz", new Student());
		news.add(new New("BAKHERDIN PRODAL MED!!", new Date()));
	}
	
	public Vector<New> getNews() {
		return news;
	}
}

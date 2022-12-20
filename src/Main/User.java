package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import Interfaces.MenuAction;
import System.UniSystem;

public class User implements Serializable,Cloneable{
    
	private int id;
    private String login;
    private String password;
    private String name;
    
    public User() {
    	
    }
    
    public User(int id) {
    	this.id = id;
    }
    	
    public User(int id, String login) {
    	this(id);
    	this.login = login;
    }    
    
	public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }
	
	public User(User user) {
    	this(user.id,user.login,user.password,user.name);
    }
    
    public void login() {
    	System.out.println("\nHello, type your login and password");
    	int tries = 6;
		while(true) { 
			if(tries == 0) System.out.println("Goodbye nedo haker or slowpoke");
			String login = scan();
			String password = scan();
			if(!password.equals(null) && password.equals(UniSystem.db.passwordByLogin.get(login))) {
				UniSystem.currentUser =  UniSystem.db.userByLogin.get(login);
				break;
			}
//			else if(UniSystem.db.passwordByLogin.get(login).equals(null)) {
//				System.out.println("There is no such login");
//			}
			else System.out.println("Please, check your login or password");
			tries--;
			System.out.println("You have " + tries + " tries");
		}
		viewNews();
    }
    
    public void logout() {
    	UniSystem.currentUser = null;
    }
    
    public void viewNews(){
    	System.out.println(UniSystem.db.getNews());
    	System.out.println("Choose option: \n1) Go to menu");
		while(true) { 
			String option = scan();
			if(option.equals("1")) {break;}
			else System.out.println("Wrong data");
		}
		UniSystem.currentUser.viewMenu();
    };
    
    public void changePassword() {
    	System.out.println("OK, type your old password");
    	
    	while(true) {
    		String oldPassword = scan();
//    		System.out.println(UniSystem.db.passwordByLogin.get(login));
//    		System.out.println(getLogin);
    		System.out.println(oldPassword);
    		if(oldPassword.equals(UniSystem.db.passwordByLogin.get(this.getLogin()))) {
    			break;
    		} else {
    			System.out.println("Please enter the correct password");
    		}
    	}
    	System.out.println("OK, type your new password");
    	String newPassword = scan();
    	UniSystem.db.passwordByLogin.put(this.login, newPassword);
    	this.password = newPassword;
    }
    
    public void viewMenu() {
    	
    }
    
    protected void addToDataBase() {
    	
    };
    
    public String scan() {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	try {
    		String word = bf.readLine();
    		return word;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "";
    }
    
    public Date scanDate() {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	while(true) {
    		Date date;
			try {
				date = (Date) formatter.parse(scan());
				return date;
			} catch (ParseException e) {
				System.out.println("please, enter the date by the example");
			}
    	}
    }
    
    
    public String toString() {
//		return "User [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", bf=" + bf + "]";
    	return "user with id = " + id;
	}
	public Object clone() throws CloneNotSupportedException {
		 return super.clone();
	}
	public int hashCode() {
		return Objects.hash(id, login, name, password);
	}
	public boolean equals(Object obj) {
		User other = (User) obj;
		return this.id == other.id || other.login.equals(this.login);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    
	
    
	
}

//z_svanov@kbtu.kz
//zhantore2004
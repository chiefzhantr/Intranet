package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Interfaces.MenuAction;

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    
    public User() {
    	
    }
    	
    public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
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

    
    
    public void login() {
    	System.out.println("Hello, type your login and password");
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
    
    public void viewMenu() {
    	
    }
    
    public String scan() {
    	try {
    		String word = bf.readLine();
    		return word;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "";
    }
    
}

//z_svanov@kbtu.kz
//zhantore2004
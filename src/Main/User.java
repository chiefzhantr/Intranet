package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private String option;
    
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

    
    public void login() throws IOException {
    	
    	System.out.println("Hello, type your login and password");
		while(true) { 
			try {
				String login = bf.readLine();
				String password = bf.readLine();
				if(!password.equals(null) && password.equals(UniSystem.db.passwordByLogin.get(login))) {
					UniSystem.currentUser =  UniSystem.db.userByLogin.get(login);
					break;
				}
				
				else if(password.equals(null)) {
					System.out.println("There is no such login");
				}
				
				else System.out.println("Please, check your login or password");
			} catch (IOException e) {
				System.out.println("123");
			}
		}
		viewNews();
    }
    
    public void logout() {
    	UniSystem.currentUser = null;
    }
    
    public void viewNews() throws IOException {
    	System.out.println(UniSystem.db.getNews());
    	System.out.println("Choose option: \n1) Go to menu");
    	option = bf.readLine();
    	if(option.equals("1")) {
    		UniSystem.currentUser.viewMenu();
    	}
    };
    
    public void viewMenu() throws IOException {
    	
    }
    
}

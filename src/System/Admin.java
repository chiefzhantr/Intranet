package System;

import java.util.Stack;
import java.util.Arrays;
import java.util.Date;
import Employees.Employee;
import Interfaces.MenuAction;
import Main.Student;
import Main.User;

public class Admin extends Employee {
	
	private MenuAction[] menu = new MenuAction[] {
	        new MenuAction() { public void action() { addUser(); } public String actionName() { return "Add User";}},
	        new MenuAction() { public void action() { removeUser(); } public String actionName() { return "Remove User";}},
	        new MenuAction() { public void action() { updateUser(); } public String actionName() { return "Update User";} },
	        new MenuAction() { public void action() { showLogs(); } public String actionName() { return "Show Logs";} },
	        new MenuAction() { public void action() { changePassword() ; } public String actionName() { return "Change password";} },
	        new MenuAction() { public void action() { logout(); } public String actionName() { return "Logout";} },
    };
	
	public Admin() {
		
	}
	
    public Admin(int id, String login, String password, String name, double salary, Date hireDate) {
        super(id, login, password, name, salary, hireDate);
    }
    
    public Admin(Employee employee) {
		super(employee);
	}
    
    public void addUser() {
    	Stack<User> requests = (Stack<User>) UniSystem.db.requests;
    	System.out.println("OK, these are requests to create new user: " + requests);
    	while(requests.size() != 0) {
    		System.out.println("OK, do you want to add this user to the system(0 - NO, 1 - YES): " + requests.peek());
    		String ans = scan();
    		if(ans.equals("1")) {
    			UniSystem.db.users.add(requests.peek());
    			UniSystem.db.passwordByLogin.put(requests.peek().getLogin(),requests.peek().getPassword());
    			UniSystem.db.userByLogin.put(requests.peek().getLogin(), requests.peek());
    			if(requests.peek().getClass() == (new Student()).getClass()) UniSystem.db.users.add(requests.peek());
    		}
    		requests.pop();
    	}
    	System.out.println(UniSystem.db.users.size());
    	System.out.println(UniSystem.db.users);
    }
    
    public void removeUser() {
    	
    }
    
    public void updateUser() {
    	
    }
    
    public void showLogs() {
    	
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

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(menu);
		return result;
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
    
    
}

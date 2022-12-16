package Employees;

import Interfaces.MenuAction;

public class Admin extends Employee {
	
	private MenuAction[] menu = new MenuAction[] {
	        new MenuAction() { public void action() { addUser(); } public String actionName() { return "Add User";}},
	        new MenuAction() { public void action() { removeUser(); } public String actionName() { return "Remove User";}},
	        new MenuAction() { public void action() { updateUser(); } public String actionName() { return "Update User";} },
	        new MenuAction() { public void action() { showLogs(); } public String actionName() { return "Show Logs";} },
    };
	
    public Admin(int id, String login, String password, String name, double salary, Date hireDate) {
        super(id, login, password, name, salary, hireDate);
    }
    
    public void addUser() {
    	
    }

    public void removeUser() {
    	
    }

    public void updateUser() {
    	
    }

    public void showLogs() {
    	
    }
}

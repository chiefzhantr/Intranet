package Employees;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import Main.Mail;
import Main.Message;
import Main.User;
import System.UniSystem;

public class Employee extends User {
    private double salary;
    private java.util.Date hireDate;
    
    public Employee() {
    	
    }
    
    public Employee(int id, String login, String password, String name, double salary, Date hireDate) {
        super(id, login, password, name);
        this.salary = salary;
        this.hireDate = hireDate;
        UniSystem.db.mails.put(getId(), new Mail());
    }
    
    public Employee(User user, double salary, Date hireDate) {
    	super(user);
    	this.salary = salary;
        this.hireDate = hireDate;
        UniSystem.db.mails.put(getId(), new Mail());
    }
    
    public Employee(Employee employee) {
    	super(employee.getId(),employee.getLogin(),employee.getPassword(),employee.getName());
    	this.salary = employee.salary;
    	this.hireDate = employee.hireDate;
    }
    
    public void openChat() {
    	System.out.println("OK, type what you want to do:\n1) Send Message\n2) Check Messages");
    	String option = scan();
    	if(option.equals("1")) {
    		sendMessage();
    	}
    	else if(option.equals("2")) {
    		checkMessages();
    	}
    	else {
    		System.out.println("Congrats, you missed");
    	}
    }

    public void sendMessage() {
    	System.out.println("Write what you want to report");
    	String letter =  scan();
    	System.out.println("OK, write the id of the employee");
    	int addresat;
    	List<User> employees = UniSystem.db.users.stream().filter(u -> u instanceof Employee).collect(Collectors.toList());
    	while(true) {
    		addresat = Integer.parseInt(scan());
    		if(employees.contains(new User(addresat)))
    			break;
    		else 
    			System.out.println("No such user");
    	}
    	Date date = new Date();
    	Message newMessage = new Message(letter,date,addresat,getId());
    	UniSystem.db.mails.get(addresat).messages.add(newMessage); 
    	System.out.println("Success!");
    	viewMenu();
    }
    
    public void checkMessages() {
    	System.out.println("OK, here you go, it is your messages");
    	Vector<Message> messages = UniSystem.db.mails.get(this.getId()).messages;
    	viewMenu();
    }
    
    public void viewNews() {
    	
    }
    
    public void viewMenu() {
    	
    }
    
    
    
    
    
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hireDate, salary);
		return result;
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
	
	
	
	
	public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    
}

package Employees;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

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
    }
    
    public Employee(User user, double salary, Date hireDate) {
    	super(user);
    	this.salary = salary;
        this.hireDate = hireDate;
    }
    
    public Employee(Employee employee) {
    	super(employee.getId(),employee.getLogin(),employee.getPassword(),employee.getName());
    	this.salary = employee.salary;
    	this.hireDate = employee.hireDate;
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

    public void openChat() {
    	
    }

    public void sendMessage() {
    	String words = "12312412";
    	int addresat = 2;
    	Date date = new Date();
    	Message newMessage = new Message(words,date,addresat);
    	UniSystem.db.messages.get(addresat).add(newMessage); 
    }

    public void checkMessages() {
    	Vector<Message> messages = UniSystem.db.messages.get(this.getId());
    	System.out.print(messages);
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
    
    
}

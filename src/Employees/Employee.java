package Employees;

import java.util.Vector;

import Main.Message;
import Main.UniSystem;
import Main.User;

public class Employee extends User {
    private double salary;
    private Date hireDate;

    public Employee(int id, String login, String password, String name, double salary, Date hireDate) {
        super(id, login, password, name);
        this.salary = salary;
        this.hireDate = hireDate;
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
    	Date date = Date.curDate();
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
}

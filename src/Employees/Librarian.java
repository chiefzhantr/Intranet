package Employees;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import Main.User;

public class Librarian extends Employee {
    private List<LibrarySubscription> subscriptions;
    
    public Librarian(int id, String login) {
    	this.setId(id);
    	this.setLogin(login);
    }
    
    public Librarian(int id, String login, String password, String name, double salary, Date hireDate, List<LibrarySubscription> subscriptions) {
        super(id, login, password, name, salary, hireDate);
        this.subscriptions = subscriptions;
    }
    
    public Librarian(Employee employee) {
    	super(employee);
    }

    public List<LibrarySubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<LibrarySubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void rentBook() {
    	 
    }

    public void returnBook() {
    	
    }

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(subscriptions);
		return result;
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}
    
}

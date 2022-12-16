package Employees;

import java.util.List;

public class Librarian extends Employee {
    private List<LibrarySubscription> subscriptions;

    public Librarian(int id, String login, String password, String name, double salary, Date hireDate, List<LibrarySubscription> subscriptions) {
        super(id, login, password, name, salary, hireDate);
        this.subscriptions = subscriptions;
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
}

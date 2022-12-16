package Employees;

public class LibrarySubscription {
    private int subscriptionId;
    private int studentId;
    

    public LibrarySubscription(int subscriptionId, int studentId) {
        this.subscriptionId = subscriptionId;
        this.studentId = studentId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

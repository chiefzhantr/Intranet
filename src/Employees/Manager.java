package Employees;

public class Manager extends Employee {
    private ManagerType typeOfManager;

    public Manager(int id, String login, String password, String name, double salary, Date hireDate, ManagerType typeOfManager) {
        super(id, login, password, name, salary, hireDate);
        this.typeOfManager = typeOfManager;
    }

    public ManagerType getTypeOfManager() {
        return typeOfManager;
    }

    public void setTypeOfManager(ManagerType typeOfManager) {
        this.typeOfManager = typeOfManager;
    }

    public void manageNews() {
    }

    public void manageRequests() {
    }

    public void viewStudents() {
    }

    public void viewTeachers() {
    }

    public void staticReport() {
    }

    public void addCourse() {
    }
}

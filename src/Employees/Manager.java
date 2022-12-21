package Employees;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import Interfaces.MenuAction;
import Main.Book;
import Main.Course;
import Main.Faculty;
import Main.Student;
import Main.User;
import System.Admin;
import System.UniSystem;

public class Manager extends Employee {
    private Faculty typeOfManager;
    
    private MenuAction[] menu = new MenuAction[] {
	        new MenuAction() { public void action() { createUser(); } public String actionName() { return "Create User";}},
	        new MenuAction() { public void action() { manageNews(); } public String actionName() { return "Manage News";}},
	        new MenuAction() { public void action() { openChat(); } public String actionName() { return "Open Chat";}},
	        new MenuAction() { public void action() { viewStudents(); } public String actionName() { return "View Students";} },
	        new MenuAction() { public void action() { viewTeachers(); } public String actionName() { return "View Teachers";} },
	        new MenuAction() { public void action() { staticReport(); } public String actionName() { return "Static Report";} },
	        new MenuAction() { public void action() { manageCourses() ; } public String actionName() { return "Manage Courses";} },
	        new MenuAction() { public void action() { changePassword() ; } public String actionName() { return "Change password";} },
	        new MenuAction() { public void action() { logout() ; } public String actionName() { return "Logout";} },
    };
    
    public Manager() {
    	
    }
    
    public Manager(int id, String login, String password, String name, double salary, Date hireDate, Faculty typeOfManager) {
        super(id, login, password, name, salary, hireDate);
        setTypeOfManager(typeOfManager);
    }
    
    public Manager(Employee employee, Faculty typeOfManager) {
    	super(employee);
    	setTypeOfManager(typeOfManager);
    }

    public Faculty getTypeOfManager() {
        return typeOfManager;
    }
    
    public void setTypeOfManager(Faculty typeOfManager) {
        this.typeOfManager = typeOfManager;
    }
    
    public User getUser() {
    	System.out.println("OK, type the id and login");
		int id;
		String login;
		while(true) {
			id = Integer.parseInt(scan());
			login = scan();
			if(!UniSystem.db.users.contains(new User(id,login)) && !UniSystem.db.requests.contains(new User(id,login))) break;
			System.out.println("user with this id or login already exists, type another");
		}
		System.out.println("OK, type the password");
		String password;
		while(true) {
			password = scan();
			if(!password.equals("")) break;;
		}
		System.out.println("OK, type the name");
		String name;
		while(true) {
			name = scan();
			if(!name.equals("")) break;;
		}
		return new User(id,login,password,name);
    }
    
    public Employee getEmployee() {
    	User user = getUser();
		double salary;
		while(true) {
			System.out.println("OK, type the salary of the employee");
			salary = Double.parseDouble(scan());
			if(salary <= 0) {
				System.out.println("Wrong data");
			}
			else break;
		}
		System.out.println("OK, type the hire date of the employee, pattern - dd/mm/yyyy, ex: 31/12/2022");
		Date hireDate = scanDate();
		return new Employee(user,salary,hireDate);
    }
    
    public void createUser() {
    	System.out.println("OK, type whom you want to create: \n1) Student\n2) Librarian\n3) Manager\n4) Teacher\n5) Admin");
    	String type = scan();
    	
    	if(type.equals("1")) {
    		User user = getUser();
    		
    		System.out.println("OK, type the faculty of the student: ");
    		for(int i = 0;i < UniSystem.db.faculties.size();i++) {
    			System.out.println(i+") " + UniSystem.db.faculties.elementAt(i));
    		}
    		Faculty faculty; 
    		while(true) {
    			int ans = Integer.parseInt(scan());
    			if(ans >= 0 && ans < UniSystem.db.faculties.size()-1) {
    				faculty = UniSystem.db.faculties.elementAt(ans);
    				if(faculty == this.typeOfManager || this.typeOfManager == Faculty.OR) {
    					UniSystem.db.requests.add(new Student(user,faculty));
    				}
    				else {
    					System.out.println("You can't create student of this faculty");
    					viewMenu();
    					return;
    				}
    				break;
    			}
    			else System.out.println("Please type correct data");
    		}
    	}
    	
    	else if(type.equals("2")) {
    		Employee emp = getEmployee();
    		UniSystem.db.requests.add(new Librarian(emp));
		}
    	
    	else if(type.equals("3")) {
    		if(this.typeOfManager == Faculty.OR) {
        		Employee employee = getEmployee();
        		
        		Faculty faculty; 
        		while(true) {
        			int ans = Integer.parseInt(scan());
        			if(ans >= 0 && ans < UniSystem.db.faculties.size()) {
        				faculty = UniSystem.db.faculties.elementAt(ans);
        				break;
        			}
        			System.out.println("Please type correct data");
        		}
        		UniSystem.db.requests.add(new Manager(employee, faculty));
    		}
    		else {
    			System.out.println("You have no permission to do this");
    			viewMenu();
    			return;
    		}
		}
    	
    	else if(type.equals("4")) {
    		Employee employee = getEmployee();
    		Faculty teacherFaculty;
    		while(true) {
    			System.out.println("OK, what's the teacher's faculty");
    			int i = 0;
    			for(Faculty faculty : UniSystem.db.faculties) {
    				System.out.println(i+") "+ faculty);
    				i++;
    			}
    			int ans = Integer.parseInt(scan());
    			if(ans >= 0 && ans < UniSystem.db.faculties.size()-1) {
    				teacherFaculty = UniSystem.db.faculties.elementAt(ans);
    				break;
    			} else {
    				System.out.println("You missed");
    			}
    		}
			UniSystem.db.requests.add(new Teacher(employee,teacherFaculty));
		}
    	
    	else if(type.equals("5")) {
    		Employee employee = getEmployee();
			UniSystem.db.requests.add(new Admin(employee));
    	}
    	
    	else {
    		System.out.println("You missed");
    		viewMenu();
    	}
    	System.out.println("OK, success");
    	viewMenu();
    }
    
    public void manageNews() {
    	
    }

    public void viewStudents() {
    }

    public void viewTeachers() {
    	
    }
    
    // репорты по тичерам, rate teachers
    public void staticReport() {
    	
    }
    
    
    //courses
    public void manageCourses() {
    	System.out.println("OK, choose option:\n1) Start course registration for the semester\n2) Assign teacher to the course \n3) Close course registration for the semester");
    	String option = scan();
    	if(option.equals("1")) {
    		System.out.println("OK, opening the registration");
    		UniSystem.db.registrationAvailable = true;
    	} else if(option.equals("2")) {
    		System.out.println("OK, type id of the teacher"); 
    		
    		int id; 
    		while(true) {
        		id = Integer.parseInt(scan());
        		if(UniSystem.db.teachers.contains(new User(id)))
        			break;
        		else 
        			System.out.println("No such user");
        	}
    		
    		Teacher teacher = UniSystem.db.teachers.elementAt((UniSystem.db.teachers.indexOf(new Teacher(id))));
    		
    		System.out.println("OK, type the id of the course you want to assign");
    		Course.showAllCourses();
    		int courseId; 
    		while(true) {
    			courseId = Integer.parseInt(scan());
    			if(courseId == -1) {
    				viewMenu();
    				return;
    			}
//    			if(UniSystem.db.courses.get(courseId) != null) {
//    				System.out.println(UniSystem.db.courses.get(courseId).getFaculty() == teacher.getFaculty());
//    				System.out.println(UniSystem.db.courses.get(courseId).getFaculty());
//    				System.out.println(teacher.getFaculty());
//    				break;
//    			}
        		if(UniSystem.db.courses.get(courseId) != null && UniSystem.db.courses.get(courseId).getFaculty() == teacher.getFaculty())
        			break;
        		else {
        			System.out.println("No such course, type -1 to quit");
        		}
        	}
    		System.out.println("Success");
    		teacher.addCourse(UniSystem.db.courses.get(courseId)); 
    		
    	} else if(option.equals("3")) {
    		System.out.println("OK, closing the registration");
    		UniSystem.db.registrationAvailable = false;
    	} else {
    		System.out.println("You missed");
    	}
    	viewMenu();
    }
	
	public New manageNews() {
try {
 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 System.out.println("[INFO] Title: ");
 String title = input.readLine();
 //TODO поменять Date на LocalDate <-> Date publishDate;
 return new New(title, LocalDate.now());
}
catch(IOException ioe) {
 System.out.println("[INFO] Error...");
} catch (IOException e) {
 throw new RuntimeException(e);
}
return null;
  }
    
    
    
    
    
    
    
    
    
    
    
    public void viewMenu() {
    	int option;
    	System.out.println("\nChoose option: ");
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

    public void changePassword() {
    	System.out.println("OK, type your old password");
    	
    	while(true) {
    		String oldPassword = scan();
//    		System.out.println(UniSystem.db.passwordByLogin.get(login));
    		System.out.println(getLogin());
    		System.out.println(oldPassword);
    		if(oldPassword.equals(UniSystem.db.passwordByLogin.get(this.getLogin()))) {
    			break;
    		} else {
    			System.out.println("Please enter the correct password");
    		}
    	}
    	System.out.println("OK, type your new password");
    	String newPassword = scan();
    	UniSystem.db.passwordByLogin.put(this.getLogin(), newPassword);
    	this.setPassword(newPassword);
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(menu);
		result = prime * result + Objects.hash(typeOfManager);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
    
}

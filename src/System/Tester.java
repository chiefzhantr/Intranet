package System;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import Employees.Employee;
import Employees.Librarian;
import Main.Student;
import Main.User;

public class Tester {
	
	public static void main(String[] args) throws IOException {
		UniSystem uni = new UniSystem(); 
		uni.run();
//		UniSystem.db.users.add(new Librarian(1,"1"));
//		List<User> employees = UniSystem.db.users.stream().filter(u -> u instanceof Employee).collect(Collectors.toList());
//		System.out.println(employees);
//		User libr = new Librarian(1,"1");
//		Student stud = new Student(1,"1");
//		stud.setName("zhantore");
//		System.out.println(stud.equals(libr));
	}
}

//z_svanov@kbtu.kz
//zhantore2004
package System;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;

import Employees.Employee;
import Employees.Librarian;
import Main.Book;
import Main.Faculty;
import Main.New;
import Main.Student;
import Main.User;

public class Tester {
	
	public static void main(String[] args) throws IOException {
		UniSystem uni = new UniSystem();
		uni.deserialize();
		uni.run();
//		System.out.println(uni.db);
//		uni.deserialize();
//		System.out.println(uni.db);
//		UniSystem.db.users.add(new Librarian(1,"1"));
//		List<User> employees = UniSystem.db.users.stream().filter(u -> u instanceof Employee).collect(Collectors.toList());

		
		
		
	}
}

//z_svanov@kbtu.kz
//zhantore2004
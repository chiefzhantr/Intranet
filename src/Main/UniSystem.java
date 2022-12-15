package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniSystem {
	public static DataBase db;
	public static User currentUser;
	
	static {
		db = new DataBase();
	}
	
	public void run() throws IOException {
		currentUser = new User();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		currentUser.login();
		run();
	}
}


//z_svanov@kbtu.kz
//zhantore2004

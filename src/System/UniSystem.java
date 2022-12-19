package System;

import Main.User;

public class UniSystem {
	public static DataBase db;
	public static User currentUser;
	
	static {
		db = DataBase.getDataBase();
		db.initialize();
	}
	
	public void run() {
		currentUser = new User();
		currentUser.login();
		run();
	}
}


//z_svanov@kbtu.kz
//zhantore2004

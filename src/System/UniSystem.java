package System;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		serialize();
		run();
	}
	
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("database.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.db);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("database.out");
			ObjectInputStream oin = new ObjectInputStream(fis);
			this.db = (DataBase) oin.readObject();
			oin.close();
			System.out.println(this.db);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


//z_svanov@kbtu.kz
//zhantore2004

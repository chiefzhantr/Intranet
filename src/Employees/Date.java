package Employees;

public class Date {
	int day;
	int month;
	int year;
	
	
	public Date() {
		
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	//not finished
	public static Date curDate() {
		return new Date();
	}
}

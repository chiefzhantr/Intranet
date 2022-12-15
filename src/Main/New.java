package Main;

import java.util.Date;

public class New {
	String title;
	Date publishDate; 
	public New() {
		
	}
	
	public New(String title, Date publishDate) {
		this.title = title;
		this.publishDate = publishDate;
	}

	public String toString() {
		return title + ", " + publishDate;
	}
	
}

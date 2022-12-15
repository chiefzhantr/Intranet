package Main;

import Employees.Date;

public class Message {
	public String words;
	public Date sentDate;
	public int addresatId;
	

	public Message() {
		
	}
	
	public Message(String words, Date sentDate, int addresatId) {
		this.words = words;
		this.addresatId = addresatId;
		this.sentDate = sentDate;
	}
	
}

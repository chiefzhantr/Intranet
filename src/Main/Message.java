package Main;


import java.util.Date;
import java.util.Vector;

public class Message {
	public String words;
	public Date sentDate;
	public int addresatId;
	public int senderId;
	
	
	public Message() {
		
	}
	
	public Message(String words, Date sentDate, int addresatId, int senderId) {
		this.words = words;
		this.addresatId = addresatId;
		this.sentDate = sentDate;
		this.senderId = senderId;
	}

	public String toString() {
		return "Message from employee with id "+ senderId + " : < " + words + " >, " + sentDate;
	}
	
	public static void printMessages(Vector<Message> messages) {
		for(Message message : messages) {
			System.out.println(message);
		}
	}
	
}

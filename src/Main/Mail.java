package Main;

import java.util.Vector;

public class Mail {
	public Vector<Message> messages;
	
	public Mail() {
		messages = new Vector<Message>();
	}

	public String toString() {
		return "Your messages = " + messages;
	}
	
	
}

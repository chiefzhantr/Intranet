package Main;

import java.io.Serializable;
import java.util.Vector;

public class Mail implements Serializable {
	public Vector<Message> messages;
	
	public Mail() {
		messages = new Vector<Message>();
	}

	public String toString() {
		return "Your messages = " + messages;
	}
	
	
}

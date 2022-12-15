package Main;

import Employees.Date;

public class Mark {
	double score;
	Date putDate;
	
	public Mark() {
		
	}
	
	public Mark(double score,Date putDate) {
		this.score = score;
		this.putDate = putDate;
	}
	
	public String toString() {
		return "Mark [score=" + score + ", putDate=" + putDate + "]";
	}
	
}

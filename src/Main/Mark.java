package Main;

import java.io.Serializable;
import java.util.Vector;

public class Mark implements Serializable{
  private Vector<Double> firstAttestation = new Vector<Double>();
  private Vector<Double> secondAttestation = new Vector<Double>();
  private double finalScore = 0;
  transient public static Vector<MarkType> attestations = new Vector<MarkType>();
  
  static {
	  attestations.add(MarkType.FINAL);
	  attestations.add(MarkType.FIRSTATT);
	  attestations.add(MarkType.SECONDATT);
  }
  
  
  public double getFinalScore() {
    return finalScore;
  }

  private double getSum(Vector<Double> vec) {
    double sum = 0;
    for(Double mark : vec) {
      sum+=mark;
    }
    return sum;
  }
  private double getSecondAttOverall() {
    return getSum(secondAttestation);
  }
  
  private double getFirstAttOverall() {
    return getSum(firstAttestation);
  }
  
  public void putMark(double score, MarkType attestation) {
    if(attestation == MarkType.FINAL) {
    	finalScore = score;
    }
    if(attestation == MarkType.FIRSTATT) {
    	firstAttestation.add(score);
    }
    if(attestation == MarkType.SECONDATT) {
    	secondAttestation.add(score);
    }
  }
  
  private double getOverall() {
    return getFirstAttOverall() + getSecondAttOverall() + finalScore;
  }
  
  public String toString() {
	return "First Attestation = " + firstAttestation+ "\n" + 
		   "Second Attestation = " + secondAttestation + "\n" + 
		   "Final score = "+finalScore+"\n" +
		   "First Attestation Overall = " + getFirstAttOverall() +"\n"+
		   "Second Attestation Overall = " + getSecondAttOverall() +"\n"+
		   "Overall = " + getOverall() + '\n';
  }
  
}
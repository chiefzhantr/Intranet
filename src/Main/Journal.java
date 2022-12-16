package Main;

import java.util.Vector;

public class Journal {
  private Vector<Mark> firstAttestation;
  private Vector<Mark> secondAttestation;
  private double finalScore;
  
  public double getFinalScore() {
    return finalScore;
  }
  public void setFinalScore(double finalScore) {
    this.finalScore = finalScore;
  }

  private double getSum(Vector<Mark> vec) {
    double sum = 0;
    for(Mark mark : vec) {
      sum+=mark.score;
    }
    return sum;
  }
  
  private void printFirstAttestation() {
	  System.out.println(firstAttestation);
  }
  private void printSecondAttestation() {
	  System.out.println(secondAttestation);
  }
  
  private double getSecondAttOverall() {
    return getSum(secondAttestation);
  }
  
  private double getFirstAttOverall() {
    return getSum(firstAttestation);
  }
  
  private double getOverall() {
    return getFirstAttOverall() + getSecondAttOverall() + finalScore;
  }
}
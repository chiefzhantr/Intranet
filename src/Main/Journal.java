package Main;

import java.util.Vector;

public class Journal {
  private Vector<Mark> firstAttestation;
  private Vector<Mark> secondtAttestation;
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
  
  private double getSecondtAttOverall() {
    return getSum(secondtAttestation);
  }
  
  private double getFirstAttOverall() {
    return getSum(firstAttestation);
  }
  
  private double getOverall() {
    return getFirstAttOverall() + getFirstAttOverall() + finalScore;
  }
}
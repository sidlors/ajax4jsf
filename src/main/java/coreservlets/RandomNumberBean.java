package coreservlets;

public class RandomNumberBean {
  private int range = 1;
  private double result;

  public int getRange() {
    return(range);
  }

  public void setRange(int range) {
    this.range = range;
  }
  
  public String makeResult() {
    result = Math.random() * range;
    return(null);
  }
  
  public double getResult() {
    return(result);
  }
}

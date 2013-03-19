package Scheduler;

import java.util.ArrayList;

public class Scheduler {
  private ArrayList readyQ;
  private Job currentlyRunningJob;
  
  public Scheduler() {
    readyQ = new ArrayList();
  }
  
  void add(Job j) {    
    readyQ.add(j);
  }
  
  void makeRun() {
    
  }
  
  public void printGannt() {

  }
}
package Scheduler;

import java.util.ArrayList;

public class Scheduler {
  private ArrayList readyQ; // A list of jobs
  private Job currentlyRunningJob;

  public Scheduler() {
    readyQ = new ArrayList();
  }
  
  void add(Job j) {
    readyQ.add(j);
  }
  
  public void printGannt() {
    System.out.println("GANNT CHART:");
    System.out.println("Time         TimeDelta            Job");
    System.out.println("----------------------------------------------");
    
  }
}
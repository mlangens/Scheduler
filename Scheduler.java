package Scheduler;

import java.util.ArrayList;

public class Scheduler {
  private ArrayList readyQ = new ArrayList();

  public Scheduler() {
    readyQ = new ArrayList();
  }

  public boolean isReadyQEmpty() {
    return readyQ.isEmpty();
  }

  void add(Job j) {
    readyQ.add(j);
  }

  void makeRun() {
    Job currentlyRunningJob;
    System.out.println("makerun");
    if (!readyQ.isEmpty()) {
      currentlyRunningJob = (Job) readyQ.remove(0);
      currentlyRunningJob.start();
    }
  }

  public void printGannt() {

  }
}
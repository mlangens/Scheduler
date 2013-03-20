package Scheduler;

import java.util.ArrayList;

public class Scheduler {
  private ArrayList readyQ = new ArrayList();
  private Job currentlyRunningJob = null;

  public Scheduler() {
    readyQ = new ArrayList();
  }

  public boolean isReadyQEmpty() {
    return readyQ.isEmpty();
  }

  void add(Job j) {
    readyQ.add(j);
    if (jobRunning()) {
      makeRun();
    }
  }

  public boolean jobRunning() {
    return currentlyRunningJob == null;
  }

  void makeRun() {
    System.out.println("makerun");
    if (!readyQ.isEmpty()) {
      currentlyRunningJob = (Job) readyQ.remove(0);
      currentlyRunningJob.start();
    } else
      currentlyRunningJob = null;
  }

  public void printGannt() {

  }
}
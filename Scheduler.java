package Scheduler;

import java.util.ArrayList;

public class Scheduler {
  private ArrayList readyQ = new ArrayList();
  private ArrayList<Job> completedJobs = new ArrayList<Job>();

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
    if (!readyQ.isEmpty()) {
      currentlyRunningJob = (Job) readyQ.remove(0);
      currentlyRunningJob.start();
    }
  }

  void addCompletedJob(Job job) {
    completedJobs.add(job);
  }

  public void printGannt() {
    System.out.println("GANNT CHART:");
    System.out.println("Time        TimeDelta        Job");
    System.out.println("---------------------------------------------");
    for (Job job : completedJobs) {
      String initTime = formatInitString(job);
      System.out.println(initTime + "            " + job.getActualRuntime() + "         "
          + job.getJobName());
    }
  }

  private String formatInitString(Job job) {
    String initTime = "";
    int initInt = job.getInit();
    if(initInt == 0) {
      initTime = String.format("%s  ", initInt); 
    } else {
      initTime = Integer.toString(initInt);
    }
    return initTime;
  }
}
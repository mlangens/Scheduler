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
    for (Job job : completedJobs) {
      System.out.println("GANNT CHART:");
      System.out.println("Time                  TimeDelta                   Job");
      System.out.println("---------------------------------------------");
      System.out.println(job.getInit() + "            " + job.getActualRuntime() + "         "
          + job.getJobName());
    }
  }
}
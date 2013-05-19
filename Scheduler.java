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
    System.out.println("makerun");
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
      System.out.println("job id  " + job.getActualRuntime() + " job name: " + job.getJobName() + " job init: "
          + job.getInit());
    }
  }
}
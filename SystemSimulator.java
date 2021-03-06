package Scheduler;

import java.util.ArrayList;

class SystemSimulator extends Thread {
  private Scheduler myScheduler = new Scheduler();
  private boolean noMoreJobsToSubmit = false;
  private boolean jobCurrentlyRunning = false;
  private long startTime;
  ArrayList<Job> completedJobList;

  public SystemSimulator() {
  }

  public void run() {
    startTime = System.currentTimeMillis();
    while (!myScheduler.isReadyQEmpty() || !noMoreJobsToSubmit) {
      try {
        sleep(10);
      } catch (InterruptedException e) {
        myScheduler.makeRun();
        jobCurrentlyRunning = true;
      }
    }
    while (jobCurrentlyRunning) {
      try {
        sleep(10);
      } catch (InterruptedException e) {
      }
    }
    myScheduler.printGannt();
  }

  public long relativeTime() {
    return System.currentTimeMillis() - startTime;
  }

  public void noMoreJobsToSubmit() {
    noMoreJobsToSubmit = true;
  }

  void AddNewProcess(Job createJob) {
    myScheduler.add(createJob);
  }

  void Exit() {
    myScheduler.addCompletedJob((Job) Thread.currentThread());
    jobCurrentlyRunning = false;
  }

}
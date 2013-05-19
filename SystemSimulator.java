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
        System.out.println("runs in system sim");
        myScheduler.makeRun();
        jobCurrentlyRunning = true;
      }
    }
    while(jobCurrentlyRunning) {
      try {
        sleep(10);
      } catch (InterruptedException e){}
    }
    myScheduler.printGannt();
  }

  public long relativeTime() {
    long currentTime = System.currentTimeMillis();
    return currentTime - startTime;
  }

  public void noMoreJobsToSubmit() {
    noMoreJobsToSubmit = true;
  }

  void AddNewProcess(Job createJob) {
    System.out.println("add new process");
    myScheduler.add(createJob);
  }

  void Exit() {
    myScheduler.addCompletedJob((Job) Thread.currentThread());
    jobCurrentlyRunning = false;
    System.out.println("Exit Thread " + Thread.currentThread());
  }

}
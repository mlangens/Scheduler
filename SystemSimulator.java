package Scheduler;

class SystemSimulator extends Thread {
  private Scheduler myScheduler = new Scheduler();
  private boolean noMoreJobsToSubmit = false;

  public SystemSimulator() {
  }

  public void run() {
    while(!myScheduler.isReadyQEmpty() || !noMoreJobsToSubmit) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        myScheduler.makeRun();
      }
    }
  }
  
  public void noMoreJobsToSubmit() {
    noMoreJobsToSubmit = true;
  }

  // myScheduler.printGannt();

  void AddNewProcess(Job createJob) {
    myScheduler.add(createJob);
  }

}
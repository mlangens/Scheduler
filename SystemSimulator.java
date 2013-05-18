package Scheduler;

class SystemSimulator extends Thread {
  private Scheduler myScheduler = new Scheduler();
  private boolean noMoreJobsToSubmit = false;
  private boolean processRunning = false;
  private long startTime;  
  public SystemSimulator() {
  }

  public void run() {
    startTime = System.currentTimeMillis();
    while (!myScheduler.isReadyQEmpty() || !noMoreJobsToSubmit) {
      try {
        sleep(10);
        /*if (!processRunning) {
          processRunning = true;
          myScheduler.makeRun();
        }*/
      } catch (InterruptedException e) {
        System.out.println("runs in system sim");
        myScheduler.makeRun();
      }
    }
  }
  public long relativeTime() {
    long currentTime = System.currentTimeMillis();
    return currentTime - startTime;
  }

  public void noMoreJobsToSubmit() {
    noMoreJobsToSubmit = true;
  }

  // myScheduler.printGannt();

  void AddNewProcess(Job createJob) {
    System.out.println("add new process");
    myScheduler.add(createJob);
  }

  void Exit() {
    processRunning = false;
  }

}
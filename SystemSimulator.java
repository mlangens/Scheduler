package Scheduler;

class SystemSimulator extends Thread {
  private Scheduler myScheduler = new Scheduler();
  private boolean noMoreJobsToSubmit = false;

  public SystemSimulator() {
  }

  public void run() {
    while(!myScheduler.isReadyQEmpty() || !noMoreJobsToSubmit) {
      try {
        sleep(10);
        if(!myScheduler.jobRunning()) {
          myScheduler.makeRun();
        }
      } catch (InterruptedException e) {
        System.out.println("run in system sim");
        myScheduler.makeRun();        
      }
    }
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
//    Thread currentThread = Thread.currentThread(); 
  }

}
package Scheduler;

public class JobTimer extends Thread {
  private Job myJob;
  int msecs;

  public JobTimer(Job target, int msecs) {
    myJob = target;
    this.msecs = msecs;
  }

  public void run() {
    long jobStartTime = System.currentTimeMillis();
    try {
      Thread.sleep(msecs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    myJob.pleaseStop();
    myJob.setActualRuntime((int) (System.currentTimeMillis() - jobStartTime));
  }
}

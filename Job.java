package Scheduler;

public class Job extends Thread {
  String description;
  
  Job(String description, SystemSimulator s, String name) {
    this.description = description;
  }
  
  private SystemSimulator myOS;

  synchronized void pleaseStop() {
  }

  synchronized protected boolean shouldRun() {
    return false;
  }

  protected int getBurstTime() {
    return DescriptionTokenizer.getBurst(description);
  }

  public void run() {
    JobTimer timer = new JobTimer(this, getBurstTime());
    timer.start();
    while(shouldRun()) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Exit();
  }

  void Exit() {
    //myOS.
  }

}

package Scheduler;

public class Job extends Thread {
  String description;
  SystemSimulator s;
  String name;
  
  Job(String description, SystemSimulator s, String name) {
    this.description = description;
    this.s = s;
    this.name = name;
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

//  @Override
//  public String getName() {
//    return name;
//  }

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

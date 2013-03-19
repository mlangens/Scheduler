package Scheduler;

public class Job extends Thread {
  String description;
  SystemSimulator s;
  String name;
  private boolean running;
  
  Job(String description, SystemSimulator s, String name) {
    this.description = description;
    this.s = s;
    this.name = name;    
  }  

  synchronized void pleaseStop() {
    running = false;
  }
    
  synchronized protected boolean shouldRun() {
    return running;
  }

  protected int getBurstTime() {
    return DescriptionTokenizer.getBurst(description);
  }

//  @Override
//  public String getName() {
//    return name;
//  }

  public void run() {
    running = true;
    System.out.println("beginning of run " + name + " "+ description);
    JobTimer timer = new JobTimer(this, getBurstTime());
    timer.start();
    while(shouldRun()) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("its done mane");
    Exit();
  }

  void Exit() {
    s.Exit();
  }

}

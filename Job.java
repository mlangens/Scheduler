package Scheduler;

public class Job extends Thread {
  String description;
  SystemSimulator s;
  String name;
  private boolean running;
  private int actualRuntime;

  Job(String description, SystemSimulator s, String name) {
    this.description = description;
    this.s = s;
    this.name = name;
  }

  public int getActualRuntime() {
    return actualRuntime;
  }

  public void setActualRuntime(int actualRuntime) {
    this.actualRuntime = actualRuntime;
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

  protected String getJobName() {
    return name;
  }

  protected int getInit() {
    return DescriptionTokenizer.getInit(description);
  }

  public void run() {
    running = true;
    JobTimer timer = new JobTimer(this, getBurstTime());
    timer.start();
    while (shouldRun()) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Exit();
  }

  void Exit() {
    s.Exit();
    s.interrupt();
  }

}

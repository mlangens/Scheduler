package Scheduler;

class JobCreator {
  protected SystemSimulator mySystem;

  public JobCreator(SystemSimulator s) {
    mySystem = s;
  }

  public Job createJob(String description, SystemSimulator s, String name) {
    return new Job(description, s, name);
  }

}

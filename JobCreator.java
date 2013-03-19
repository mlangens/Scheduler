package Scheduler;

class JobCreator {
  protected SystemSimulator mySystem;

  public JobCreator(SystemSimulator s) {
    mySystem = s;
  }

  public Job createJob(String description, SystemSimulator s, String name) {
    // Return a Job or subtype of Job for eventual execution.
    return new Job(description, s, name);
  }

}

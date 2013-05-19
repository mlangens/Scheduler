package Scheduler;

class MattJobCreator extends JobCreator {
  public MattJobCreator(SystemSimulator s) {
    super(s);
  }

  public Job createJob(String description, SystemSimulator s, String name) {
    // Return a Job or subtype of Job for eventual execution.
    System.out.println("Creating a new job at time " + System.currentTimeMillis());
    return new MattJob(description, mySystem, name);
  }
}
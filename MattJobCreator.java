package Scheduler;

/**
 * <p>Title: MattJobCreator</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Matt Evett
 * @version 1.0
 */

class MattJobCreator extends JobCreator {
  public MattJobCreator(SystemSimulator s) {
    super(s);
  }
  public Job createJob(String description, SystemSimulator s, String name) {
    // Return a Job or subtype of Job for eventual execution.
    System.out.println("Creating a new job at time "+System.currentTimeMillis());
    return new MattJob(description, mySystem, name);
  }
}
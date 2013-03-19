package Scheduler;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Submittor extends Thread {
  private SystemSimulator mySystem;
  private JobCreator myJobCreator;
  private ArrayList jobDescriptions;
  private SystemSimulator s;
  private JobCreator progenitor;

  public Submittor(ArrayList jobDescriptions, SystemSimulator s, JobCreator progenitor) {
    this.jobDescriptions = jobDescriptions;
    this.s = s;
    this.progenitor = progenitor;
  }

  public void run() {
    for (Object description : jobDescriptions) {
        try {
          sleep(DescriptionTokenizer.getInit(description));
        } catch (InterruptedException e) {
        }
      String name = "Max";
      mySystem.AddNewProcess(progenitor.createJob((String) description, mySystem, name));      
    }

    mySystem.noMoreJobsToSubmit();
  }
}



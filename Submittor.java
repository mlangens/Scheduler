package Scheduler;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Submittor extends Thread {
  private ArrayList jobDescriptions;
  private SystemSimulator s;
  private JobCreator progenitor;

  public Submittor(ArrayList jobDescriptions, SystemSimulator s, JobCreator progenitor) {
    this.jobDescriptions = jobDescriptions;
    this.s = s;
    this.progenitor = progenitor;
  }

  public void run() {
    for (int i = 0; i < jobDescriptions.size(); i++) {
      try {
        sleep(DescriptionTokenizer.getInit(jobDescriptions.get(i)));
      } catch (InterruptedException e) {
      }
      String name = "Max Job " + Integer.toString(DescriptionTokenizer.getId(jobDescriptions.get(i)));
      s.AddNewProcess(progenitor.createJob((String) jobDescriptions.get(i), s, name));
      if (i == 0)
        s.interrupt();
      System.out.println("this is the desc " + jobDescriptions.get(i) + " name " + name);
    }

    s.noMoreJobsToSubmit();
  }
}

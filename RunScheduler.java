package Scheduler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RunScheduler {
  public static void main(String[] args) throws FileNotFoundException {
    Thread thisThread = Thread.currentThread();
    thisThread.setPriority(Thread.MAX_PRIORITY);
    SystemSimulator os = new SystemSimulator();
    ArrayList jobs = new ArrayList();

    jobs.add("1 0 200");
    jobs.add("2 100 300");
    jobs.add("3 300 300");

    JobCreator sinecure = new JobCreator(os);
    Submittor sub = new Submittor(jobs, os, sinecure);
    os.setPriority(8);
    os.start(); // Thread executing this instruction has higher priority, so
                // will continue to hold cpu
    sub.setPriority(7); // Should interrupt os only when os is sleeping, but can
                        // always interrupt running Jobs
    sub.start();
    // As the driver exits, os has the highest priority, so should get the
    // cpu....
  }
}

class ListManager {

}

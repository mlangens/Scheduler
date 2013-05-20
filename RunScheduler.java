package Scheduler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RunScheduler {
  public static void main(String[] args) throws FileNotFoundException {
    Thread thisThread = Thread.currentThread();
    thisThread.setPriority(Thread.MAX_PRIORITY);
    SystemSimulator os = new SystemSimulator();
    ArrayList jobs = new ArrayList();
    FileHandler handler = new FileHandler();
    try {
      ArrayList<String> handleFile = handler.handleFile();
      for (String string : handleFile) {
        jobs.add(string);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

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

class FileHandler {
  //http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-in-java
  public ArrayList<String> handleFile() throws IOException {
    ArrayList<String> jobList = new ArrayList<String>();    
    BufferedReader reader = new BufferedReader(new FileReader("scheduleInput.txt"));
    String line = "";
    while ((line = reader.readLine()) != null) {
      jobList.add(line);
    }
    reader.close();
    return jobList;
  }
}

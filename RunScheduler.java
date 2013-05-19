package Scheduler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class RunScheduler {
  public static void main(String[] args) throws FileNotFoundException {
    Thread thisThread = Thread.currentThread();
    thisThread.setPriority(Thread.MAX_PRIORITY);
    SystemSimulator os = new SystemSimulator();
    ArrayList jobs = new ArrayList();

    ListManager reader = new ListManager();
    ArrayList<String> readData = reader.readData();
    for (String string : readData) {
      System.out.println(string);
      // jobs.add(string);
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

class ListManager {
  // adapted from http://csis.pace.edu/~wolf/cs121/TestFiles2.htm
  private ArrayList<String> inputList = new ArrayList<String>();

  public ArrayList<String> readData() {
    try {
      BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("scheduleInput.txt")));
      StreamTokenizer tokens = new StreamTokenizer(input);
      int next = tokens.nextToken();
      while (next != tokens.TT_EOF) {
        double nval = tokens.nval;
        inputList.add(Integer.toString((int) nval));
        next = tokens.nextToken();
      }
      input.close();
    } catch (IOException e) {
    } catch (NumberFormatException e) {
    }

    ArrayList<String> jobList = parseJobs();
    return jobList;
  }

  private ArrayList<String> parseJobs() {
    String temp = "";
    ArrayList<String> jobList = new ArrayList<String>();
    for (int i = 0; i < inputList.size(); i++) {      
      if (i % 3 != 0)
        temp += inputList.get(i) + " ";
        //System.out.println("I am i%3 here is i: " + i);
      else
        temp += inputList.get(i);
        jobList.add(temp);
        temp = "";
    }
    return jobList;
  }
}

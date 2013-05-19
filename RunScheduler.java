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
    ArrayList<Integer> readData = reader.readData();
    String temp = "";
    for(int i=0; i<readData.size(); i++) {
    }

    // jobs.add("1 0 300");
    // jobs.add("2 100 300");
    // jobs.add("3 300 300");

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
  //adapted from http://csis.pace.edu/~wolf/cs121/TestFiles2.htm
  private ArrayList<Integer> dataList = new ArrayList<Integer>();
  public ArrayList<Integer> readData() {
    try {
      BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("scheduleInput.txt")));
      StreamTokenizer tokens = new StreamTokenizer(input);
      int next = tokens.nextToken();
      while (next != tokens.TT_EOF) {
        double nval = tokens.nval;
        dataList.add((int) nval);
        next = tokens.nextToken();
      }
      input.close();
    } catch (IOException e) {
    } catch (NumberFormatException e) {
    }
    return dataList;
  }
}

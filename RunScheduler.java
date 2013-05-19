package Scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RunScheduler {
  public static void main(String[] args) {
    Thread thisThread = Thread.currentThread();
    thisThread.setPriority(Thread.MAX_PRIORITY);
    SystemSimulator os = new SystemSimulator();
    ArrayList jobs = new ArrayList();

    Object in;
    // Here you need to parse the input file, scheduleInput.txt, to create the
    // jobs ArrayList.
    // For testing purposes, though, I'll just hardwire a three-value list. The
    // RunScheduler that you submit should NOT have the following three lines.

    jobs.add("1 0 300");
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

class FileStreamsReadnWrite {
  public static void main(String[] args) {
    try {
      File stockInputFile = new File("/.txt");
      File StockOutputFile = new File("/.txt");

      FileInputStream fis = new FileInputStream(stockInputFile);
      FileOutputStream fos = new FileOutputStream(StockOutputFile);
      int count;

      while ((count = fis.read()) != -1) {
        fos.write(count);
      }
      fis.close();
      fos.close();
    } catch (FileNotFoundException e) {
      System.err.println("FileStreamsReadnWrite: " + e);
    } catch (IOException e) {
      System.err.println("FileStreamsReadnWrite: " + e);
    }
  }
}
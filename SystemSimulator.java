package Scheduler;
class SystemSimulator extends Thread {
  private Scheduler myScheduler;
  public SystemSimulator() {
  }

//  while (there are still jobs to be submitted, or jobs remain in the system) {
//    /**
//     * sleep until interrupted (either via an Exit or via a job being submitted by Submittor)
//     * if there isn't a job running, tell the scheduler to start a new one.
//     * loop back to top....
//     */
//   try {
//        sleep(quantum);
//        // If we get to here, quantum has expired without an exception occurring
//        //....
//      }
//      // N.b: during this exception handling other exceptions may be lost...
//
//      catch (InterruptedException e) {
//        // Several ways to get here: poked by Job's call to Exit, or by Submittor's
//
//        //  providing a new Job.  Is there a Job currently running that we will leave
//    // running?  If so, might
//    // want to manipulate the value of quantum so that the call to sleep that is
//    // about to occur doesn't provide for a full quantum.
//        .... 
//      }
//
//  }
  
  public void noMoreJobsToSubmit() {
    // TODO Auto-generated method stub
    
  }
//  myScheduler.printGannt();

  public void AddNewProcess(Job createJob) {
    // TODO Auto-generated method stub
    
  }

}
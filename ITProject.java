package RefDefCwk;
import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.io.*;

/**
 * This class implements the behaviour expected from the BITS system
 as required for 5COM2007 Referred/Deferred Cwk - June 2024 and 
 specified in the BITS interface
 * 
 * @author - add your name and SRN here
 * @author - if working as a pair, add your partner's name & SRN here
 *           (or leave blank, if working individually)
 * @version - add the submission date here
 * @author A.A.Marczyk  
 * @version 24/04/2024
 */
public class ITProject implements BITS,Serializable
{
    //Note: ArrayLists instead of HashMaps is OK, but then there will be code differences
    
    private String name;
    private double account;
    private List<Staff> availableStaff;
    private List<Staff> hiredStaff;
    private List<Job> jobs;

  
//**************** BITS ************************** 
    /** Constructor requires the name of the trainee manager and initial budget. Staff
     * and jobs are also set up,  with all staff set to "available" for hire.
     * @param manager the name of the trainee manager running the simulation
     * @param budget the initial budget allocated to the project account
     */
    public ITProject(String manager, double budget)
    {
       name = manager;
       account = budget;
       this.availableStaff = new ArrayList<>();
       this.hiredStaff = new ArrayList<>();
       this.jobs = new ArrayList<>();
       setupStaff();
       setupJobs();
    }
    
    /** Constructor requires the name of the trainee manager, initial budget 
     * and name of jobs file. Staff are also set up,  with all staff set to 
     * "available" for hire. Jobs are "read from a file
     * @param manager the name of the trainee manager running the simulation
     * @param budget the initial budget allocated to the project account
     * @param filename the name of the jobs file
     */
    public ITProject(String manager, double budget, String jobfile)
    {
       
    }
    
    /**Returns a String representation of the state of the project,
     * including the name of the manager, state of the project account,
     * whether overdrawn or not, the staff in the team (or, "No staff" 
     * if team is empty)
     * @return a String representation of the state of the project,
     * including the name of the manager, state of the project account,
     * whether overdrawn or not, and the staff currently in the 
     * team,(or, "No staff" if team is empty)
     **/
    public String toString()
    {
        
        return "";
    } 
    
    
    /** returns the amount of money in the account
     * @returns the amount of money in the account
     */
    public double getAccount()
    {

        return account;
    }

    
    /** returns true if project account <=0 and the team has no staff 
     * who can leave. 
     * @returns true if project account <=0 and the team has no staff 
     * who can leave. 
     */
    public boolean isOverdrawn()
    {

        return account<=0 && hiredStaff.isEmpty();
    }
    
//**********************Jobs************************* 

    /** returns true if the number represents a job
     * @param num is the reference number of the job
     * @returns true if the reference number represents a job
     **/
     public boolean isJob(int num)
     {
         for(Job job:jobs){
             if(job.getJobNo()==num){
                 return true;
             }
         }
         return false;
     }

     
    /** Provides a String representation of all jobs 
     * @return returns a String representation of all jobs
     **/
    public String getAllJobs()
    {
        String s = "\n************ All Jobs ************\n";
        
        
        
        return s;
    }
 
    /** Returns a String with information about specified job
     * @param no - number of the specified job
     * @return returns a String representation of all jobs
     **/
    public String getJob(int no)
    {
        for(Job job:jobs){
            if(job.getJobNo()==no){
                return job.toString();
            }
        }
        
        return null;
    }
    //*********************** Staff *************************    

     /** Returns details of a staff member with the given name
     * (staff may be in or out of the team)
     * @param name the name of the required staff member
     * @return details of a staff member with the name specified 
     * in the parameter
     **/
    public String getStaff(String name)
    {
        
        
        
        
        return "\nNo such staff";
    }
    

    /**Returns a String representation of all staff available for hire 
     * @return a String representation of all staff available for hire 
     **/
    public String getAllAvailableStaff()
    { //assumes allStaff is a Hashmap
        String s = "************ Staff for Hire********";
        
        
        
        return s;
    }
     
 // ***************** Team Staff ************************   

    /** Allows staff to be added to the team, if there is enough  
     * money in the account for the retainer.The hired staff member's 
     * state is set to "working" and their retainer is deducted from
     * the project account. Return the result of the hire; all messages 
     * should include the staff name and state of the project account
     * @param name is the name of the staff member
     * @return "Not found" if staff not found, "Already hired" if staff 
     * is already hired, "Not enough money" if not enough money in the 
     * account,"Hired" if staff are hired.All messages should include 
     * the staff name and state of the project account
     **/        
    public String hireStaff(String name)
    {
        String result = "";
        
        
        
        
        
        return result + "\nAccount = £" + account;
    }
        
   /** Returns true if the staff with the specified name 
     * is in the team, false otherwise. 
     * @param name is the name of the staff
     * @return true if the staff with the name is in the team, 
     * false otherwise.
     **/
    public boolean isInTeam(String name)
    {
        for(Staff staff:hiredStaff){
            if(staff.getName().equalsIgnoreCase(name))
                return true;
        }
        
        return false;
    }
    
    
    /**Returns a String representation of the staff in the project team
     * (including those on holiday), or the message "No staff hired"
     * @return a String representation of the staff in the project team
     **/
    public String getTeam()
    {
        StringBuilder s = new StringBuilder("************ TEAM ********\n");
        if(hiredStaff.isEmpty()){
            s.append("no staff hired");
        }else{
            for(Staff staff:hiredStaff){
                s.append(staff.toString()). append("\n");
            }
        }
        

        return s.toString();
    }
  

    /** Retrieves the job represented by the job number, or returns "No 
     * such job".If job exists, finds a staff member in the team who can 
     * do the job.The results of doing a job will be one of the following: 
     * " Job completed by..." - adds the cost of the job to account and include 
     *                           name of staff staff go "on holiday", 
     * " Job not completed as no staff available" - deduct job penalty from account,
     * " Job not completed due to staff inexperience" - deduct penalty from 
     *                           the account.
     * If a job is not completed and the project account becomes negative, 
     * add "ITProject is overdrawn " to the output. 
     * @param jbNo is the reference number of the job
     * @return a String showing the result of doing the job(as above)
     */ 
    public String doJob(int jbNo)
    {
        String outcome = "\nJob No " + jbNo ;
        
        
        
        
        
        return outcome;
    }

    /**Staff rejoin the team after holiday by setting state to "working" 
     * @param the name of the staff rejoining the team after holiday
     */
    public String staffRejoinTeam(String name)
    {   
        
        
        
        return name + " not in team so can't return from holiday";
    }
    //****************** private methods for Task 6.1 functionality*******************

    private void setupStaff()
    {
      availableStaff.add(new Designer("Amir",2,300,false,30));
      availableStaff.add(new Engineer("Bela", 2, 100, false, 30));
      availableStaff.add(new Engineer("Ceri", 4, 250, true, 40));
      availableStaff.add(new Programmer("Dana", 2, 200, false, 20));
      availableStaff.add(new Programmer("Eli", 7, 200, false, 20));
      availableStaff.add(new Designer("Firat", 6, 300, true, 90));
      availableStaff.add(new Programmer("Gani", 2, 200, false, 20));
      availableStaff.add(new Engineer("Hui", 8, 450, true, 40));
      availableStaff.add(new Designer("Jaga", 4, 300, true, 60));
    }
   
    
    private void setupJobs()
    {
        jobs.add(new Job(100,"Design",3,10,200));
        jobs.add(new Job(101, "Hardware", 3, 20, 150));
        jobs.add(new Job(102, "Software", 3, 30, 100));
        jobs.add(new Job(103, "Design", 9, 25, 250));
        jobs.add(new Job(104, "Software", 7, 15, 350));
        jobs.add(new Job(105, "Hardware", 8, 35, 300));
        jobs.add(new Job(106, "Hardware", 5, 20, 400));
        
    }
    
// May be helpful    
    
//    private Job getAJob(int num)
//    {
//       
//    }
//   
//    private Staff getStaffForJob(Job jbb)
//    {
//        
//        return null;
//    }
 
      // Task 2.5 
//    // ***************   file write/read  *********************
//    /** Writes the ITProject object to the specified file using serialization
//     * @param filename name of file to which schedule is written
//     */
//    public void saveITProject(String filename)
//    {
//        
//        
//    }
//    
//    
//    
//    /** Reads ITProject from specified file using serialization and restores it
//     * @param fname name of file from which schedule is read
//     */
//    public ITProject restoreITProject(String filename)
//    {   // uses object serialisation 
//        ITProject yyy = null;
//        
//        
//        
//        return yyy;
//    } 
//    
//   /** Reads jobs from a text file such as "jobs.txt" - provided
//    *  @filename - name of the text file
//    */
//    public void readJobs(String fname)
//    { 
//        
//    }
}

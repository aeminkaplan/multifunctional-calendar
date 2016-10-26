import java.util.ArrayList;

/**
 * This class supervise jobs of calendar, to get this classes instance invoke getInstance method
 * @author kasım süzen
 */

public class JobSupervisor {
    private ArrayList<AbstractActiveJob> activeJobs;
    private ArrayList<AbstractPassiveJob> passiveJobs;
    private static JobSupervisor object;

    /**
     * This constructor is private to make this class singleton
     */
    private JobSupervisor(){
        activeJobs = new ArrayList<>();
        passiveJobs = new ArrayList<>();
    }

    /**
     * This method returns instance of this class
     * @return Instance of JobSupervisor class
     */
    public static JobSupervisor getInstance(){
        if(object == null){
            object = new JobSupervisor();

            return object;
        }
        else
            return object;
    }

    /**
     * Returns all active jobs whether they done or not
     * @return Array list of all active jobs
     */
    public ArrayList<AbstractActiveJob> getAllActiveJobs(){
        return activeJobs;
    }

    /**
     * Returns all passive jobs whether they done or not
     * @return Array list of all passive jobs
     */
    public ArrayList<AbstractPassiveJob> getAllPassiveJobs(){
        return passiveJobs;
    }

    /**
     * This method is watcher of all active jobs when their time come it will invoke their own methods to do their job
     */
    public void update(){

    }

    /**
     * Adds new active job to list of jobs
     * @param newJob new active job to add
     * @return Success or fail status
     */
    public boolean addActiveJob(AbstractActiveJob newJob){
        return activeJobs.add(newJob);
    }

    /**
     * Adds new passive job to list of jobs
     * @param newJob new passive job to add
     * @return Success or fail status
     */
    public boolean addPassiveJob(AbstractPassiveJob newJob){
        return passiveJobs.add(newJob);
    }

    /**
     * This method modifies given active job with new given job
     * @param originalJob original job to modify
     * @param editedJob a copy of the modified job
     * @return Success or fail status
     */
    public boolean modifyActiveJob(AbstractActiveJob originalJob, AbstractActiveJob editedJob){
        return false;
    }

    /**
     * This method modifies given passive job with new given job
     * @param originalJob original job to modify
     * @param editedJob a copy of the modified job
     * @return Success or fail status
     */
    public boolean modifyPassiveJob(AbstractPassiveJob originalJob, AbstractPassiveJob editedJob){
        return false;
    }
}

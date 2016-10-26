import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Calendar;

/**
 * This interface holds date and information of jobs status
 * @author kasım süzen
 */
public abstract class AbstractActiveJob {
    public Calendar dueDate = null;
    public Calendar creationDate = null;
    public boolean isDone = false;

    /**
     * Returns due date of this job
     * @return due date of this job
     */
    public Calendar getDueDate(){ return dueDate;}

    /**
     * Returns creation time of this job
     * @return date of creation
     */
    public Calendar getCreationDate(){ return creationDate;}

    /**
     * Does the generic job for each method
     * @return success if job done or fail
     */
    public boolean doJob(){throw new NotImplementedException();}

}

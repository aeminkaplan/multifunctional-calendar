import java.util.Calendar;

/**
 * This is an abstract class to be inherit for child class of other generic passive jobs
 * @author kasım süzen
 */

public abstract class AbstractPassiveJob {
    public Calendar dueDate = null;
    public Calendar creationDate = null;

    /**
     * Returns due date of this job
     * @return due date of this job
     */
    public Calendar getDueDate(){return dueDate;}
    /**
     * Returns creation time of this job
     * @return date of creation
     */
    public Calendar getCreationDate(){return creationDate;}
}

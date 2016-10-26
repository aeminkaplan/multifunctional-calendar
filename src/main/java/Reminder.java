import java.util.Calendar;

/**
 * This class created for a branch of passive jobs, Reminder simply this class is a timed quiet reminder
 * @author kasım süzen
 */
public class Reminder extends AbstractPassiveJob {
    private String textToRemind;

    /**
     * Construct of this class takes a string which is note to remind user later
     * @param text Message to remind
     * @param created Date of creation
     * @param due Date of due
     */
    public Reminder(String text,Calendar created,Calendar due){
        textToRemind = text;
        creationDate = created;
        due = dueDate;
    }

    /**
     * Returns message to remind
     * @return Message
     */
    public String getText(){
        return textToRemind;
    }

    /**
     * Sets text in case of modify
     * @param text new text to be saved
     */
    public void setText(String text){
        textToRemind = text;
    }

}

import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Calendar;

/**
 * This class is wrapper for ftp file sending
 * @author kasım süzen
 */
public class FtpSender extends AbstractActiveJob {
    private InetSocketAddress ip;
    private URL filePath;

    /**
     * Public constructor for this class needs IP and path to file via ftp
     * @param created Date of creation
     * @param due Date of due
     * @param givenIp IP address of destination
     * @param pathOfFileToSend Path of file to send
     */
    public FtpSender(Calendar created, Calendar due, InetSocketAddress givenIp, URL pathOfFileToSend){
        creationDate = created;
        dueDate = due;
        ip = givenIp;
        filePath = pathOfFileToSend;
    }

    /**
     * Returns creation time of this job
     * @return date of creation
     */
    @Override
    public Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * Checks if the job is done
     * @return Returns if job is done
     */
    @Override
    public boolean doJob() {
        return false;
    }
}

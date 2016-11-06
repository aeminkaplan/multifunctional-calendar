import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Calendar;


/**
 *  Bu sinif, uygulama acildigi zaman
 *  yapilmasi gereken bir aktif gorev var ise
 *  arka planda bir thread kullanarak
 *  bu aktif gorevi yapar.
 * @author mutlu koktemir
 */
public class CalendarThread implements Runnable{
    
    private Thread t;
    private FtpSender ftpSender;
    
    /**
     *  Thread'i baslatir.
     * @param ftp aktif gorevin objesi
     */
    public CalendarThread(FtpSender ftp)
    {
        ftpSender = ftp;
        t = new Thread(this,"other");
        t.start();
        
    }
    
    /**
     *  Aktif gorevin due date i
     *  mevcut tarihe esit ise veya
     *  mevcut tarihten geride ise
     *  aktif gorevi yapar.
     */
    @Override
    public void run() {
        
        Calendar calNow = Calendar.getInstance();
        Calendar dueDate = ftpSender.getDueDate();
        
        if( dueDate.compareTo(calNow) <= 0 )
            ftpSender.doJob();
        
    }
}


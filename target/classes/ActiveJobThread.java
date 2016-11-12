/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *  Bu sinif, uygulama acildigi zaman
 *  yapilmasi gereken bir aktif gorev var ise, 
 *  bu aktif gorev icin bir ip ve file path alir.
 *  Arka planda bir thread kullanarak
 *  bu aktif gorevi yani verilen dosyayi verilen ip ye gonderir.
 * @author mutlu koktemir
 */
public class ActiveJobThread implements Runnable{
    
    private Thread thread;
    private String ip;
    private String filePath;
    
    /**
     *  Thread'i baslatir.
     * @param ip  ip = 127.0.0.1:13267   ÅŸeklinde bir hostname bir de portname iÃ§ermeli (ftp server adresi iÃ§in)
     *  eÄŸer ip https://127.0.0.1:13267 ÅŸeklinde alÄ±nmÄ±ÅŸsa URI objesine direkt ip yi gÃ¶ndermelisin
     * @param filepath  gÃ¶nderilecek olan dosya
     */
    public ActiveJobThread(String ip, String filepath)
    {
        this.ip = ip;
        filePath = filepath;
        thread = new Thread(this,"other");
        thread.start();
        
    }
    
    
    @Override
    public void run() {
        
        //URI uri = new URI(ip);
        
        try {
        	
            URI uri = new URI("xxx://" + ip);
            String host = uri.getHost();
            int port = uri.getPort();

            Socket sock = new Socket(host, port);

            File myFile = new File(filePath);
            byte[] myArray = new byte[(int) myFile.length()];

            FileInputStream fileInputStream = new FileInputStream(myFile);
            BufferedInputStream buffredInputStream = new BufferedInputStream(fileInputStream);
            buffredInputStream.read(myArray, 0, myArray.length);

            OutputStream outputStream = sock.getOutputStream();

            //gÃ¶nderim baÅŸladÄ±
            outputStream.write(myArray, 0, myArray.length);
            //gÃ¶nderin sona erdi

            outputStream.flush();

            sock.close();
            
        } catch ( URISyntaxException | IOException ex ) {
            Logger.getLogger(ActiveJobThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
}


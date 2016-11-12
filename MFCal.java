/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Wade
 */
public class MFCal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MFCal cal = new MFCal();
        MyCalendar mcal = new MyCalendar();
        Firfra x = new Firfra();
        x.setLocationRelativeTo(null);
        x.setVisible(true);

        while (true) {
            cal.doActive();
            
        }
        
    }

    public int readyToSend(String date1, String date2, int hour1, int hour2) {
        String[] firDat = date1.split("/");
        String[] secDat = date2.split("/");

        if (Integer.parseInt(firDat[2]) < Integer.parseInt(secDat[2]) || (Integer.parseInt(firDat[2]) == Integer.parseInt(secDat[2]) && Integer.parseInt(firDat[1]) < Integer.parseInt(secDat[1]))
                || (Integer.parseInt(firDat[2]) == Integer.parseInt(secDat[2]) && Integer.parseInt(firDat[1]) == Integer.parseInt(secDat[1]) && Integer.parseInt(firDat[0]) < Integer.parseInt(secDat[0]))) {
            return 1;
        } else if (date1.equals(date2) && hour1 <= hour2) {
            return 1;
        } else {
            return 0;
        }

    }

    public void doActive() throws FileNotFoundException, IOException {
        MyCalendar mcal = new MyCalendar();

        Calendar rightNow = Calendar.getInstance();
        int hourToday = rightNow.get(Calendar.HOUR_OF_DAY);
        FileReader fileReader = new FileReader(new File("acDats.txt"));
        BufferedReader br = new BufferedReader(fileReader);

        String line = null;
        br.readLine();
     
        while ((line = br.readLine()) != null && line.length() != 0) // reading lines until the end of the file
        {
       

              
            String[] splitStr = MFCal.decode(line).split("é");

            String[] subSplit = splitStr[0].split(":");

            String[] filSplit = splitStr[1].split("#");

            String hour = subSplit[1];
            String[] willdate = subSplit[0].split(" ");

            String date = "0";
            if (willdate[0].length() == 9) {
                date += willdate[0];
            } else {
                date = willdate[0];
            }

            String filName = filSplit[0];
            String path = filSplit[1];

            System.out.println(hour);
            System.out.println(date);
            System.out.println(filName);
            System.out.println(path);

            
            if (readyToSend(date, mcal.getDate(), Integer.parseInt(hour), hourToday) == 1) {
                ActiveJobThread ajt = new ActiveJobThread(path, filName);
                ajt.run();
            }

        }

        br.close();

    }

    public static String encode(String s) {
        String encoded = DatatypeConverter.printBase64Binary(s.getBytes());
        return encoded;
    }

    public static String decode(String s) {
        String decoded = new String(DatatypeConverter.parseBase64Binary(s));
        return decoded;
    }

    public String getPass(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filename));
        String crypt = in.nextLine();

        return cipherCrypto(crypt);

    }

    public static int getCurrentMonth() {
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public static int getCurrentYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public static int getCurrentDay() {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    private String cipherCrypto(String crypted) {
        String decrypt = "";
        for (int i = 0; i < crypted.length(); ++i) {
            decrypt += (char) (crypted.charAt(i) - 1);
        }
        return decrypt;

    }

}

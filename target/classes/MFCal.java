/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public static void main(String[] args) {
        // TODO code application logic here
        MFCal cal = new MFCal();
        MyCalendar mcal = new MyCalendar();
        Firfra x = new Firfra();
        x.setLocationRelativeTo(null);
        x.setVisible(true);
        
        for(int i=1; i<=12; i++){
			String[] t=mcal.getMaxDayAndFirstDay(2016,i);
			System.out.printf(t[0] + " -- "+t[1] +" \n");
		}
        
      
    }
    
    
    public static String encode(String s){
        String encoded = DatatypeConverter.printBase64Binary(s.getBytes());
        return encoded;
    }
  
    public static String decode(String s){
        String decoded = new String(DatatypeConverter.parseBase64Binary(s));
        return decoded;
    }
        
        
    public String getPass(String filename) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader(filename));
        String crypt = in.nextLine();
       
        return cipherCrypto(crypt);
       
       
    }
    
    
    public static int getCurrentMonth(){
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }
    
    public static int getCurrentYear(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }
    public static int getCurrentDay(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }
    

    private String cipherCrypto(String crypted) {
        String decrypt = "";
        for(int i = 0 ; i < crypted.length() ; ++i){
           decrypt += (char) (crypted.charAt(i) - 1);
        }
        return decrypt;
         
    }
    
    
}

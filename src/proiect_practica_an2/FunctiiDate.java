/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proiect_practica_an2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import static net.ucanaccess.converters.SQLConverter.DATE_FORMAT;



public class FunctiiDate {
    boolean ValidDate(String dd,String mm,String yyyy){
        if(yyyy.length()!=4)
            return false;
        String date=dd+"-"+mm+"-"+yyyy;
        try {
            String DATE_FORMAT = "dd-MM-yyyy";
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
}

    boolean ValidOra(String ss,String mm ,String hh){
        if(hh.length()==1)
        {
            String k="0";
            hh=k+hh;
        }
        if(mm.length()==1)
        {
            String k="0";
            mm=k+mm;
        }
        if(ss.length()==1)
        {
            String k="0";
            ss=k+ss;
        }
        String Ora=hh+":"+mm+":"+ss;
        try {
            LocalTime.parse(Ora);
            return true;
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
    }

    boolean ValidOraDif(String ssI, String mmI, String hhI, String ssF, String mmF, String hhF){
        LocalTime oraI = LocalTime.of(Integer.parseInt(hhI),Integer.parseInt(mmI),Integer.parseInt(ssI));
        LocalTime oraF = LocalTime.of(Integer.parseInt(hhF),Integer.parseInt(mmF),Integer.parseInt(ssF));
        if(!oraI.isAfter(oraF))
            return true;
        else
            return false;
}
}


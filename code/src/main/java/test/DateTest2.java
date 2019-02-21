package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {
    public static void main(String[] args){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time=new Long(445555555);
        String d = format.format(time);

        Long we = Long.parseLong("4555");

        String w = format.format(we);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Format To String(Date):"+d);
        System.out.println("Format To Date:"+date);

        System.out.println("w:"+w);
    }
}

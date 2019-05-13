package company.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {

    public static void main(String[] args){
        String time = "Tue, 16 Apr 2019 02:03:50 GMT";
        Date date = new Date(time);
        SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time=dateformat1.format(date);
        System.out.println(time);


    }
}

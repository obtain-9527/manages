package com.company.manage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class random {
    private static  SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
    private static Date data =new Date();
    private static int year = 2019;
    private static String  time = sdf.format(data);
    private  static int i = 1;
    public static String number(){
        String Tnumber =time +"0000";
        if(Integer.parseInt(time) == year){
            Tnumber = time + shu();
        }else{
            year=Integer.parseInt(time);
            i = 1;
            Tnumber = time + shu();
        }
        return Tnumber;
    }
    private static String shu(){
        String number ="0000";
        if(i>=10&&i<100){
            number = "00"+i;
        }else if(i>=100&&i<1000){
            number = "00"+i;
        }else if(i>=1000&&i<10000){
            number = ""+i;
        }else if(i>=1&&i<10){
            number = "000"+i;
        }else {
            i = 1;
        }
        i++;
        return number;
    }


}

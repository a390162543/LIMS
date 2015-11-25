package businesslogic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessLogicUtil {
    
    public static String getDate(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    
    public static String getTime(Date date){
        return new SimpleDateFormat("MM‘¬dd»’ HH:mm:ss").format(date);
    }
    
    public static String formatByZero(String s, int length){
        int zeroNum = length - s.length();
        if(zeroNum < 0)
            throw new IndexOutOfBoundsException();
        for(int i=0;i<zeroNum;i++){
            s = "0"+s;
        }
        return s;
    }
}

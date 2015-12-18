package businesslogic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@code BusinessLogicUtil}是业务逻辑的工具类,提供了业务逻辑模块需要的通用方法
 * @author 林祖华
 * @version 1.1
 */
public class BusinessLogicUtil {
    
    /**
     * 获取当前系统时间日期的8位数字格式
     * <p>例如：当前为2008年9月1日则返回20080901
     * @return 当前系统时间日期的{@code String}
     */
    public static String getDate(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    
    /**
     * 获取时间的一种显示形式，格式为：yyyy年MM月dd日
     * <p>例如：2008年9月1日15时0分5秒则返回2008年09月01日
     * @return 时间日期的{@code String}
     */
    public static String getDate(Date date){
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
    }
    
    /**
     * 获取时间的一种显示形式，格式为：yyyy年MM月dd日 HH:mm:ss
     * <p>例如：2008年9月1日15时0分5秒则返回2008年09月01日 15:00:05
     * @return 时间日期的{@code String}
     */
    public static String getTime(Date date){
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
    }
    
    /**
     * 用{@code 0}插入在{@code String}之前以格式化{@code String}
     * @param s 需要格式化的{@code String}
     * @param length 格式化长度
     * @return 格式化之后的字符串
     */
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

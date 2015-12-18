package businesslogic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@code BusinessLogicUtil}��ҵ���߼��Ĺ�����,�ṩ��ҵ���߼�ģ����Ҫ��ͨ�÷���
 * @author ���滪
 * @version 1.1
 */
public class BusinessLogicUtil {
    
    /**
     * ��ȡ��ǰϵͳʱ�����ڵ�8λ���ָ�ʽ
     * <p>���磺��ǰΪ2008��9��1���򷵻�20080901
     * @return ��ǰϵͳʱ�����ڵ�{@code String}
     */
    public static String getDate(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    
    /**
     * ��ȡʱ���һ����ʾ��ʽ����ʽΪ��yyyy��MM��dd��
     * <p>���磺2008��9��1��15ʱ0��5���򷵻�2008��09��01��
     * @return ʱ�����ڵ�{@code String}
     */
    public static String getDate(Date date){
        return new SimpleDateFormat("yyyy��MM��dd��").format(new Date());
    }
    
    /**
     * ��ȡʱ���һ����ʾ��ʽ����ʽΪ��yyyy��MM��dd�� HH:mm:ss
     * <p>���磺2008��9��1��15ʱ0��5���򷵻�2008��09��01�� 15:00:05
     * @return ʱ�����ڵ�{@code String}
     */
    public static String getTime(Date date){
        return new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss").format(date);
    }
    
    /**
     * ��{@code 0}������{@code String}֮ǰ�Ը�ʽ��{@code String}
     * @param s ��Ҫ��ʽ����{@code String}
     * @param length ��ʽ������
     * @return ��ʽ��֮����ַ���
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

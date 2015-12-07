package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 数据层实现的工具类，提供数据层通用方法
 * @author 林祖华
 * @version 1.3
 */
public class DataUtil {
	
	public static void writeObject(Object obj,String filePath){
        FileWriter fw;
        File file = new File(filePath);
        
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            fw = new FileWriter(file);
            fw.write("");
            fw.close();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
	//这里有问题 ioexception的处理机制
    public static Object readObject(String filePath){
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = oos.readObject();
            oos.close();
            return obj;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return null;
    }
    
    public static File[] getAll(String filePath) {
        File file=new File(filePath);
        File[] tempList = file.listFiles();
        return tempList;
    }

}

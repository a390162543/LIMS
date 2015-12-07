package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.DataIdentifiable;
import dataservice.IdDataService;

/**
 * {@code IdData}是id数据层服务的实现类
 * @author 林祖华
 * @version 1.4
 */
public class IdData extends UnicastRemoteObject implements IdDataService{

    /**
     * 
     */
    private static final long serialVersionUID = 7594122418762269450L;
    
    private DataIdentifiable dataService;
    
    protected IdData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public IdData(DataIdentifiable dataService) throws RemoteException {
        super();
        this.dataService = dataService;
    }
    
    @Override
    public String getId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/IdData/"+dataService.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateId(String tag, String id) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/IdData/"+dataService.getClass().getSimpleName()+"/"+fileName+".ser";
        write(path, id);
        return true;
    }
    
    private static String read(String filePath){
        File file = new File(filePath);
        if(!file.exists())
            return "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            br.close();
            return line;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    
    private static boolean write(String filePath, String str){
        File file = new File(filePath);
        if(!file.exists())
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}

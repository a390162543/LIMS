package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import dataservice.UserDataService;
/**
 * {@code USerData}是用户数据层的实现类，提供数据层所有服务
 * @author 刘航伸
 *@version 1.2
 */
public class UserData extends UnicastRemoteObject implements UserDataService{

	protected UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5740039002234436612L;
 

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getId();
	    String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	    DataUtil.writeObject(po, path);
	}

	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getId();
	    String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	    DataUtil.writeObject(po, path);
	}

	@Override
	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		File file = new File(path);
		if(file.exists()){
			UserPO po =(UserPO) DataUtil.readObject(path);
			return po;
		}
		else 
			return null;
		
	}

	@Override
	public List<UserPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<UserPO> pos = new ArrayList<UserPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                UserPO po = (UserPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		 try {
	           LocateRegistry.createRegistry(1099);
	        } catch (Exception e) {
	        }

	        try {
	            Naming.rebind("rmi://localhost/"+this.getClass().getSimpleName(),  this);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("Server is on.");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}

package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import po.ConstantPO; 
import dataservice.ConstantDataService;
 
/**
 * {@code ConstantData}是价格数据层的实现类，提供数据层所有服务
 * @author 刘航伸
 *@version 1.2
 */
public class ConstantData extends UnicastRemoteObject implements ConstantDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9039436740802213791L;

	protected ConstantData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public void delete(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		  String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+".ser";
	       new File(path).delete();
	}

	@Override
	public void update(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public ConstantPO getConstantPO() throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+".ser";
		ConstantPO po =(ConstantPO) DataUtil.readObject(path);
		return po;
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		 ConstantDataService cds = new ConstantData();
	        try {
	            LocateRegistry.createRegistry(1099);
	        } catch (Exception e) {
	        }

	        try {
	            Naming.rebind("rmi://localhost/"+cds.getClass().getSimpleName(),cds);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("Server is on.");
	}

}

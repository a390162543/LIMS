package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

 


import po.OrganizationPO;
 
import dataservice.OrganizationDataService;

/**
 * {@code OrganizationData}是机构数据层的实现类，提供数据层所有服务
 * @author 刘航伸
 *@version 1.2
 */
public class OrganizationData extends UnicastRemoteObject implements OrganizationDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7432011421854910742L;
	 

	protected OrganizationData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void insert(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}


	@Override
	public void delete(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();
	}


	@Override
	public void update(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}


	@Override
	public OrganizationPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		File file = new File(path);
		if(file.exists()){
			OrganizationPO po =(OrganizationPO) DataUtil.readObject(path);
			return po;
		}
		else{
			return null;
		}
		 
	}


	@Override
	public List<OrganizationPO> finds(String field, Object value)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrganizationPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		 String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
	        List<OrganizationPO> pos = new ArrayList<OrganizationPO>();
	        try{
	            File[] files = DataUtil.getAll(path);
	            for(File f : files){
	                OrganizationPO po = (OrganizationPO) DataUtil.readObject(f.getAbsolutePath());
	                pos.add(po);
	            }
	        }catch(NullPointerException e){
	            return pos;
	        }
	        return pos;
	}


	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		 OrganizationDataService ods = new OrganizationData();
	        try {
	            LocateRegistry.createRegistry(1099);
	        } catch (Exception e) {
	        }

	        try {
	            Naming.rebind("rmi://localhost/"+ods.getClass().getSimpleName(), ods);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("Server is on.");
	}


	@Override
	public String getId(String name) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> pos = getAll();
		String id = "";
		for(OrganizationPO po : pos){
			if(po.getName().equals(name))
				id = po.getId();
		}
		return id;
	}


	@Override
	public boolean isAvailable(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return find(id) == null;
	}

	 

}

package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.OrderPO;
import dataservice.OrderDataService;

public class OrderData extends UnicastRemoteObject implements OrderDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524954244047458118L;


	


	protected OrderData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void insert(OrderPO po) throws RemoteException {
		String fileName = po.getOrderId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);	
	}

	
	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getOrderId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);	
	}

	
	public OrderPO find(String id) throws RemoteException {
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		OrderPO po = (OrderPO)DataUtil.readObject(path);
		return po;
	}

	
	public List<OrderPO> finds(String field, Object value)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<OrderPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
		List<OrderPO> pos = new ArrayList<OrderPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                OrderPO po = (OrderPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
    }
	

	
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		OrderDataService ods = new OrderData();
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {			
		}
		try {
			Naming.rebind("rmi://localhost/"+ods.getClass().getSimpleName(), ods);
		} catch (MalformedURLException e) {
			
		}
		System.out.println("Server is on.");
	}

	
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	
	

}

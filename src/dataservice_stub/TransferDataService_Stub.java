package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.TransferPO;
import dataservice.TransferDataService;

public class TransferDataService_Stub implements TransferDataService{

	@Override
	public void insert(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Detele Succeed");
	}

	@Override
	public void update(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public TransferPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed");
		List<Long> l =new ArrayList<Long>();
		l.add((long) 1024);
		return new TransferPO(1024, new Date(), 1024, "Nanjin", "Beijin",
				1024, "Bob", l , 20.1);
	}

	@Override
	public List<TransferPO> finds(String field, Object value)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finds Succeed");
		List<Long> l =new ArrayList<Long>();
		l.add((long) 1024);
		List<TransferPO> t = new ArrayList<TransferPO>();
		t.add(new TransferPO(1024, new Date(), 1024, "Nanjin", "Beijin",
				1024, "Bob", l , 20.1));
		return t;
	}

	@Override
	public List<TransferPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("GetAll Succeed");
		List<Long> l =new ArrayList<Long>();
		l.add((long) 1024);
		List<TransferPO> t = new ArrayList<TransferPO>();
		t.add(new TransferPO(1024, new Date(), 1024, "Nanjin", "Beijin",
				1024, "Bob", l , 20.1));
		return t;

	}
	
   public void init() throws RemoteException{
	   System.out.println("Init Succeed");
   }
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed");
	}

}

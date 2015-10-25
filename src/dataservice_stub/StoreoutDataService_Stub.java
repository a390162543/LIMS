package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.DocumentState;
import systemenum.ShipForm;
import dataservice.StoreoutDataService;

public class StoreoutDataService_Stub implements StoreoutDataService {
	
	long id;
	DocumentState documentState;
	List<Long> orderId;
	Date date;
	List<String> destination;
	List<ShipForm> shipForm;
	long transferId;
	
	
	
	public StoreoutDataService_Stub(long id, List<Long> orderId, Date date,
			List<String> destination, List<ShipForm> shipForm, long transferId) {
		super();
		this.documentState = DocumentState.PENDING;
		this.id = id;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
	}

	@Override
	public void insert(StoreoutPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	@Override
	public void update(StoreoutPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");

	}

	@Override
	public StoreoutPO find(long id) throws RemoteException {
		StoreoutPO po = new StoreoutPO(this.id, orderId, date, destination, shipForm, transferId);
		return po;
	}

	@Override
	public List<StoreoutPO> finds(String field, Object value)
			throws RemoteException {
		List<StoreoutPO> storeoutPOs = new ArrayList<StoreoutPO>();
		storeoutPOs.add(new StoreoutPO(this.id, orderId, date, destination, shipForm, transferId));
		return storeoutPOs;
	}

	@Override
	public List<StoreoutPO> getAll() throws RemoteException {
		List<StoreoutPO> storeoutPOs = new ArrayList<StoreoutPO>();
		storeoutPOs.add(new StoreoutPO(this.id, orderId, date, destination, shipForm, transferId));
		return storeoutPOs;
	}

	@Override
	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("Finish Succeed!\n");
	}

}

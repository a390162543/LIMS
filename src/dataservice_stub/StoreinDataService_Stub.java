package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoreinPO;
import systemenum.DocumentState;
import dataservice.StoreinDataService;

public class StoreinDataService_Stub implements StoreinDataService {
	
	String id;
	DocumentState documentState;
	List<String> orderId;
	Date inDate;
	String destination; 
	List<Integer> areaNum;
	List<Integer> rowNum;
	List<Integer> frameNum;
	List<Integer> item;
	
	

	public StoreinDataService_Stub(String id,
			List<String> orderId, Date inDate, String destination,
			List<Integer> areaNum, List<Integer> rowNum,
			List<Integer> frameNum, List<Integer> item) {
		super();
		this.id = id;
		this.documentState = DocumentState.PENDING;
		this.orderId = orderId;
		this.inDate = inDate;
		this.destination = destination;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}

	
	@Override
	public void insert(StoreinPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	@Override
	public void update(StoreinPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public StoreinPO find(String id) throws RemoteException {
		StoreinPO po = new StoreinPO(this.id, orderId, inDate, destination, areaNum, rowNum, frameNum, item);
		return po;
	}

	@Override
	public List<StoreinPO> finds(String field, Object value)
			throws RemoteException {
		List<StoreinPO> storeinPOs = new ArrayList<StoreinPO>();
		storeinPOs.add(new StoreinPO(this.id, orderId, inDate, destination, areaNum, rowNum, frameNum, item));
		return storeinPOs;
	}

	@Override
	public List<StoreinPO> getAll() throws RemoteException {
		List<StoreinPO> storeinPOs = new ArrayList<StoreinPO>();
		storeinPOs.add(new StoreinPO(this.id, orderId, inDate, destination, areaNum, rowNum, frameNum, item));
		return storeinPOs;
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

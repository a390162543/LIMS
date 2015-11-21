package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.PrimeInfoPO;
import dataservice.PrimeInfoDataService;

public class PrimeInfoDataService_Stub implements PrimeInfoDataService{
	
	PrimeInfoPO po;
	
	public PrimeInfoDataService_Stub(PrimeInfoPO po){
		this.po=po;
	}

	public void insert(PrimeInfoPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	public List<PrimeInfoPO> getAll() throws RemoteException {
		System.out.println("getAll Succeed!\n");
		List<PrimeInfoPO> list=new ArrayList<PrimeInfoPO>();
		list.add(po);
		return list;
	}

	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	public void finish() throws RemoteException {
		System.out.println("Finished!\n");
	}

}

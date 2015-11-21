package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import dataservice.AccountDataService;

public class AccountDataService_Stub implements AccountDataService{
	
	AccountPO po;
	
	public AccountDataService_Stub(AccountPO po){
		this.po=po;
	}

	public void insert(AccountPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	public void delete(AccountPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}

	public void update(AccountPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
	public AccountPO find(String id) throws RemoteException {
		System.out.println("find Succeed!\n");
		return po;
	}
	public List<AccountPO> getAll() throws RemoteException {
		System.out.println("getAll Succeed!\n");
		List<AccountPO> list=new ArrayList<AccountPO>();
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

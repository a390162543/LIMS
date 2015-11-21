package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LogPO;
import dataservice.LogDataService;

public class LogDataService_Stub implements LogDataService {

	LogPO po;
	
	public LogDataService_Stub(LogPO po){
		this.po=po;
	}

	public void insert(LogPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	public List<LogPO> finds(String field, Object value) throws RemoteException {
		System.out.println("finds Succeed!\n");
		List<LogPO> list=new ArrayList<LogPO>();
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

package dataservice_stub;

import java.rmi.RemoteException;

import po.ConstantPO;
import dataservice.ConstantDataService;
import vo.ConstantVO;
import businesslogicservice.ConstantblService;

public class ConstantDataService_Stub implements ConstantDataService{

	@Override
	public void insert(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed");
	}

	@Override
	public void update(ConstantPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public ConstantPO getConstantPO() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Get Succeed");
		return new ConstantPO();
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed");
		
	}

	 
	 
}

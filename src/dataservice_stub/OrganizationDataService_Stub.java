package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.OrganizationPO;
import dataservice.OrganizationDataService;

public class OrganizationDataService_Stub implements OrganizationDataService{

	@Override
	public void insert(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Detele Succeed");
	}

	@Override
	public void update(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public OrganizationPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub		
		return new OrganizationPO(1024, "Nanjin edu", "Nanjin");
	}

	@Override
	public List<OrganizationPO> finds(String field, Object value)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> o = new ArrayList<OrganizationPO>();
		o.add(new OrganizationPO(1024, "Nanjin edu", "Nanjin"));
		return o;
	}

	@Override
	public List<OrganizationPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> o = new ArrayList<OrganizationPO>();
		o.add(new OrganizationPO(1024, "Nanjin edu", "Nanjin"));
		return o;
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed");
	}

}

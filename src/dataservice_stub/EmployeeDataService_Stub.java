package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.EmployeePO;
import systemenum.Position;
import systemenum.Sex;
import dataservice.EmployeeDataService;

public class EmployeeDataService_Stub implements EmployeeDataService{

	@Override
	public void insert(EmployeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(EmployeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Detele Succeed");
	}

	@Override
	public void update(EmployeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public EmployeePO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed");
		return new EmployeePO(1024, "Ahri", "Nanjin edu", Position.COURIER,new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE);
	}

	@Override
	public List<EmployeePO> finds(String field, Object value)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finds Succeed");
		List<EmployeePO> e = new ArrayList<EmployeePO>();
		e.add(new EmployeePO(1024, "Ahri", "Nanjin edu", Position.COURIER,
				new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE));
		return e;
	}

	@Override
	public List<EmployeePO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("GetAll Succeed");
		List<EmployeePO> e = new ArrayList<EmployeePO>();
		e.add(new EmployeePO(1024, "Ahri", "Nanjin edu", Position.COURIER,
				new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE));
		return e;
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed"); 
	}

}

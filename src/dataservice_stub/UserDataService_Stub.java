package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import systemenum.Power;
import dataservice.UserDataService;
 

public class UserDataService_Stub implements UserDataService{

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Detele Succeed");
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed");
		return new UserPO(1024, "1024" );
	}

	 

	@Override
	public List<UserPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("GetAll Succeed");
		List<UserPO> u = new ArrayList<UserPO>();
		u.add(new UserPO(1024, "1024" ));
		return u;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeed");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed");
	}

}

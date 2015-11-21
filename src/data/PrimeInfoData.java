package data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.PrimeInfoPO;
import dataservice.PrimeInfoDataService;

public class PrimeInfoData extends UnicastRemoteObject implements PrimeInfoDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4602565310193511710L;

	public PrimeInfoData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
	}

	@Override
	public void insert(PrimeInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PrimeInfoPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}

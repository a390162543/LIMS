package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fileName = sdf.format(po.getDate());
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);		
	}


	@Override
	public List<PrimeInfoPO> getAll() throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<PrimeInfoPO> pos = new ArrayList<PrimeInfoPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
            	PrimeInfoPO po = (PrimeInfoPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
		PrimeInfoDataService pds = new PrimeInfoData();
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
        }

        try {
            Naming.rebind("rmi://localhost/"+pds.getClass().getSimpleName(), pds);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Server is on.");
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}

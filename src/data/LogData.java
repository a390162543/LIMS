package data;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import po.LogPO;

import dataservice.LogDataService;

public class LogData extends UnicastRemoteObject implements LogDataService {



    /**
	 * 
	 */
	private static final long serialVersionUID = -2077154000960171417L;

	protected LogData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(LogPO po) throws RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-MM-SS");  
        String fileName = sdf.format( po.getDate());
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);	
	}

	@Override
	public List<LogPO> finds(String field, Object value) throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<LogPO> pos = new ArrayList<LogPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                LogPO po = (LogPO) DataUtil.readObject(f.getAbsolutePath());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                       
                if(sdf.format(po.getDate()).equals(sdf.format((Date)value)))
                	pos.add(po);
                             
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
        LogDataService lds = new LogData();
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
        }

        try {
            Naming.rebind("rmi://localhost/"+lds.getClass().getSimpleName(), lds);
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

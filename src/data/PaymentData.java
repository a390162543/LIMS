package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.PaymentPO;
import systemenum.DocumentState;
import dataservice.PaymentDataService;

public class PaymentData extends UnicastRemoteObject implements PaymentDataService{
    private static final long serialVersionUID = 1681492939084373146L;

    protected PaymentData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(PaymentPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
		
	}

	@Override
	public void update(PaymentPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);		
	}

	@Override
	public PaymentPO find(String id) throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+id+".ser";
		File file = new File(path);
		return (PaymentPO) DataUtil.readObject(file.getAbsolutePath());
	}

	@Override
	public List<PaymentPO> finds(String field, Object value)
			throws RemoteException {
		
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<PaymentPO> pos = new ArrayList<PaymentPO>();
        try{
        	File[] files = DataUtil.getAll(path);
	        for(File f : files){
		        PaymentPO po = (PaymentPO) DataUtil.readObject(f.getAbsolutePath());
		        switch(field){
			        case "date" :
			        	if(po.getDate().after((Date)value)||po.getDate().equals((Date)value))
			        		pos.add(po);
			        	break;
			        case "documentState":
			        	if(po.getDocumentState().equals((DocumentState)value))
			        		pos.add(po);
			        	break;
		        }
	        }
	    }
        catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
		PaymentDataService pds = new PaymentData();
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

	@Override
	public boolean isAvailable(String id) throws RemoteException {
		
		return find(id) == null;
	}
	
}

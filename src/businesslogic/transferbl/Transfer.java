package businesslogic.transferbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.TransferDataService; 
import po.TransferPO;
import businesslogicservice.TransferblService; 
import vo.TransferVO;

public class Transfer implements TransferblService{
	
	public double getCost(TransferVO vo){
		return 0;
	}

	@Override
	public boolean createTransferPO(TransferVO vo) {
		// TODO Auto-generated method stub
		try { 
        	TransferDataService tds = (TransferDataService) Naming.lookup
        			("rmi://localhost/TransferData");
			tds.insert(vo.getTransferPO());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean modify(TransferVO vo) {
		// TODO Auto-generated method stub
		try { 
        	TransferDataService tds = (TransferDataService) Naming.lookup
        			("rmi://localhost/TransferData");
			tds.update(vo.getTransferPO());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<TransferVO> getTransferVO() {
		// TODO Auto-generated method stub
		List<TransferVO> vos =  new ArrayList<TransferVO>();
		 try {
			 TransferDataService tds = (TransferDataService) Naming.lookup
	        			("rmi://localhost/TransferData");
			 List<TransferPO> pos= tds.getAll();
			 for(TransferPO po : pos){
				 vos.add(po.getTransferVO());
			 }
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return vos;
	}

	@Override
	public boolean execute(TransferVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
}

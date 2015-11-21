package businesslogic.constantbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import vo.ConstantVO;
import dataservice.ConstantDataService;
import businesslogicservice.ConstantblService;

 

public class Constant implements ConstantblService{

	@Override
	public boolean modifyPrice(ConstantVO vo) {
		// TODO Auto-generated method stub
		  try { 
	        	ConstantDataService cds = (ConstantDataService) Naming.lookup("rmi://localhost/ConstantData");
				cds.insert(vo.getConsstantPO());
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
	public ConstantVO getPrice() {
		double price = 0.0;
		// TODO Auto-generated method stub
		  try { 
	        	ConstantDataService cds = (ConstantDataService) Naming.lookup("rmi://localhost/ConstantData");
	        	if(cds.getConstantPO() != null)
	        		price = cds.getConstantPO().getPrice();
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
		
		return new ConstantVO(price);
	}
	
	
	 
}

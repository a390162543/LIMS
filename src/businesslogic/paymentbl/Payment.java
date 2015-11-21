package businesslogic.paymentbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.PaymentPO;
import dataservice.PaymentDataService;
import vo.PaymentVO;
import businesslogicservice.PaymentblService;

public class Payment implements PaymentblService{

	@Override
	public boolean createPaymentPO(PaymentVO vo) {
        try {
        	PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
            pds.insert(vo.getPaymentPO());
        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        } catch (NotBoundException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean modifyPaymentPO(PaymentVO vo) {
        try {
        	PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
            PaymentPO po = pds.find(vo.getId());
            po.update(vo);      	
        	pds.update(po);
        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        } catch (NotBoundException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean execute(PaymentVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}

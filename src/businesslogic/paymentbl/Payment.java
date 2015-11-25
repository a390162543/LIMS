package businesslogic.paymentbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.PaymentPO;
import systemenum.DocumentState;
import dataservice.PaymentDataService;
import vo.PaymentVO;
import businesslogic.accountbl.Account;
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
		 try {	        	
			PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
			PaymentPO po = pds.find(vo.getId());
			po.setDocumentState(DocumentState.PASS);
	    	pds.update(po);
	    	
	    	Account account = new Account(); 
	    	account.updateAccountBalance(po.getAccountId(), -po.getMoney());
	    } catch (MalformedURLException e) {
	    	
	        e.printStackTrace();
	    } catch (RemoteException e) {
	    	
	        e.printStackTrace();
	    } catch (NotBoundException e) {
	    	
	        e.printStackTrace();
	    }
		return true;
	}


	public List<PaymentVO> getPendingPaymentVO() {
		List<PaymentVO> vos = new ArrayList<PaymentVO>() ;
        try {
        	PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
        	List<PaymentPO> pos = pds.finds("documentState", DocumentState.PENDING);
        	for(PaymentPO po: pos)
        		vos.add(po.getPaymentVO());
        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        } catch (NotBoundException e) {
        	
            e.printStackTrace();
        }
        return vos;
	}

	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate){
		 List<PaymentVO> vos = new ArrayList<PaymentVO>();
	        try {
	        	PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
	            List<PaymentPO> pos = pds.finds("date", begindate);
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            for(PaymentPO po : pos){
	            	if((po.getDate().before(enddate)||sdf.format(po.getDate()).equals(sdf.format(enddate)))&&po.getDocumentState().equals(DocumentState.PASS))
	            		vos.add(po.getPaymentVO());
	            }
	        } catch (MalformedURLException e) {

	            e.printStackTrace();
	        } catch (RemoteException e) {

	            e.printStackTrace();
	        } catch (NotBoundException e) {
	  
	            e.printStackTrace();
	        }
	        return vos;
	}
}

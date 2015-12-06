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
import businesslogic.idbl.PaymentIdManager;
import businesslogicservice.IdblService;
import businesslogicservice.PaymentblService;

public class Payment implements PaymentblService{

	private PaymentDataService paymentDataService;
	
	 public Payment(){
	        try {
	            paymentDataService = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
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
	    }
	@Override
	public boolean createPaymentPO(PaymentVO vo) {
        try {     
        	paymentDataService.insert(vo.getPaymentPO());
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean modifyPaymentPO(PaymentVO vo) {
        try {
            PaymentPO po = paymentDataService.find(vo.getId());
            po.update(vo);      	
            paymentDataService.update(po);
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean execute(PaymentVO vo) {
		 try {	        	
			PaymentPO po = paymentDataService.find(vo.getId());
			po.setDocumentState(DocumentState.PASS);
			paymentDataService.update(po);
	    	
	    	Account account = new Account(); 
	    	account.updateAccountBalance(po.getAccountId(), -po.getMoney());
	    } catch (RemoteException e) {
	    	
	        e.printStackTrace();
	    }
		return true;
	}


	public List<PaymentVO> getPendingPaymentVO() {
		List<PaymentVO> vos = new ArrayList<PaymentVO>() ;
        try {
        	List<PaymentPO> pos = paymentDataService.finds("documentState", DocumentState.PENDING);
        	for(PaymentPO po: pos)
        		vos.add(po.getPaymentVO());
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        }
        return vos;
	}

	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate){
		 List<PaymentVO> vos = new ArrayList<PaymentVO>();
	        try {
	            List<PaymentPO> pos = paymentDataService.finds("date", begindate);
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            for(PaymentPO po : pos){
	            	if((po.getDate().before(enddate)||sdf.format(po.getDate()).equals(sdf.format(enddate)))&&po.getDocumentState().equals(DocumentState.PASS))
	            		vos.add(po.getPaymentVO());
	            }
	        } catch (RemoteException e) {

	            e.printStackTrace();
	        }
	        return vos;
	}

	@Override
	public IdblService getIdblService() {
		
		return new PaymentIdManager(paymentDataService ,6);
	}
}

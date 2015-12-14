package businesslogic.paymentbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.PaymentPO;
import systemenum.DocumentState;
import dataservice.DataService;
import dataservice.PaymentDataService;
import vo.PaymentVO;
import businesslogic.accountbl.Account;
import businesslogic.idbl.PaymentIdManager;
import businesslogic.logbl.Log;
import businesslogicservice.IdblService;
import businesslogicservice.PaymentblService;

/**
 * {@code Payment}�Ǹ����ҵ���߼���ʵ���࣬�ṩ�����йظ����ҵ���߼�����
 * @author ���¿�
 * @version 1.6
 * @see dataservice.PaymentDataService
 */
public class Payment implements PaymentblService{

	private PaymentDataService paymentDataService;
	
	public Payment(){
		paymentDataService = DataService.getPaymentDataService();
	}
	@Override
	public boolean createPaymentPO(PaymentVO vo) {
        try {     
        	paymentDataService.insert(vo.getPaymentPO());
        	
        	Log log = new Log();
        	log.createLogPO("�������("+vo.getId()+")");
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
            
        	Log log = new Log();
        	log.createLogPO("�޸ĸ��("+vo.getId()+")");
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

    /**
     * ��ȡ���еĴ������ĸ����Ϣ
     * @return {@code PaymentVO}���б����û�и����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
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
	
    /**
     * ������ʼ���ڻ�ȡ���еĸ����Ϣ
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code PaymentVO}���б����û�и����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
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
	
	@Override
	public String[] getAllAccountId() {
		Account account = new Account();
		String[] accountId = account.getAllAccountId();
		return accountId;
	}
}

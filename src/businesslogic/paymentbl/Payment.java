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
 * {@code Payment}是付款单的业务逻辑的实现类，提供所有有关付款单的业务逻辑服务
 * @author 刘德宽
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
        	log.createLogPO("创建付款单("+vo.getId()+")");
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
        	log.createLogPO("修改付款单("+vo.getId()+")");
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
     * 获取所有的待审批的付款单信息
     * @return {@code PaymentVO}的列表，如果没有付款单信息或获取失败，则返回空列表
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
     * 根据起始日期获取所有的付款单信息
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code PaymentVO}的列表，如果没有付款单信息或获取失败，则返回空列表
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

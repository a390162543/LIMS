package businesslogicservice;

import java.util.List;
import vo.ArrivalVO;
import vo.DeliverVO;
import vo.LoadVO;
import vo.OrderCreateVO;
import vo.PaymentVO;
import vo.RevenueVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import vo.TransferVO;
public interface ApprovalblService {
	
 
	public boolean approveOrderVO(OrderCreateVO vo);
	
	public boolean approveDeliverVO(DeliverVO vo);
	
	public boolean approveLoadVO(LoadVO vo);
	
	public boolean apprivePaymentVO(PaymentVO vo);
	
	public boolean approveRevenueVO(RevenueVO vo);
	
	public boolean approveStoreinVO(StoreinCreateVO vo);
	
	public boolean approveStoreoutVO(StoreoutCreateVO vo);
	
	public boolean approveTransferVO(TransferVO vo);
	
	public boolean approveArrivalVO(ArrivalVO vo);
	
	
	public boolean modifyOrderVO(OrderCreateVO vo);
	
	public boolean modifyDeliverVO(DeliverVO vo);
	
	public boolean modifyLoadVO(LoadVO vo);
	
	public boolean modifyPaymentVO(PaymentVO vo);
	
	public boolean modifyRevenueVO(RevenueVO vo);
	
	public boolean modifyStoreinVO(StoreinCreateVO vo);
	
	public boolean modifyStoreoutVO(StoreoutCreateVO vo);
	
	public boolean modifyTransferVO(TransferVO vo);
	
	public boolean modifyArrivalVO(ArrivalVO vo);
	
 
	public List<OrderCreateVO>  getOrderVO();
	
	public List<DeliverVO>  getDeliverVO();
	
	public List<LoadVO>  getLoadVO();
	
	public List<PaymentVO>  getPaymentVO();
	
	public List<RevenueVO>  getRevenueVO();
	
	public List<StoreinCreateVO>  getStoreinVO();
	
	public List<StoreoutCreateVO>  getStoreoutVO();
	
	public List<TransferVO>  getTransferVO();
	
	public List<ArrivalVO>  getArrivalVO();
}

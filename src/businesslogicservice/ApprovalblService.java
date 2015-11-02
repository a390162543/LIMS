package businesslogicservice;
import java.util.List;


 









import po.ArrivalPO;
import po.DeliverPO;
import po.LoadPO;
import po.OrderPO;
import po.PaymentPO;
import po.RevenuePO;
import po.StoreinPO;
import po.StoreoutPO;
import po.TransferPO;
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
	
 
	public boolean approve(Object o);
	
	public boolean modify(Object o);
 
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

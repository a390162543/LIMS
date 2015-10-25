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
public interface ApprovalblService {
	
 
	public boolean approve(Object o);
	
	public boolean modify(Object o);
 
	public List<OrderPO>  getOrderPO();
	
	public List<DeliverPO>  getDeliverPO();
	
	public List<LoadPO>  getLoadPO();
	
	public List<PaymentPO>  getPaymentPO();
	
	public List<RevenuePO>  getRevenuePO();
	
	public List<StoreinPO>  getStoreinPO();
	
	public List<StoreoutPO>  getStoreoutPO();
	
	public List<TransferPO>  getTransferPO();
	
	public List<ArrivalPO>  getArrivalPO();
}

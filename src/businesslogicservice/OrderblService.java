package businesslogicservice;

import systemenum.DeliveryWay;
import systemenum.WrapWay;
import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;

public interface OrderblService {
	
	
	public boolean createOrderPO(OrderCreateVO vo);
	
	
	public boolean signOrder(OrderSignVO vo);
	
	public boolean modifyOrder(OrderCreateVO vo);
	
	
	//return the information of the order delivery
	public OrderQueryVO returnOrderQueryVO(long orderId);
	
	
	//compute the total expense of the current order
	public double getTotal(OrderCreateVO vo);
	
	
	//compute the estimated time
	public int getEximatedTime(OrderCreateVO vo);
	
	
	public boolean excute(OrderCreateVO vo);
	
}

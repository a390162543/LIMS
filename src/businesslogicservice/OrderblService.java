package businesslogicservice;

import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;

public interface OrderblService {
	
	
	public boolean createOrderPO(OrderCreateVO vo);
	
	
	public boolean signOrder(OrderSignVO vo);
	
	public boolean modifyOrder(OrderCreateVO vo);
	
	
	//return the information of the order delivery
	public OrderQueryVO returnOrderQueryVO(String orderId);
	
	
	//compute the total expense of the current order
	public double getTotal(OrderCreateVO vo);
	
	
	//compute the estimated time
	public int getEximatedTime(String senderAddress, String receiverAddress);
	
	
	public boolean execute(OrderCreateVO vo);
	
}

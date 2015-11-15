package businesslogic.orderbl;

import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import businesslogicservice.OrderblService;

public class Order implements OrderblService{

	
	public boolean createOrderPO(OrderCreateVO vo) {
		
		return false;
	}

	
	public boolean signOrder(OrderSignVO vo) {
		
		return false;
	}

	
	public boolean modifyOrder(OrderCreateVO vo) {
		
		return false;
	}


	public OrderQueryVO returnOrderQueryVO(long orderId) {
		
		return null;
	}

	
	public double getTotal(OrderCreateVO vo) {
		
		return 0;
	}


	public int getEximatedTime(OrderCreateVO vo) {
		
		return 0;
	}

	
	public boolean excute(OrderCreateVO vo) {
		
		return false;
	}
	
	
}

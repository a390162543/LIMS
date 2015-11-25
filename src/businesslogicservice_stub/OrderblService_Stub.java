package businesslogicservice_stub;


import systemenum.GoodsState;
import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import businesslogicservice.OrderblService;

public class OrderblService_Stub implements OrderblService {
	
	double total;
	String id;
	GoodsState state;
	String deliverInfo;
	String nowLocation;
	String nextLocation;
	
	
	public OrderblService_Stub(double total, String id, GoodsState state,
			String deliverInfo, String nowLocation, String nextLocation) {
		super();
		this.total = total;
		this.id = id;
		this.state = state;
		this.deliverInfo = deliverInfo;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
	}

	
	@Override
	public boolean createOrderPO(OrderCreateVO vo) {
		return true;
	}

	@Override
	public boolean signOrder(OrderSignVO vo) {
		return true;
	}

	@Override
	public OrderQueryVO returnOrderQueryVO(String orderId) {
		return new OrderQueryVO(orderId, state, deliverInfo, nowLocation, nextLocation);
	}

	@Override
	public double getTotal(OrderCreateVO vo) {
		return total;
	}

	


	@Override
	public int getEximatedTime(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public boolean modifyOrder(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean execute(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}

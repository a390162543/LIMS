package businesslogicservice_stub;

import systemenum.DeliveryWay;
import systemenum.GoodsState;
import systemenum.WrapWay;
import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import businesslogicservice.OrderblService;

public class OrderblService_Stub implements OrderblService {
	
	double total;
	long id;
	GoodsState state;
	String deliverInfo;
	String nowLocation;
	String nextLocation;
	
	
	public OrderblService_Stub(double total, long id, GoodsState state,
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
	public OrderQueryVO returnOrderQueryVO(long orderId) {
		return new OrderQueryVO(orderId, state, deliverInfo, nowLocation, nextLocation);
	}

	@Override
	public double getTotal(OrderCreateVO vo) {
		return total;
	}

	@Override
	public boolean excute(OrderCreateVO vo) {	
		return true;
	}

	@Override
	public boolean modifyOrder(OrderCreateVO vo) {
		return true;
	}


	@Override
	public int getEximatedTime(OrderCreateVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

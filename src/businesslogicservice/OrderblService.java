package businesslogicservice;

import java.util.Date;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.WrapWay;

public interface OrderblService {
	
	
	public OrderPO createOrderPO(String senderName,String senderAddress, String senderTel,
			String senderCell, String receiverName, String receiverAddress, String receiverTel,
			String receiverCell, String goodsInfo, double weight, double size, WrapWay wrapWay, DeliveryWay deliverWay);
	
	
	public boolean signOrder(long orderId,String signName,Date date);
	
	
	//return the information of the order delivery
	public OrderPO returnOrderPO(long orderId);
	
	
	//compute the total expense of the current order
	public double getTotal(String senderAddress ,String receiverAddress,double weight,
			double size, WrapWay wrapWay, DeliveryWay deliverWay);
	
	
}

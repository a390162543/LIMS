package businesslogicservice_driver;

import java.util.Date;

import systemenum.DeliveryWay;
import systemenum.WrapWay;
import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import businesslogicservice.OrderblService;

public class OrderblService_Driver {
	
	public void drive(OrderblService orderblService) {
		String orderId = new String("1025000001");
		
		OrderCreateVO orderCreateVO = new OrderCreateVO(orderId, "张三", "南京市南京大学仙林校区", "86-020-12345687", "13812301230",
				"李四", "上海", "86-020-12345678",  "18312341234", "1件", 3.56, 2.56, 15.00, WrapWay.BAG, DeliveryWay.FAST);
		boolean orderCreateResult = orderblService.createOrderPO(orderCreateVO);
		System.out.println(orderCreateResult);
		
		OrderSignVO orderSignVO = new OrderSignVO(orderId, "李四", new Date());
		boolean orderSignResult = orderblService.signOrder(orderSignVO);
		System.out.println(orderSignResult);
		
		boolean orderModifyResult = orderblService.modifyOrder(orderCreateVO);
		System.out.println(orderModifyResult);
		
		OrderQueryVO orderQueryVO = orderblService.returnOrderQueryVO(orderId);
		System.out.println(orderQueryVO.getId()==orderId);
		
		double cost = orderblService.getTotal(orderCreateVO);
		System.out.println(cost);
		
		boolean excuteResult = orderblService.excute(orderCreateVO);
		System.out.println(excuteResult);
		
		
	}

}

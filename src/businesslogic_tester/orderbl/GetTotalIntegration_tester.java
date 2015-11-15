package businesslogicservice_tester.orderbl;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.orderbl.Order;
import systemenum.DeliveryWay;
import systemenum.WrapWay;
import vo.OrderCreateVO;



public class GetTotalIntegration_tester {
	
	@Test
	public void testGetTotal(){
		
		
		MockConstant constant = new MockConstant(200, 15);
		
		long orderId = new Long("1025000001");
		OrderCreateVO orderCreateVO = new OrderCreateVO(orderId, "张三", "南京市南京大学仙林校区", 
				"86-020-12345687", "13812301230","李四", "上海", "86-020-12345678",  "18312341234", 
				"1件", 3.56, 2.56, 15.00, WrapWay.BAG, DeliveryWay.FAST);
		Order order = new Order();
		
		assertEquals(30,order.getTotal(orderCreateVO));
			
	}

}

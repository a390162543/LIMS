package businesslogic_tester.trasferbl;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.constantbl.Constant;
import businesslogic.transferbl.GoodsList;
 

public class CostIntegration_tester {
	
	@Test
	public void testCost(){
		MockGoodsVO goods1 = new MockGoodsVO(20.0);
		MockGoodsVO goods2 = new MockGoodsVO(40.0);
		Constant constant = new Constant();
		GoodsList goodsList = new GoodsList();
		goodsList.add(goods1);
		goodsList.add(goods2);
		
		assertEquals (60.0,goodsList.getWeight()); 
		  
		
	}
}

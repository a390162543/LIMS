package businesslogic_tester.storeinbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.junit.Test;

import businesslogic.storeinbl.Storein;
import vo.StoreinCreateVO;

public class StoreinIntegration_tester {
	
	@Test
	public void testStorein(){
		
		MockStorage storage = new MockStorage(0.9, 200, 150);
		
		String storeinId = new String("0250151025000001");
		List<String> orderId= new ArrayList<String>();
		String destination;
		List<Integer> areaNum= new ArrayList<Integer>();
		List<Integer> rowNum= new ArrayList<Integer>();
		List<Integer> frameNum= new ArrayList<Integer>();
		List<Integer> item= new ArrayList<Integer>();
		orderId.add(new String("1025000001"));
		destination = "南京市栖霞区中转中心";
		areaNum.add(10);
		rowNum.add(20);
		frameNum.add(30);
		item.add(10);
		StoreinCreateVO storeinCreateVO = new StoreinCreateVO(storeinId, orderId, new Date(), destination, areaNum, rowNum, frameNum, item);
		
		Storein storein = new Storein();
		storein.createStoreinPO(storeinCreateVO);
		
		assertEquals(false,storein.createStoreinPO(storeinCreateVO));
		
	}

}

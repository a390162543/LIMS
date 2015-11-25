package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.StoreinCreateVO;
import businesslogicservice.StoreinblService;

public class StoreinblService_Driver {
	
	public void drive(StoreinblService storeinblService){
		
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
		
		boolean createStoreinResult = storeinblService.createStoreinPO(storeinCreateVO);
		System.out.println(createStoreinResult);
		
		boolean modifyStoreinResult = storeinblService.modifyStorein(storeinCreateVO);
		System.out.println(modifyStoreinResult);
		
		boolean excuteStoreinResult = storeinblService.execute(storeinCreateVO);
		System.out.println(excuteStoreinResult);
		
	}

}

package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.StoreinCreateVO;
import businesslogicservice.StoreinblService;

public class StoreinblService_Driver {
	
	public void drive(StoreinblService storeinblService){
		
		long storeinId = new Long("0250151025000001");
		List<Long> orderId= new ArrayList<Long>();
		List<String> destination = new ArrayList<String>();
		List<Integer> areaNum= new ArrayList<Integer>();
		List<Integer> rowNum= new ArrayList<Integer>();
		List<Integer> frameNum= new ArrayList<Integer>();
		List<Integer> item= new ArrayList<Integer>();
		orderId.add(new Long("1025000001"));
		destination.add("南京市栖霞区中转中心");
		areaNum.add(10);
		rowNum.add(20);
		frameNum.add(30);
		item.add(10);
		
		StoreinCreateVO storeinCreateVO = new StoreinCreateVO(storeinId, orderId, new Date(), destination, areaNum, rowNum, frameNum, item);
		
		boolean createStoreinResult = storeinblService.createStoreinPO(storeinCreateVO);
		System.out.println(createStoreinResult);
		
		boolean modifyStoreinResult = storeinblService.modifyStorein(storeinCreateVO);
		System.out.println(modifyStoreinResult);
		
		boolean excuteStoreinResult = storeinblService.excute(storeinCreateVO);
		System.out.println(excuteStoreinResult);
		
	}

}

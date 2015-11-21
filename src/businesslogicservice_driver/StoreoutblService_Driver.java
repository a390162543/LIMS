package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.ShipForm;
import vo.StoreoutCreateVO;
import businesslogicservice.StoreoutblService;

public class StoreoutblService_Driver {
	
	public void drive(StoreoutblService storeoutblService){
		
		String storeinId = new String("0250151025000001");
		String transferId = new String("02501510250000001");
		List<String> orderId= new ArrayList<String>();
		String destination;
		ShipForm shipForm;
		orderId.add(new String("1025000001"));
		destination = "南京市栖霞区中转中心";
		shipForm = ShipForm.CAR;
		
		
		StoreoutCreateVO storeoutCreateVO = new StoreoutCreateVO(storeinId, orderId, new Date(), destination,shipForm,transferId);
		
		boolean createStoreoutResult = storeoutblService.createStoreoutPO(storeoutCreateVO);
		System.out.println(createStoreoutResult);
		
		boolean modifyStoreoutResult = storeoutblService.modifyStoreout(storeoutCreateVO);
		System.out.println(modifyStoreoutResult);
		
		boolean excuteStoreoutResult = storeoutblService.excute(storeoutCreateVO);
		System.out.println(excuteStoreoutResult);
		
	}
}

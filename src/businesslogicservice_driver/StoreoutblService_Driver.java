package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.ShipForm;
import vo.StoreoutCreateVO;
import businesslogicservice.StoreoutblService;

public class StoreoutblService_Driver {
	
	public void drive(StoreoutblService storeoutblService){
		
		long storeinId = new Long("0250151025000001");
		long transferId = new Long("02501510250000001");
		List<Long> orderId= new ArrayList<Long>();
		List<String> destination = new ArrayList<String>();
		List<ShipForm> shipForm = new ArrayList<ShipForm>();
		orderId.add(new Long("1025000001"));
		destination.add("南京市栖霞区中转中心");
		shipForm.add(ShipForm.CAR);
		
		
		StoreoutCreateVO storeoutCreateVO = new StoreoutCreateVO(storeinId, orderId, new Date(), destination,shipForm,transferId);
		
		boolean createStoreoutResult = storeoutblService.createStoreoutPO(storeoutCreateVO);
		System.out.println(createStoreoutResult);
		
		boolean modifyStoreoutResult = storeoutblService.modifyStoreout(storeoutCreateVO);
		System.out.println(modifyStoreoutResult);
		
		boolean excuteStoreoutResult = storeoutblService.excute(storeoutCreateVO);
		System.out.println(excuteStoreoutResult);
		
	}
}

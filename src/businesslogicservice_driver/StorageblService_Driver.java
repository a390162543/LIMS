package businesslogicservice_driver;

import java.util.Date;
import java.util.List;

import vo.StorageCheckVO;
import vo.StorageSetAreaVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import businesslogicservice.StorageblService;

public class StorageblService_Driver {
	
	public void drive(StorageblService storageblService){
		
		StorageSetAreaVO storageSetAreaVO = new StorageSetAreaVO(new String("0250"),10, 50, 90, 50,0.8);
		boolean storageSetAreaResult = storageblService.setArea(storageSetAreaVO);
		System.out.println(storageSetAreaResult);
		
		Date inDate = new Date();
		Date toDate = new Date();
		List<StorageCheckVO> storageCheckVOs = storageblService.storeCheck(inDate);
		for(int i=0;i<storageCheckVOs.size();i++){
			if(((StorageCheckVO)storageCheckVOs.get(i)).getInDate()!=inDate)
				System.out.println(false);
		}
		
		boolean alarmResult = storageblService.isExceeded();
		System.out.println(alarmResult);
		
		System.out.println(storageblService.gainExcel());
		
		System.out.println(storageblService.setAlarm(0.9));
		
		List<StoreoutCreateVO> storeoutCreateVOs = storageblService.storeoutQuery(inDate, toDate);
		for(int i=0;i<storeoutCreateVOs.size();i++){
			System.out.println(((StoreoutCreateVO)storeoutCreateVOs.get(i)).getDate());
		}
		
		List<StoreinCreateVO> storeinCreateVOs = storageblService.storeinQuery(inDate, toDate);
		for(int i=0;i<storeinCreateVOs.size();i++){
			System.out.println(((StoreinCreateVO)storeinCreateVOs.get(i)).getInDate());
		}
	}

}

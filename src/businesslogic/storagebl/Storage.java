package businesslogic.storagebl;

import java.util.Date;
import java.util.List;

import vo.StorageCheckVO;
import vo.StorageSetAreaVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import businesslogicservice.StorageblService;

public class Storage implements StorageblService{


	public boolean setArea(StorageSetAreaVO vo) {
		
		return false;
	}

	
	public List<StorageCheckVO> storeCheck(Date date) {
		
		return null;
	}

	
	public boolean isExceeded() {
		
		return false;
	}


	public boolean gainExcel() {
		
		return false;
	}

	
	public boolean setAlarm(double alarm) {
		
		return false;
	}

	
	public int getTotalStorein(List<StoreinCreateVO> storeinList) {
	
		return 0;
	}

	
	public int getTotalStoreout(List<StoreoutCreateVO> storeoutList) {
		
		return 0;
	}

	
	public List<StoreoutCreateVO> storeoutQuery(Date fromDate, Date toDate) {
		
		return null;
	}

	
	public List<StoreinCreateVO> storeinQuery(Date fromDate, Date toDate) {
		
		return null;
	}

}

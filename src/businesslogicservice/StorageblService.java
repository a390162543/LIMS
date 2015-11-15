package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.StorageCheckVO;
import vo.StorageSetAreaVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;

public interface StorageblService {
	
	
	public boolean setArea(StorageSetAreaVO vo);
	
	
	//need to change the checkDate.
	public List<StorageCheckVO> storeCheck(Date date);
	
	
	public boolean isExceeded();
	
	
	public boolean gainExcel();
	
	
	public boolean setAlarm(double alarm);
	
	
	public int getTotalStorein(List<StoreinCreateVO>  storeinList);
	public int getTotalStoreout(List<StoreoutCreateVO>  storeoutList);
	
	
	
	public List<StoreoutCreateVO> storeoutQuery(Date fromDate,Date toDate);
	public List<StoreinCreateVO> storeinQuery(Date fromDate,Date toDate);
	

}

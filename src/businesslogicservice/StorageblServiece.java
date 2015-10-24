package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.StorageCheckVO;
import vo.StorageSetAreaVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;

public interface StorageblServiece {
	
	
	public boolean setArea(StorageSetAreaVO vo);
	
	
	public List<StorageCheckVO> storeCheck(Date date);
	
	
	public double computeRatio();
	
	
	public boolean gainExcel();
	
	
	public boolean setAlarm(double alarm);
	
	
	public List<StoreoutCreateVO> storeoutQuery(Date fromDate,Date toDate);
	public List<StoreinCreateVO> storeinQuery(Date fromDate,Date toDate);
	

}

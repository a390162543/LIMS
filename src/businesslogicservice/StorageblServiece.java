package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.StoragePO;
import po.StoreinPO;
import po.StoreoutPO;

public interface StorageblServiece {
	
	
	public boolean setArea(int airCapacity, int trainCapacity, int carCapacity, int motorCapacity);
	
	
	public List<StoragePO> storeCheck(Date date);
	
	
	public double computeRatio();
	
	
	public boolean gainExcel();
	
	
	public boolean setAlarm(double alarm);
	
	
	public List<StoreoutPO> storeoutQuery(Date fromDate,Date toDate);
	public List<StoreinPO> storeinQuery(Date fromDate,Date toDate);
	

}

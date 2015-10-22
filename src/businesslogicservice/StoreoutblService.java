package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.ShipForm;

public interface StoreoutblService {

	
	public StoreoutPO createStoreoutPO (List<Long> orderId,Date date,List<String> destination,
			List<ShipForm> shipform, long transferId);
	
	
	


}

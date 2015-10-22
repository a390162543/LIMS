package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.StoreinPO;

public interface StoreinblService {
	
	
	public StoreinPO createStoreinPO (List<Long> orderId,Date date,List<String> destination,
			List<Integer> areaNum,List<Integer> rowNum,List<Integer> frameNum, List<Integer> item);
	
	
	


}

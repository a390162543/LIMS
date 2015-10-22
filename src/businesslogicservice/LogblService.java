package businesslogicservice;

import java.util.List;
import java.sql.Date;

import po.LogPO;

public interface LogblService {
	
	public List<LogPO>  queryLogPO (Date date);
	
	public boolean addOperation (String operation,Date date);
}

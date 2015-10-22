package dataservice;

import java.util.List;

import po.AccountPO;
import po.LogPO;

public interface LogDataService {
	
	public boolean insert(LogPO po);
	
	public boolean delete(LogPO po);
	
	public boolean update(LogPO po);
	
	public LogPO find(long id);
	
	public List<LogPO> finds(String field, Object value);
	
	public List<LogPO> getAll();
}

package businesslogicservice;

import java.util.List;
import java.sql.Date;

import po.LogPO;
import vo.LogVO;

public interface LogblService {
	
	public boolean createLogVO (LogVO vo);
	
	public List<LogVO>  queryLogVO (Date date);
	
}

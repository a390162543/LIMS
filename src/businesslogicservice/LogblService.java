package businesslogicservice;

import java.util.List;
import java.util.Date;

import po.LogPO;
import vo.LogVO;

public interface LogblService {
	
	public boolean createLogVO (LogVO vo);
	
	public List<LogVO>  queryLogVO (Date date);
	
}

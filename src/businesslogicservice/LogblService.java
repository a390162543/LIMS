package businesslogicservice;

import java.util.List;
import java.util.Date;

import vo.LogVO;

public interface LogblService {
	
	public boolean createLogPO (LogVO vo);
	
	public List<LogVO>  queryLogVO (Date date);
	
	public String getLogInfo(LogVO vo);
}

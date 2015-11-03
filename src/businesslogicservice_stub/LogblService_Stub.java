package businesslogicservice_stub;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import vo.LogVO;
import businesslogicservice.LogblService;

public class LogblService_Stub implements LogblService{
	LogVO vo;
	
	public LogblService_Stub(LogVO vo){
		this.vo=vo;
	}

	public boolean createLogPO(LogVO vo) {
		return true;
	}

	public List<LogVO> queryLogVO(Date date) {
		List<LogVO> list=new ArrayList<LogVO>();
		list.add(vo);
		return list;
	}


}

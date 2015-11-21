package businesslogicservice;

import java.util.List;

import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;

public interface StoreinblService {
	
	
	public boolean createStoreinPO (StoreinCreateVO vo);
	
	public boolean modifyStorein (StoreinCreateVO vo);
	
	public boolean excute (StoreinCreateVO vo);
	
	
	
	


}

package businesslogicservice;

import java.util.List;

import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinOrderVO;

public interface StoreinblService {
	
	
	public boolean createStoreinPO (StoreinCreateVO vo);
	
	public boolean modifyStorein (StoreinCreateVO vo);
	
	public boolean execute (StoreinCreateVO vo);
	
	public boolean changeLocationState (StoreinOrderVO vo);
	
	public boolean restoreLocationState (StoreinOrderVO vo);
	
	


}

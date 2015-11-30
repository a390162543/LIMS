package businesslogicservice;

import java.util.List;

import vo.StorageLocationVO;
import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinOrderVO;

public interface StoreinblService {
	
	
	public boolean createStoreinPO (StoreinCreateVO vo);
	
	public boolean modifyStorein (StoreinCreateVO vo);
	
	public boolean execute (StoreinCreateVO vo);
	
	public boolean changeLocationState (StorageLocationVO vo);
	
	public boolean restoreLocationState (StorageLocationVO vo);
	
	


}

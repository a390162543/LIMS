package businesslogicservice;


import java.util.List;

import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreoutCheckResultVO;
import vo.StoreoutCreateVO;

public interface StoreoutblService {

	
	public boolean createStoreoutPO (StoreoutCreateVO vo);
	
	public boolean modifyStoreout (StoreoutCreateVO vo);
	
	public boolean execute (StoreoutCreateVO vo);
		
	

}

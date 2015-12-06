package businesslogicservice;

import vo.StoreoutCreateVO;


public interface StoreoutblService extends Identifiable{

	
	public boolean createStoreoutPO (StoreoutCreateVO vo);
	
	public boolean modifyStoreout (StoreoutCreateVO vo);
	
	public boolean execute (StoreoutCreateVO vo);
		
	public boolean changeLocationState (String orderId);

	public boolean restoreLcationState (String orderId);
}

package businesslogicservice;

import vo.ArrivalVO;

public interface ArrivalblService extends Identifiable{
    
    public boolean createArrivalPO(ArrivalVO vo);
    
    public boolean modifyArrivalPO(ArrivalVO vo);
    
    public boolean execute(ArrivalVO vo);
    
}

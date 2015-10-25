package businesslogicservice;

import vo.ArrivalVO;

public interface ArrivalblService {
    
    public boolean createArrivalPO(ArrivalVO vo);
    
    public boolean modifyArrivalPO(ArrivalVO vo);
    
    public boolean execute(ArrivalVO vo);
    
}

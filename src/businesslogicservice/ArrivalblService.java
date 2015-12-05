package businesslogicservice;

import vo.ArrivalVO;
import vo.LoadVO;
import vo.TransferVO;

public interface ArrivalblService extends Identifiable{
    
    public boolean createArrivalPO(ArrivalVO vo);
    
    public boolean modifyArrivalPO(ArrivalVO vo);
    
    public boolean execute(ArrivalVO vo);
    
    public LoadVO getLoadVO(String id);
    
    public TransferVO getTransferVO(String id);
    
}

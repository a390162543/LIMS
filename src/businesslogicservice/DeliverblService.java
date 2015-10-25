package businesslogicservice;

import vo.DeliverVO;

public interface DeliverblService {

    public boolean createDeliverPO(DeliverVO vo);
    
    public boolean modifyDeliverPO(DeliverVO vo);
    
    public boolean execute(DeliverVO vo);
    
}

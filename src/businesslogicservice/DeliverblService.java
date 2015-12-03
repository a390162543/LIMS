package businesslogicservice;

import java.util.List;

import vo.DeliverVO;
import vo.EmployeeVO;

public interface DeliverblService extends Identifiable {

    public boolean createDeliverPO(DeliverVO vo);
    
    public boolean modifyDeliverPO(DeliverVO vo);
    
    public boolean execute(DeliverVO vo);
    
    public List<EmployeeVO> getAllCouriers();
}

package businesslogicservice;

import java.util.List;

import vo.TruckVO;

public interface TruckblService {
    
    public boolean createTruckPO(TruckVO vo);
    
    public boolean deleteTruckPO(TruckVO vo);
    
    public boolean modifyTruckPO(TruckVO vo);
    
    public List<TruckVO> getTruckVO();
}

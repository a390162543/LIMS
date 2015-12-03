package businesslogicservice;

import java.util.List;

import vo.TruckVO;

public interface TruckblService extends Identifiable {
    
    public boolean createTruckPO(TruckVO vo);
    
    public boolean deleteTruckPO(TruckVO vo);
    
    public boolean modifyTruckPO(TruckVO vo);
    
    public List<TruckVO> getTruckVO();
    
    public List<TruckVO> getTruckVO(String organization);
}

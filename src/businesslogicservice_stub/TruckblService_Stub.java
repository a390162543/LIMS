package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.List;

import vo.TruckVO;
import businesslogicservice.TruckblService;

public class TruckblService_Stub implements TruckblService{

    TruckVO vo;
    
    public TruckblService_Stub(TruckVO vo) {
        this.vo = vo;
    }
    
    @Override
    public boolean createTruckPO(TruckVO vo) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean deleteTruckPO(TruckVO vo) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean modifyTruckPO(TruckVO vo) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public List<TruckVO> getTruckVO() {
        List<TruckVO> list = new ArrayList<TruckVO>();
        list.add(vo);
        return list;
    }

}

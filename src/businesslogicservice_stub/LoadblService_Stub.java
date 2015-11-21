package businesslogicservice_stub;

import vo.LoadVO;
import businesslogicservice.LoadblService;

public class LoadblService_Stub implements LoadblService{
    
    double cost;
    
    public LoadblService_Stub(double cost) {
        // TODO Auto-generated constructor stub
        this.cost = cost;
    }

    @Override
    public boolean createLoadPO(LoadVO vo) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean modifyLoadPO(LoadVO vo) {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean execute(LoadVO vo) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean addGoods(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteGoods(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getCost(LoadVO vo) {
        // TODO Auto-generated method stub
        return 0;
    }
    


}

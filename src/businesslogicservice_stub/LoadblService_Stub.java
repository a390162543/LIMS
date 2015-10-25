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
    public double getCost(String depart, String arrive) {
        // TODO Auto-generated method stub
        return cost;
    }

    @Override
    public boolean execute(LoadVO vo) {
        // TODO Auto-generated method stub
        return true;
    }
    


}

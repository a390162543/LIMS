package businesslogicservice;


import vo.LoadVO;

public interface LoadblService {
    
    public boolean createLoadPO(LoadVO vo);
    
    public boolean modifyLoadPO(LoadVO vo);
    
    public double getCost(String depart,String arrive);
    
    public boolean execute(LoadVO vo);
    
}

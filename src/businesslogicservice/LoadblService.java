package businesslogicservice;


import vo.LoadVO;

public interface LoadblService {
    
    public boolean createLoadPO(LoadVO vo);
    
    public boolean modifyLoadPO(LoadVO vo);
    
    public boolean addGoods(long id);
    
    public boolean deleteGoods(long id);
    
    public double getCost(LoadVO vo);
    
    public boolean execute(LoadVO vo);
    
}

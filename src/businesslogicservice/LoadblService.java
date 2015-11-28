package businesslogicservice;


import vo.GoodsVO;
import vo.LoadVO;

public interface LoadblService {
    
    public boolean createLoadPO(LoadVO vo);
    
    public boolean modifyLoadPO(LoadVO vo);
    
    public GoodsVO getGoodsVO(String id);
    
    public boolean addGoods(GoodsVO vo);
    
    public boolean deleteGoods(GoodsVO vo);
    
    public double getCost(String location1, String location2);
    
    public boolean execute(LoadVO vo);
    
}

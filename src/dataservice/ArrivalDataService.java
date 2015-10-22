package dataservice;

import java.util.List;

import po.ArrivalPO;

public interface ArrivalDataService {
    
    public boolean insert(ArrivalPO po);
    
    public boolean delete(ArrivalPO po);
    
    public boolean update(ArrivalPO po);
    
    public ArrivalPO find(long id);
    
    public List<ArrivalPO> finds(String field, Object value);
    
    public List<ArrivalPO> getAll();

}

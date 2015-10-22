package dataservice;

import java.util.List;

import po.DeliverPO;

public interface DeliverDataService {
    
    public boolean insert(DeliverPO po);
    
    public boolean delete(DeliverPO po);
    
    public boolean update(DeliverPO po);
    
    public DeliverPO find(long id);
    
    public List<DeliverPO> finds(String field, Object value);
    
    public List<DeliverPO> getAll();

}

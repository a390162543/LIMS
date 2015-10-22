package dataservice;

import java.util.List;

import po.RevenuePO;

public interface RevenueDataService {
    
    public boolean insert(RevenuePO po);
    
    public boolean delete(RevenuePO po);
    
    public boolean update(RevenuePO po);
    
    public RevenuePO find(long id);
    
    public List<RevenuePO> finds(String field, Object value);
    
    public List<RevenuePO> getAll();

}

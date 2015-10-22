package dataservice;

import java.util.List;

import po.LoadPO;

public interface LoadDataService {
    
    public boolean insert(LoadPO po);
    
    public boolean delete(LoadPO po);
    
    public boolean update(LoadPO po);
    
    public LoadPO find(long id);
    
    public List<LoadPO> finds(String field, Object value);
    
    public List<LoadPO> getAll();

}

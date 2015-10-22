package dataservice;

import java.util.List;

import po.TruckPO;

public interface TruckDataService {
    
    public boolean insert(TruckPO po);
    
    public boolean delete(TruckPO po);
    
    public boolean update(TruckPO po);
    
    public TruckPO find(long id);
    
    public List<TruckPO> finds(String field, Object value);
    
    public List<TruckPO> getAll();

}

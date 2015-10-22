package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.LoadPO;

public interface LoadblService {
    
    public LoadPO createLoadPO(Date loadingDate,long transportId,
            String arrive,long truckId,String loadMan,String transMan,
            List<Long> OrderId);
    
    public double getCost(String depart,String arrive);

}

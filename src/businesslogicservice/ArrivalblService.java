package businesslogicservice;

import java.util.Date;

import po.ArrivalPO;
import systemenum.GoodsState;



public interface ArrivalblService {
    
    public ArrivalPO createArrivalPO(Date arrivalDate,long transferID,
            String depart,GoodsState gs);
    
}

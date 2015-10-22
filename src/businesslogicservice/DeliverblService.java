package businesslogicservice;

import java.util.Date;

import po.DeliverPO;

public interface DeliverblService {

    public DeliverPO createDeliverPO(Date DeliverDate,long orderID,
            long courierID);
    
}

package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.RevenuePO;

public interface RevenueblService {
    
    public RevenuePO createRevenuePO(Date RevenueDate,long courierID,
            double revenue,List<Long> orderID);
    
}

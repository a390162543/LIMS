package businesslogic.revenuebl;

import java.util.ArrayList;
import java.util.List;

import vo.OrderRevenueVO;

public class OrderList {

    private List<OrderRevenueVO> orderList = new ArrayList<OrderRevenueVO>(); 
    
    public void add(OrderRevenueVO vo){
        orderList.add(vo);
    }
    
    public void delete(OrderRevenueVO vo){
        orderList.remove(vo);
    }
    
    public double getRevenue(){
        double revenue = 0;
        for(OrderRevenueVO vo : orderList)
            revenue += vo.getRevenue();
        return revenue;
    }
    
}
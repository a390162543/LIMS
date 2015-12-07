package businesslogic.revenuebl;

import java.util.ArrayList;
import java.util.List;

import vo.OrderRevenueVO;

/**
 * 维护一次收款记录的订单信息列表
 * @author Admin
 * @version 1.2
 * @see Revenue
 */
public class OrderList {

    /**
     * 维护{@code OrderRevenueVO}的列表
     */
    private List<OrderRevenueVO> orderList = new ArrayList<OrderRevenueVO>(); 
    
    /**
     * 添加一项订单信息
     * @param vo 需要添加的{@code OrderRevenueVO}
     */
    public void add(OrderRevenueVO vo){
        orderList.add(vo);
    }
    
    /**
     * 删除一项订单信息
     * @param vo 需要删除的{@code OrderRevenueVO}
     */
    public void delete(OrderRevenueVO vo){
        orderList.remove(vo);
    }
    
    /**
     * 获取总收款额
     * @return 收款记录中{@code orderList}的收款额总量
     */
    public double getRevenue(){
        double revenue = 0;
        for(OrderRevenueVO vo : orderList)
            revenue += vo.getExpense();
        return revenue;
    }
    
}
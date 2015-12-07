package businesslogic.revenuebl;

import java.util.ArrayList;
import java.util.List;

import vo.OrderRevenueVO;

/**
 * ά��һ���տ��¼�Ķ�����Ϣ�б�
 * @author Admin
 * @version 1.2
 * @see Revenue
 */
public class OrderList {

    /**
     * ά��{@code OrderRevenueVO}���б�
     */
    private List<OrderRevenueVO> orderList = new ArrayList<OrderRevenueVO>(); 
    
    /**
     * ���һ�����Ϣ
     * @param vo ��Ҫ��ӵ�{@code OrderRevenueVO}
     */
    public void add(OrderRevenueVO vo){
        orderList.add(vo);
    }
    
    /**
     * ɾ��һ�����Ϣ
     * @param vo ��Ҫɾ����{@code OrderRevenueVO}
     */
    public void delete(OrderRevenueVO vo){
        orderList.remove(vo);
    }
    
    /**
     * ��ȡ���տ��
     * @return �տ��¼��{@code orderList}���տ������
     */
    public double getRevenue(){
        double revenue = 0;
        for(OrderRevenueVO vo : orderList)
            revenue += vo.getExpense();
        return revenue;
    }
    
}
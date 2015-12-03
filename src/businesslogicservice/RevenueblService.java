package businesslogicservice;

import java.util.List;

import vo.EmployeeVO;
import vo.OrderRevenueVO;
import vo.RevenueVO;

public interface RevenueblService extends Identifiable {
    
    public boolean createRevenuePO(RevenueVO vo);
    
    public boolean modifyRevenuePO(RevenueVO vo);
    
    public boolean execute(RevenueVO vo);
    
    public OrderRevenueVO getOrderRevenueVO(String id);
    
    public boolean add(OrderRevenueVO vo);
    
    public boolean delete(OrderRevenueVO vo);
    
    public double getSum();
    
    public List<EmployeeVO> getAllCouriers();
    
}

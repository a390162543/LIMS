package businesslogicservice;

import java.util.List;

import vo.EmployeeVO;
import vo.OrderRevenueVO;
import vo.RevenueVO;

/**
 * {@code RevenueblService}提供给界面层收款单处理的业务逻辑服务
 * @author 林祖华
 * @version 1.5
 */
public interface RevenueblService extends Identifiable {
    
    /**
     * 创建并记录收款单信息
     * @param vo 界面层传递来的{@code RevenueVO}
     * @return 成功创建返回{@code true}，否则返回{@code false}
     */
    public boolean createRevenuePO(RevenueVO vo);
    
    /**
     * 修改收款单信息
     * 
     * @param vo 界面层传递来的{@code RevenueVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
    public boolean modifyRevenuePO(RevenueVO vo);
    
    /**
     * 执行收款单信息
     * 
     * @param vo 界面层传递来的{@code RevenueVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
    public boolean execute(RevenueVO vo);
    
    /**
     * 根据{@code id}标识获取一个{@code OrderRevenueVO}
     * @param id 订单的{@code id}
     * @return  {@code OrderPO}对应的一个{@code OrderRevenueVO}，如果查询失败
     * 或不存在，则返回{@code null}
     */
    public OrderRevenueVO getOrderRevenueVO(String id);
    
    /**
     * 在订单列表中添加一项{@code OrderRevenueVO}
     * @param vo 需要加入的{@code OrderRevenueVO}
     * @return 如果添加成功则返回{@code true}，否则返回{@code false}
     */
    public boolean add(OrderRevenueVO vo);
    
    /**
     * 在订单列表中删除一项{@code OrderRevenueVO}
     * @param vo 需要删除的{@code OrderRevenueVO}
     * @return 如果删除成功则返回{@code true}，否则返回{@code false}
     */
    public boolean delete(OrderRevenueVO vo);
    
    /**
     * 获取订单的总价
     * @return 货物总价
     */
    public double getSum();
    
    /**
     * 获取本营业厅的所有快递员
     * @return {@code EmployeeVO}的列表，如果不存在本营业厅快递员，则返回一个空列表
     * @see businesslogic.userbl.LoginController
     */
    public List<EmployeeVO> getAllCouriers();
    
}

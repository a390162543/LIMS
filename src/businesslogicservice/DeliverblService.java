package businesslogicservice;

import java.util.List;

import vo.DeliverVO;
import vo.EmployeeVO;
/**
 * {@code DeliverblService}提供给界面层派件单处理的业务逻辑服务
 * @author 林祖华
 * @version 1.3
 */
public interface DeliverblService extends Identifiable {

    /**
     * 创建并记录派件单信息
     * 
     * @param vo 界面层传递来的{@code DeliverVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
    public boolean createDeliverPO(DeliverVO vo);
    
    /**
     * 修改派件单信息
     * 
     * @param vo 界面层传递来的{@code DeliverVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
    public boolean modifyDeliverPO(DeliverVO vo);
    
    /**
     * 执行派件单信息
     * 
     * @param vo 界面层传递来的{@code DeliverVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
    public boolean execute(DeliverVO vo);
    
    /**
     * 获取本营业厅的所有快递员
     * @return {@code EmployeeVO}的列表，没有快递员则返回空列表
     * @see businesslogic.userbl.LoginController
     */
    public List<EmployeeVO> getAllCouriers();
}

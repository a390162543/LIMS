package businesslogicservice;

import vo.ArrivalVO;
import vo.LoadVO;
import vo.TransferVO;

/**
 * {@code ArrivalblService}提供给界面层到达单处理的业务逻辑服务
 * @author 林祖华
 * @version 1.4
 */
public interface ArrivalblService extends Identifiable{
    
    /**
     * 创建并记录到达单信息
     * 
     * @param vo 界面层传递来的{@code ArrivalVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
    public boolean createArrivalPO(ArrivalVO vo);
    
    /**
     * 修改到达单信息
     * 
     * @param vo 界面层传递来的{@code ArrivalVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
    public boolean modifyArrivalPO(ArrivalVO vo);
    
    /**
     * 执行到达单信息
     * 
     * @param vo 界面层传递来的{@code ArrivalVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
    public boolean execute(ArrivalVO vo);
    
    /**
     * 根据{@code id}获取一个{@code LoadVO}对象
     * 
     * @param id {@code LoadVO}的{@code id}标识
     * @return 返回一个{@code LoadVO}对象，如果查询失败或不存在，则返回{@code null}
     */
    public LoadVO getLoadVO(String id);
    
    /**
     * 根据{@code id}获取一个{@code TransferVO}对象
     * 
     * @param id {@code TransferVO}的{@code id}标识
     * @return 返回一个{@code TransferVO}对象，如果查询失败或不存在，则返回{@code null}
     */
    public TransferVO getTransferVO(String id);
    
}

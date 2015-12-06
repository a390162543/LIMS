package businesslogicservice;

import java.util.List;

import vo.TruckVO;

/**
 * {@code TruckblService}提供给界面层车辆处理的业务逻辑服务
 * @author 林祖华
 * @version 1.3
 */
public interface TruckblService extends Identifiable {
    
    /**
     * 创建并记录车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功创建则返回{@code true}，否则返回{@code false}
     */
    public boolean createTruckPO(TruckVO vo);
    
    /**
     * 删除车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
    public boolean deleteTruckPO(TruckVO vo);
    
    /**
     * 修改车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
    public boolean modifyTruckPO(TruckVO vo);
    
    /**
     * 获取所有的车辆信息
     * @return {@code TruckVO}的列表，如果没有车辆信息或获取失败，则返回空列表
     */
    public List<TruckVO> getTruckVO();
    
    /**
     * 获取所属于某个营业厅的所有车辆信息
     * @return {@code TruckVO}的列表，如果没有车辆信息或获取失败，则返回空列表
     */
    public List<TruckVO> getTruckVO(String organization);
}

package businesslogicservice;


import vo.GoodsVO;
import vo.LoadVO;

/**
 * {@code LoadblService}提供给界面层装车单处理的业务逻辑服务
 * @author 林祖华
 * @version 1.5
 */
public interface LoadblService extends Identifiable {
    
    /**
     * 创建并记录装车单信息
     * @param vo 界面层传递来的{@code LoadVO}
     * @return 成功创建返回{@code true}，否则返回{@code false}
     */
    public boolean createLoadPO(LoadVO vo);
    
    /**
     * 修改装车单信息
     * 
     * @param vo 界面层传递来的{@code LoadVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
    public boolean modifyLoadPO(LoadVO vo);
    
    /**
     * 根据{@code id}获取一个{@code GoodsVO}对象
     * @param id {@code GoodsVO}的{@code id}标识
     * @return 返回一个{@code GoodsVO}对象，如果查询失败或不存在，则返回{@code null}
     */
    public GoodsVO getGoodsVO(String id);
    
    /**
     * 在装车单货物列表中添加一项{@code GoodsVO}
     * @param vo 需要加入的{@code GoodsVO}
     * @return 如果添加成功则返回{@code true}，否则返回{@code false}
     */
    public boolean addGoods(GoodsVO vo);
    
    /**
     * 在装车单货物列表中删除一项{@code GoodsVO}
     * @param vo 需要删除的{@code GoodsVO}
     * @return 如果删除成功则返回{@code true}，否则返回{@code false}
     */
    public boolean deleteGoods(GoodsVO vo);
    
    /**
     * 获取装车单货物的总价
     * @param location1 {@code LoadVO}中的出发地
     * @param location2 {@code LoadVO}中的目的地
     * @return 货物总价
     */
    public double getCost(String location1, String location2);
    
    /**
     * 执行装车单信息
     * 
     * @param vo 界面层传递来的{@code LoadVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
    public boolean execute(LoadVO vo);
    
}

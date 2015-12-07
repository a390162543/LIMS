package businesslogicservice;

import java.util.List;
import vo.GoodsVO;
import vo.TransferVO;

/**
 * {@code TransferblService}提供给界面层员工处理的业务逻辑服务
 * @author 刘航伸
 * @version 1.4
 */ 
public interface TransferblService extends Identifiable{
	 /**
     * 创建并记录中转单信息
     * 
     * @param vo 界面层传递来的{@code TransferVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
	public boolean createTransferPO(TransferVO vo);
	
	 /**
     * 根据{@code location1}、{@code location2}和{@code way}获取相应运费
     * 
     * @param location1, 界面层传递来的 机构名称 
     * @param location2, 界面层传递来的机构名称
     * @param way, 界面层传递来的货运方式
     * @return 返回相应运费
     */
	public double getCost(String location1, String location2,String way);
	
	 /**
     * 修改中转单信息
     * 
     * @param vo 界面层传递来的{@code TransferVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
	public boolean modifyTransferPO(TransferVO vo);
	
	 /**
     * 获取所有中转单信息
     * 
     * @return  返回一个包含所有{@code TransferVO}的List
     */
	public List<TransferVO> getTransferVO();
	
	 /**
     * 中转单的执行方法
     * 
     * @param vo 界面层传递来的{@code TransferVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
	public boolean execute(TransferVO vo);
	
	 /**
     * 根据{@code id}获取一个{@code GoodsVO}对象
     * 
     *@param id {@code GoodsVO}的{@code id}标识
     * @return 返回一个{@code GoodsVO}对象，如果查询失败或不存在，则返回{@code null}
     */
	public GoodsVO getGoodsVO(String id);
	
	/**
	 * 添加货物
	 * 
	 * @param vo 界面层传递来的{@code GoodsVO}
	 * @return 成功添加返回{@code true}, 否则返回{@code false}
	 */
	public boolean addGoods(GoodsVO vo);

	/**
	 * 删除货物
	 * 
	 * @param vo 界面层传递来的{@code GoodsVO}
	 * @return 成功删除返回{@code true}, 否则返回{@code false}
	 */
	public boolean deleteGoods(GoodsVO vo);
}

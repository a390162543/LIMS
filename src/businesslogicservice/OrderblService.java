package businesslogicservice;

import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;



/**
 * OrderblService的职责是负责将和订单相关的操作，包括订单创建、订单签收、订单物流查询界面发来的请求
 * 转发给后台逻辑处理
 * @author lc
 * @version 1.2
 *
 */


public interface OrderblService extends Identifiable {
	
	
	/**
	 * 验证订单创建是否成功
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * 
	 */
	public boolean createOrderPO(OrderCreateVO vo);
	
	
	/**
	 * 验证订单签收是否成功
	 * 
	 * @param vo {@code OrderSignVO}
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * 
	 */
	public boolean signOrder(OrderSignVO vo);
	
	
	/**
	 * 总经理修改单据是否成功
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return 成功返回{@code true}，失败返回{@code false}
	 *
	 */
	public boolean modifyOrder(OrderCreateVO vo);
	
	
	/**
	 *订单查询时返回相应OrderQueryVO给界面显示信息
	 * 
	 * @param orderId {@code String}
	 * @return 返回一个 {@code OrderQueryVO}
	 * 
	 */
	public OrderQueryVO returnOrderQueryVO(String orderId);
	
	
	/**
	 * 当计算价格所需要的信息从界面传给逻辑层后计算出总费用
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return 返回一个{@code double}
	 * 
	 */
	public double getTotal(OrderCreateVO vo);
	
	
	/**
	 * 当计算运送时间所需要的信息从界面传给逻辑层后计算出预估送达时间
	 * 
	 * @param senderAddress {@code String}
	 * @param receiverAddress {@code String}
	 * @return 返回一个{@code double}
	 * 
	 */
	public int getEximatedTime(String senderAddress, String receiverAddress);
	
	/**
	 * 总经理审批订单后执行订单的内容
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * 
	 */
	public boolean execute(OrderCreateVO vo);
	
}

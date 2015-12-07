package businesslogicservice;

import java.util.List;
import vo.ArrivalVO;
import vo.DeliverVO;
import vo.LoadVO;
import vo.OrderCreateVO;
import vo.PaymentVO;
import vo.RevenueVO;
import vo.StoreinCreateVO;
import vo.StoreoutCreateVO;
import vo.TransferVO;

/**
 * {@code ApprovalbiService}提供给审批相关界面处理的业务逻辑服务
 * @author 刘航伸
 * @version 1.4
 */
public interface ApprovalblService {
	
	/**
	 * 审批订单
	 * @param vo, 界面层传递来的{@code OrderCreateVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveOrderVO(OrderCreateVO vo);
	
	/**
	 * 审批到达单
	 * @param vo, 界面层传递来的{@code DeliverVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveDeliverVO(DeliverVO vo);
	
	/**
	 * 审批装车单
	 * @param vo, 界面层传递来的{@code LoadVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveLoadVO(LoadVO vo);
	
	/**
	 * 审批付款单
	 * @param vo, 界面层传递来的{@code PaymentVO}
	 * @return 成功审批返回true, 否则返回false
	 */	 
	public boolean apprivePaymentVO(PaymentVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code RevenueVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveRevenueVO(RevenueVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code StoreinVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveStoreinVO(StoreinCreateVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code StoreoutVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveStoreoutVO(StoreoutCreateVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code TransferVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveTransferVO(TransferVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code ArrivalVO}
	 * @return 成功审批返回true, 否则返回false
	 */
	public boolean approveArrivalVO(ArrivalVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code OrderVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyOrderVO(OrderCreateVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code DeliverVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyDeliverVO(DeliverVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code LoadVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyLoadVO(LoadVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code PaymentVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyPaymentVO(PaymentVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code RevenueVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyRevenueVO(RevenueVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code StoreinVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyStoreinVO(StoreinCreateVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code StoreoutVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyStoreoutVO(StoreoutCreateVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code TransferVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyTransferVO(TransferVO vo);
	
	/**
	 * 
	 * @param vo, 界面层传递来的{@code ArrivalVO}
	 * @return 成功修改返回true, 否则返回false
	 */
	public boolean modifyArrivalVO(ArrivalVO vo);
	
	/**获取未审批的订单
	 * 
	 * @return {@code List<OrderCreateVO>}
	 */
	public List<OrderCreateVO>  getOrderVO();
	
	/**
	 * 获取未审批的派件单
	 * @return {@code List<DeliverVO>}
	 */
	public List<DeliverVO>  getDeliverVO();
	
	/**
	 * 获取未审批的装车单
	 * @return {@code List<LoadVO>}
	 */
	public List<LoadVO>  getLoadVO();
	
	/**
	 * 获取未审批的付款单
	 * @return {@code List<PaymentVO> }
	 */
	public List<PaymentVO>  getPaymentVO();
	
	/**
	 * 获取未审批的收款单
	 * @return {@code List<RevenueVO>}
	 */
	public List<RevenueVO>  getRevenueVO();
	
	/**
	 * 获取未审批的入库单
	 * @return {@code List<StoreinCreateVO>}
	 */
	public List<StoreinCreateVO>  getStoreinVO();
	
	/**
	 * 获取未审批的出库单
	 * @return {@code List<StoreoutCreateVO>}
	 */
	public List<StoreoutCreateVO>  getStoreoutVO();
	
	/**
	 * 获取未审批的装车单
	 * @return {@code List<TransferVO>}
	 */
	public List<TransferVO>  getTransferVO();
	
	/**
	 * 获取未审批的到达单
	 * @return {@code List<ArrivalVO>}
	 */
	public List<ArrivalVO>  getArrivalVO();
}

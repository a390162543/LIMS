package businesslogicservice;

import vo.PaymentVO;

/**
 * {@code  PaymentblService}提供给界面层付款单处理的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
public interface PaymentblService extends Identifiable{

    /**
     * 创建并记录付款单信息
     * @param vo 界面层传来的{@code PaymentVO}
     * @return 成功创建则返回{@code true}，否则返回{@code false}
     */
	public boolean createPaymentPO(PaymentVO vo);
	
    /**
     * 修改付款单信息
     * @param vo 界面层传来的{@code PaymentVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyPaymentPO(PaymentVO vo);
	
    /**
     * 执行付款单信息
     * 
     * @param vo 界面层传递来的{@code PaymentVO}
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
	public boolean execute(PaymentVO vo);

	/**
	 * 获取所有账户编号
	 * @return {@code String}数组，如果不存在或者查询失败，则返回空数组
	 */
	public String[] getAllAccountId();

}

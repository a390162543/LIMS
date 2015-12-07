package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.RevenueVO;

/**
 * {@code  SettlementblService}提供给界面层结算管理的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
public interface SettlementblService {
    /**
     * 根据日期和营业厅获取所有的收款单信息
     * @param  date  {@code Date}
     * @param  organization {@code String}
     * @return {@code RevenueVO}的列表，如果没有收款单信息或获取失败，则返回空列表
     */
	public List<RevenueVO> queryRevenueVO (Date date ,String organization);
	
    /**
     * 设置收款账户
     * @param vo {@code RevenueVO} 
     * @param accountId {@code String}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean setAccountId(RevenueVO vo,String accountId);
	
    /**
     * 获取所有的收款单信息
     * @return {@code RevenueVO}的列表，如果没有收款单的信息或获取失败，则返回空列表
     */
	public List<RevenueVO> getUncommittedRevenueVO();
	
    /**
     * 获取所有的账户编号信息
     * @return {@code String}的数组，如果没有账户编号信息或获取失败，则返回空数组
     */
	public String[] getAllAccountId();
}

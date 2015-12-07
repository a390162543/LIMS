package businesslogicservice;

import java.util.List;

import vo.AccountVO;

/**
 * {@code AccountblService}提供给界面层账户处理的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
public interface AccountblService {
    /**
     * 创建并记录账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功创建则返回{@code true}，否则返回{@code false}
     */
	public boolean createAccountPO(AccountVO vo);
	
    /**
     * 删除账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean deleteAccountPO(AccountVO vo);
	
    /**
     * 修改账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyAccountPO(AccountVO vo);
	
    /**
     * 获取所有的账户信息
     * @return {@code AccountVO}的列表，如果没有账户信息或获取失败，则返回空列表
     */
	public List<AccountVO> getAccountVO();

}

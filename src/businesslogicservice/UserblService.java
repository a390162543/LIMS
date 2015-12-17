package businesslogicservice;

import java.util.List;
import vo.UserVO;

/**
 * {@code ArrivalblService}提供给界面层用户处理的业务逻辑服务
 * @author 刘航伸
 * @version 1.4
 */
public interface UserblService {
	 
	/**
	 * 查询用户帐号和密码是否正确
	 * 
	 * @param id, 界面传递来的用户帐号
	 * @param password, 界面传递来的密码
	 * @return 用户帐号和密码 正确
	 */
	public boolean queryUserPO(String id,String passWord);
	
	/**
	 * 初始化用户密码
	 * @param id
	 * @return 成功初始化返回{@code true}, 否则返回{@code false}
	 */
	public boolean initialize(String id);
	/**
	 * 修改用户权限
	 * @param vo, 界面层传递来的{@code UserVO}
	 * @return 成功修改返回{@code true}, 否则返回{@code false}
	 */
	public boolean modifyPower(UserVO vo);
	
	/**
	 * 修改用户密码
	 * @param vo, 界面层传递来的{@code UserVO}
	 * @return 成功修改返回{@code true}, 否则返回{@code false}
	 */
	public boolean modifyPassword(String id, String password);
	 /**
	  * 获取所有用户信息
	  * @return 返回一个{@code List<UserVO>}对象，如果 不存在，则返回{@code null}
	  */
	public List<UserVO> getUserVO();
	/**
     * 根据{@code id}获取一个{@code UserVO}对象
     * 
     * @param id {@code UserVO}的{@code id}标识
     * @return 返回一个{@code UserVO}对象，如果查询失败或不存在，则返回{@code null}
     */
	public UserVO find(String id);
}

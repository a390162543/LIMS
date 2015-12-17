package businesslogicservice;

import java.util.List;
import vo.EmployeeVO;

/**
 * {@code ArrivalblService}提供给界面层员工处理的业务逻辑服务
 * @author 刘航伸
 * @version 1.4
 */
public interface EmployeeblService extends Identifiable{
	 /**
     * 创建并记录员工信息
     * 
     * @param vo 界面层传递来的{@code EmployeeVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
	public boolean createEmployeePO(EmployeeVO vo);
	 
	/**
     * 删除员工信息
     * 
     * @param vo 界面层传递来的{@code EmployeeVO}
     * @return  成功删除返回{@code true}，否则返回{@code false}
     */
	public boolean deleteEmployeePO (EmployeeVO vo);
	
	 /**
     * 修改员工信息
     * 
     * @param vo 界面层传递来的{@code EmployeeVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
	public boolean modifyEmployeePO (EmployeeVO vo);
	
	/**
	 * 获取所有员工信息
	 * 
	 * @return 返回一个{@code List<EmployeeVO>}对象，如果查询失败或不存在，则返回{@code null}
	 */
	public List<EmployeeVO> getEmployeeVO();
	
	/**
     * 根据{@code id}获取一个{@code EmployeeVO}对象
     * 
     * @param id {@code EmployeeVO}的{@code id}标识
     * @return 返回一个{@code EmployeeVO}对象，如果查询失败或不存在，则返回{@code null}
     */
	public EmployeeVO find(String id);
	
	/**
     * 根据 机构名称获取该机构所有司机信息
     * 
     * @param  organization String 型，界面传来的机构名称
     * @return 返回一个{@code List<EmployeeVO>}对象，如果查询失败或不存在，则返回{@code null}
     */
	public List<EmployeeVO> getDriverVO(String organiztion);
	
	/**
     * 根据机构名称获取机构Id
     * 
     * @param id {@code OrganizationVO}的{@code id}标识
     * @return 返回机构id，如果查询失败或不存在，则返回{@code null}
     */
	public String getOrganizationId(String name);
	
	 
		
 
}

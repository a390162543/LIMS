package businesslogicservice;

import java.util.List;

import vo.OrganizationVO;

/**
 * {@code OrganizationbiSerevice}提供给界面层机构管理的业务逻辑服务
 * @author 刘航伸
 * @version 1.4
 */
public interface OrganizationblService extends OrganizationIdentifiable{
	 /**
     * 创建并记录机构信息
     * 
     * @param vo 界面层传递来的{@code OrganizationVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
	public boolean createOrganizationPO(OrganizationVO vo); 
	
	/**
     * 删除机构信息
     * 
     * @param vo 界面层传递来的{@code OrganizationVO}
     * @return  成功删除返回{@code true}，否则返回{@code false}
     */
	public boolean deleteOrganizationPO (OrganizationVO vo);
	
	 /**
     * 修改机构信息
     * 
     * @param vo 界面层传递来的{@code OrganizationVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
	public boolean modifyOrganizationPO(OrganizationVO vo);
	
	/**
	 * 获取所有机构信息
	 * 
	 * @return返回一个{@code List<OrganizationVO>}对象，如果查询失败或不存在，则返回{@code null}
	 */
	public List<OrganizationVO>  getOrganizationVO();
	
	/**
	 * 获取所有机构名称
	 * 
	 * @return 返回一个{@code List<String>}对象，如果查询失败或不存在，则返回{@code null}
	 */
	public List<String> getAllOrganizationName();
	
	/**
     * 根据{@code name}获取一个{@code id}对象
     * 
     * @param name {@code OrganizationVO}的{@code name}标识
     * @return 返回一个{@code id}对象，如果查询失败或不存在，则返回{@code null}
     */
	public String getId(String name);
	
	/**
     * 根据{@code name}获取一个{@code id}对象
     * 
     * @param name {@code CityVO}的{@code name}标识
     * @return 返回一个{@code id}对象，如果查询失败或不存在，则返回{@code null}
     */
	public String getCityId(String name);
	
	/**
	 * 获取所有城市名称
	 * 
	 * @return 返回一个{@code List<String>}对象，如果查询失败或不存在，则返回{@code null}
	 */
	public List<String> getAllCityName();
}

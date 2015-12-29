package businesslogicservice;


/**
 * {@code  PrimeInfoblService}提供给界面层期初建账处理的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
import java.util.List;

import vo.AccountVO;
import vo.CityVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;

public interface PrimeInfoblService {
    /**
     * 创建并记录期初建账信息
     * @return 成功创建则返回{@code true}，否则返回{@code false}
     */
	public boolean createPrimeInfoPO ();
	
    /**
     * 获取所有的账单信息
     * @return {@code PrimeInfoVO}的列表，如果没有账户信息或获取失败，则返回空列表
     */
	public List<PrimeInfoVO> QueryPrimeInfoVO();
	
    /**
     * 执行期初建账信息
     * @return  成功执行返回{@code true}，否则返回{@code false}
     */
	public boolean execute();
	
	 /**
     * 添加账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addAccountVO( AccountVO vo);
	
    /**
     * 删除账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeAccountVO( AccountVO vo);
	
    /**
     * 修改账户信息
     * @param vo 界面层传来的{@code AccountVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyAccountVO( AccountVO vo);
	
	 /**
     * 添加车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addTruckVO( TruckVO vo);
	
    /**
     * 删除车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeTruckVO( TruckVO vo);
	
    /**
     * 修改车辆信息
     * @param vo 界面层传来的{@code TruckVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyTruckVO( TruckVO vo);
	
	 /**
     * 添加机构信息
     * @param vo 界面层传来的{@code OrganizationVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addOrganizationVO( OrganizationVO vo);
	
    /**
     * 删除机构信息
     * @param vo 界面层传来的{@code OrganizationVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeOrganizationVO( OrganizationVO vo);
	
    /**
     * 修改机构信息
     * @param vo 界面层传来的{@code OrganizationVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyOrganizationVO( OrganizationVO vo);
	
	 /**
     * 添加员工信息
     * @param vo 界面层传来的{@code EmployeeVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addEmployeeVO( EmployeeVO vo);
	
    /**
     * 删除员工信息
     * @param vo 界面层传来的{@code EmployeeVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeEmployeeVO( EmployeeVO vo);
	
    /**
     * 修改员工信息
     * @param vo 界面层传来的{@code EmployeeVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyEmployeeVO( EmployeeVO vo);
	
	 /**
     * 添加城市信息
     * @param vo 界面层传来的{@code CityVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addCityVO( CityVO vo);
	
    /**
     * 删除城市信息
     * @param vo 界面层传来的{@code CityVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeCityVO( CityVO vo);
	
    /**
     * 修改城市信息
     * @param vo 界面层传来的{@code CityVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyCityVO( CityVO vo);
	
	 /**
     * 添加库存信息
     * @param vo 界面层传来的{@code StoreinCreateVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addStoreinCheckResultVO( StoreinCreateVO vo);
	
    /**
     * 删除库存信息
     * @param vo 界面层传来的{@code StoreinCreateVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeStoreinCheckResultVO( StoreinCreateVO vo);
	
    /**
     * 修改库存信息
     * @param vo 界面层传来的{@code StoreinCreateVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyStoreinVO( StoreinCreateVO vo);
	
	 /**
     * 添加订单信息
     * @param vo 界面层传来的{@code OrderCreateVO}
     * @return 成功添加则返回{@code true}，否则返回{@code false}
     */
	public boolean addOrderCheckResultVO( OrderCreateVO vo);
	
    /**
     * 删除订单信息
     * @param vo 界面层传来的{@code OrderCreateVO}
     * @return 成功删除则返回{@code true}，否则返回{@code false}
     */
	public boolean removeOrderCheckResultVO( OrderCreateVO vo);
	
    /**
     * 修改订单信息
     * @param vo 界面层传来的{@code OrderCreateVO}
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean modifyOrderVO( OrderCreateVO vo);

    /**
     * 获取所有机构名信息
     * @return {@code String}列表，如果没有机构名信息或获取失败，则返回空列表
     */
	public List<String> getOrganizationName();

    /**
     * 通过机构名获取机构编号信息
     * @param name 界面层传来的{@code String}
     * @return {@code String}，如果没有机构编号信息或获取失败，则返回空字符串
     */
	public String getOrganizationId(String name);
    
	/**
     * 获取所有城市名称信息
     * @return {@code String}列表，如果没有城市名称信息或获取失败，则返回空列表
     */
	public List<String> getCityName() ;
	
	/**
     * 通过名称获取城市编号信息
     * @return {@code String}列表，如果没有城市编号信息或获取失败，则返回空列表
     */
	public String getCityId(String name) ;
	
	/**
     * 获取所有订单编号信息
     * @return {@code String}列表，如果没有订单编号信息或获取失败，则返回空列表
     */
	public List<String> getOrderList();
}

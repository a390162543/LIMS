package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.CityVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;
/**
 * {@code PrimeInfoPO}是期初建账业务逻辑层与数据层之间传递的持久化对象，
 * 记录了期初账单的所有信息
 * @author 刘德宽
 *
 */
public class PrimeInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3455486090934776890L;
	private List<OrganizationPO>  organization;
	private List<EmployeePO>  employee;
	private List<CityPO>  city;
	private List<TruckPO>  truck;
	private List<StoreinPO>  storage;
	private List<AccountPO>  account;
	private List<OrderPO> order ;
	private Date date;
	
	public PrimeInfoPO(List<OrganizationPO>  organization,List<EmployeePO>  employee,List<CityPO> city,List<TruckPO>  truck,List<StoreinPO>  storage,List<AccountPO>  account, List<OrderPO> order,Date date){
		this.organization = organization;
		this.employee = employee;
		this.city = city;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.order = order;
		this.date = date;
	}

	public PrimeInfoPO(){
		List<OrganizationPO>  organization = new ArrayList<OrganizationPO>();
    	List<EmployeePO>  employee = new ArrayList<EmployeePO>();
     	List<CityPO>  city = new ArrayList<CityPO>();
    	List<TruckPO>  truck = new ArrayList<TruckPO>();
    	List<StoreinPO>  storage = new ArrayList<StoreinPO>();
    	List<AccountPO>  account = new ArrayList<AccountPO>();
    	List<OrderPO> order = new ArrayList<OrderPO>();
    	Date date = new Date();
		this.organization = organization;
		this.employee = employee;
		this.city = city;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.order = order;
		this.date = date;
	}
	public List<OrganizationPO> getOrganization(){
		return organization;
	}
	
	public List<EmployeePO> getEmployee(){
		return employee;
	}
	
	public List<CityPO> getCity(){
		return city;
	}
	
	public List<TruckPO> getTruck(){
		return truck;
	}
	
	public List<StoreinPO> getStorage(){
		return storage;
	}
	
	public List<AccountPO> getAccount(){
		return account;
	}
	
	public List<OrderPO> getOrder(){
		return order;
	}
	
	public Date getDate(){
		return date;
	}
    /**
     * 获取该{@code PrimeInfoPO}对应的{@code PrimeInfoVO}对象
     * @return {@code PrimeInfoVO}对象
     */
	public PrimeInfoVO getPrimeInfoVO() {
		List<OrganizationVO> organizationVOs = new ArrayList<OrganizationVO>();
		for(OrganizationPO po: organization)
			organizationVOs.add(po.getOrganizationVO());
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		for(EmployeePO po: employee)
			employeeVOs.add(po.getEmployeeVO());
		List<CityVO> cityVOs = new ArrayList<CityVO>();
		for(CityPO po: city)
			cityVOs.add(po.getCityVO());
		List<TruckVO> truckVOs = new ArrayList<TruckVO>();
		for(TruckPO po: truck)
			truckVOs.add(po.getTruckVO());
		List<StoreinCreateVO> storageVOs = new ArrayList<StoreinCreateVO>();
		for(StoreinPO po: storage)
			storageVOs.add(po.getStoreinCreateVO());
		List<AccountVO> accountVOs = new ArrayList<AccountVO>();
		for(AccountPO po: account)
			accountVOs.add(po.getAccountVO());
		List<OrderCreateVO> orderVOs = new ArrayList<OrderCreateVO>();
		for(OrderPO po: order)
			orderVOs.add(po.getOrderPendingVO());
		PrimeInfoVO vo = new PrimeInfoVO(organizationVOs,employeeVOs,cityVOs,truckVOs,storageVOs,accountVOs,orderVOs ,date);
		return vo;
	}
}

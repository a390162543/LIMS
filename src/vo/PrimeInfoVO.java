package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.AccountPO;
import po.EmployeePO;
import po.OrderPO;
import po.OrganizationPO;
import po.PrimeInfoPO;
import po.StoreinPO;
import po.TruckPO;


public class PrimeInfoVO {

	private List<OrganizationVO>  organization;
	private List<EmployeeVO>  employee;
	private List<TruckVO>  truck;
	private List<StoreinCreateVO>  storage;
	private List<AccountVO>  account;
	private List<OrderCreateVO> order;
	private Date date;

	public PrimeInfoVO(){
		List<OrganizationVO>  organization = new ArrayList<OrganizationVO>();
    	List<EmployeeVO>  employee = new ArrayList<EmployeeVO>();
    	List<TruckVO>  truck = new ArrayList<TruckVO>();
    	List<StoreinCreateVO>  storage = new ArrayList<StoreinCreateVO>();
    	List<AccountVO>  account = new ArrayList<AccountVO>();
    	List<OrderCreateVO> order = new ArrayList<OrderCreateVO>();
    	Date date = new Date();
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.order = order;
		this.date = date;
	}
	public PrimeInfoVO(List<OrganizationVO>  organization,List<EmployeeVO>  employee,List<TruckVO>  truck,List<StoreinCreateVO>  storage,List<AccountVO>  account, List<OrderCreateVO> order,Date date){
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.order = order;
		this.date = date;
	}
	public List<OrganizationVO> getOrganization(){
		return organization;
	}
	
	public List<EmployeeVO> getEmployee(){
		return employee;
	}
	
	public List<TruckVO> getTruck(){
		return truck;
	}
	
	public List<StoreinCreateVO> getStorage(){
		return storage;
	}
	
	public List<AccountVO> getAccount(){
		return account;
	}

	public List<OrderCreateVO> getOrder(){
		return order;
	}
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public PrimeInfoPO getPrimeInfoPO() {
		List<OrganizationPO> organizationPOs = new ArrayList<OrganizationPO>();
		for(OrganizationVO vo: organization)
			organizationPOs.add(vo.getOrganizationPO());
		List<EmployeePO> employeePOs = new ArrayList<EmployeePO>();
		for(EmployeeVO vo: employee)
			employeePOs.add(vo.getEmployeePO());
		List<TruckPO> truckPOs = new ArrayList<TruckPO>();
		for(TruckVO vo: truck)
			truckPOs.add(vo.getTruckPO());
		List<StoreinPO> storagePOs = new ArrayList<StoreinPO>();
		for(StoreinCreateVO vo: storage)
			storagePOs.add(vo.getStoreinPO());
		List<AccountPO> accountPOs = new ArrayList<AccountPO>();
		for(AccountVO vo: account)
			accountPOs.add(vo.getAccountPO());
		List<OrderPO> orderPOs = new ArrayList<OrderPO>();
		for(OrderCreateVO vo: order)
			orderPOs.add(vo.getOrderPO());
		PrimeInfoPO po = new PrimeInfoPO(organizationPOs,employeePOs,truckPOs,storagePOs,accountPOs,orderPOs,date);
		return po;
	}
}

package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.AccountPO;
import po.EmployeePO;
import po.OrganizationPO;
import po.PrimeInfoPO;
import po.StoragePO;
import po.TruckPO;


public class PrimeInfoVO {

	private List<OrganizationVO>  organization;
	private List<EmployeeVO>  employee;
	private List<TruckVO>  truck;
	private List<StorageCheckVO>  storage;
	private List<AccountVO>  account;
	private Date date;

	public PrimeInfoVO(){
		List<OrganizationVO>  organization = new ArrayList<OrganizationVO>();
    	List<EmployeeVO>  employee = new ArrayList<EmployeeVO>();
    	List<TruckVO>  truck = new ArrayList<TruckVO>();
    	List<StorageCheckVO>  storage = new ArrayList<StorageCheckVO>();
    	List<AccountVO>  account = new ArrayList<AccountVO>();
    	Date date = new Date();
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.date = date;
	}
	public PrimeInfoVO(List<OrganizationVO>  organization,List<EmployeeVO>  employee,List<TruckVO>  truck,List<StorageCheckVO>  storage,List<AccountVO>  account, Date date){
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
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
	
	public List<StorageCheckVO> getStorage(){
		return storage;
	}
	
	public List<AccountVO> getAccount(){
		return account;
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
		List<StoragePO> storagePOs = new ArrayList<StoragePO>();
//		for(StorageVO vo: storage)
//			storagePOs.add(vo.getStoragePO());
		List<AccountPO> accountPOs = new ArrayList<AccountPO>();
		for(AccountVO vo: account)
			accountPOs.add(vo.getAccountPO());
		PrimeInfoPO po = new PrimeInfoPO(organizationPOs,employeePOs,truckPOs,storagePOs,accountPOs,date);
		return po;
	}
}

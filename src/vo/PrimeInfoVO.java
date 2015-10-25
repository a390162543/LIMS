package vo;

import java.util.List;


public class PrimeInfoVO {

	private List<OrganizationVO>  organization;
	private List<EmployeeVO>  employee;
	private List<TruckVO>  truck;
	private List<StorageCheckVO>  storage;
	private List<AccountVO>  account;

	public PrimeInfoVO(List<OrganizationVO>  organization,List<EmployeeVO>  employee,List<TruckVO>  truck,List<StorageCheckVO>  storage,List<AccountVO>  account){
		this.organization=organization;
		this.employee=employee;
		this.truck=truck;
		this.storage=storage;
		this.account=account;
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
}

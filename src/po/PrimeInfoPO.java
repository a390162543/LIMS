package po;

import java.util.List;

public class PrimeInfoPO {

	private List<OrganizationPO>  organization;
	private List<EmployeePO>  employee;
	private List<TruckPO>  truck;
	private List<StoragePO>  storage;
	private List<AccountPO>  account;

	public PrimeInfoPO(List<OrganizationPO>  organization,List<EmployeePO>  employee,List<TruckPO>  truck,List<StoragePO>  storage,List<AccountPO>  account){
		this.organization=organization;
		this.employee=employee;
		this.truck=truck;
		this.storage=storage;
		this.account=account;
	}

	public List<OrganizationPO> getOrganization(){
		return organization;
	}
	
	public List<EmployeePO> getEmployee(){
		return employee;
	}
	
	public List<TruckPO> getTruck(){
		return truck;
	}
	
	public List<StoragePO> getStorage(){
		return storage;
	}
	
	public List<AccountPO> getAccount(){
		return account;
	}
	
}

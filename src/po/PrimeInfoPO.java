package po;

import java.io.Serializable;
import java.util.List;

import vo.PrimeInfoVO;

public class PrimeInfoPO implements Serializable{

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
	
//	public PrimeInfoVO getPrimeInfoVO(){
//		List<OrganizationVO> organizationVOs =new 
//		PrimeInfoVO vo = new PrimeInfoVO(organization, employee , truck , storage , account);
//		return vo;
//	}
}

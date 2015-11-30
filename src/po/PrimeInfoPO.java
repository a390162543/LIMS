package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StorageCheckVO;

import vo.TruckVO;

public class PrimeInfoPO implements Serializable{

	private List<OrganizationPO>  organization;
	private List<EmployeePO>  employee;
	private List<TruckPO>  truck;
	private List<StoragePO>  storage;
	private List<AccountPO>  account;
	private Date date;
	
	public PrimeInfoPO(List<OrganizationPO>  organization,List<EmployeePO>  employee,List<TruckPO>  truck,List<StoragePO>  storage,List<AccountPO>  account, Date date){
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.date = date;
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
	
	public Date getDate(){
		return date;
	}
	public PrimeInfoVO getPrimeInfoVO() {
		List<OrganizationVO> organizationVOs = new ArrayList<OrganizationVO>();
		for(OrganizationPO po: organization)
			organizationVOs.add(po.getOrganizationVO());
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		for(EmployeePO po: employee)
			employeeVOs.add(po.getEmployeeVO());
		List<TruckVO> truckVOs = new ArrayList<TruckVO>();
		for(TruckPO po: truck)
			truckVOs.add(po.getTruckVO());
		List<StorageCheckVO> storageVOs = new ArrayList<StorageCheckVO>();
//		for(StoragePO po: storage)
//			storageVOs.add(po.getstora);
		List<AccountVO> accountVOs = new ArrayList<AccountVO>();
		for(AccountPO po: account)
			accountVOs.add(po.getAccountVO());
		PrimeInfoVO vo = new PrimeInfoVO(organizationVOs,employeeVOs,truckVOs,storageVOs,accountVOs,date);
		return vo;
	}
}

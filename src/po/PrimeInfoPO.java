package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;

public class PrimeInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3455486090934776890L;
	private List<OrganizationPO>  organization;
	private List<EmployeePO>  employee;
	private List<TruckPO>  truck;
	private List<StoreinPO>  storage;
	private List<AccountPO>  account;
	private Date date;
	
	public PrimeInfoPO(List<OrganizationPO>  organization,List<EmployeePO>  employee,List<TruckPO>  truck,List<StoreinPO>  storage,List<AccountPO>  account, Date date){
		this.organization = organization;
		this.employee = employee;
		this.truck = truck;
		this.storage = storage;
		this.account = account;
		this.date = date;
	}

	public PrimeInfoPO(){
		List<OrganizationPO>  organization = new ArrayList<OrganizationPO>();
    	List<EmployeePO>  employee = new ArrayList<EmployeePO>();
    	List<TruckPO>  truck = new ArrayList<TruckPO>();
    	List<StoreinPO>  storage = new ArrayList<StoreinPO>();
    	List<AccountPO>  account = new ArrayList<AccountPO>();
    	Date date = new Date();
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
	
	public List<StoreinPO> getStorage(){
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
		List<StoreinCreateVO> storageVOs = new ArrayList<StoreinCreateVO>();
		for(StoreinPO po: storage)
			storageVOs.add(po.getStoreinCreateVO());
		List<AccountVO> accountVOs = new ArrayList<AccountVO>();
		for(AccountPO po: account)
			accountVOs.add(po.getAccountVO());
		PrimeInfoVO vo = new PrimeInfoVO(organizationVOs,employeeVOs,truckVOs,storageVOs,accountVOs,date);
		return vo;
	}
}

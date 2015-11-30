package businesslogicservice;



import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.TruckVO;

public interface PrimeInfoblService {

	public boolean createPrimeInfoPO ();
	
	public boolean executeAccountPO();
	
	public boolean executeTruckPO();
	
	public boolean executeOrganizationPO();
	
	public boolean executeEmployeePO();
	
	public boolean addAccountVO( AccountVO vo);
	
	public boolean removeAccountVO( AccountVO vo);
	
	public boolean addTruckVO( TruckVO vo);
	
	public boolean removeTruckVO( TruckVO vo);
	
	public boolean addOrganizationVO( OrganizationVO vo);
	
	public boolean removeOrganizationVO( OrganizationVO vo);
	
	public boolean addEmployeeVO( EmployeeVO vo);
	
	public boolean removeEmployeeVO( EmployeeVO vo);
}

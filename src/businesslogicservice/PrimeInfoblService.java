package businesslogicservice;



import java.util.List;

import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.TruckVO;

public interface PrimeInfoblService {

	public boolean createPrimeInfoPO ();
	
	public List<PrimeInfoVO> QueryPrimeInfoVO();
	
	public boolean execute();
	
	public boolean addAccountVO( AccountVO vo);
	
	public boolean removeAccountVO( AccountVO vo);
	
	public boolean addTruckVO( TruckVO vo);
	
	public boolean removeTruckVO( TruckVO vo);
	
	public boolean addOrganizationVO( OrganizationVO vo);
	
	public boolean removeOrganizationVO( OrganizationVO vo);
	
	public boolean addEmployeeVO( EmployeeVO vo);
	
	public boolean removeEmployeeVO( EmployeeVO vo);

	public List<String> getOrganizationName();
}

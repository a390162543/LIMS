package businesslogicservice;



import java.util.List;

import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;

public interface PrimeInfoblService {

	public boolean createPrimeInfoPO ();
	
	public List<PrimeInfoVO> QueryPrimeInfoVO();
	
	public boolean execute();
	
	public boolean addAccountVO( AccountVO vo);
	
	public boolean removeAccountVO( AccountVO vo);
	
	public boolean modifyAccountVO( AccountVO vo);
	
	public boolean addTruckVO( TruckVO vo);
	
	public boolean removeTruckVO( TruckVO vo);
	
	public boolean modifyTruckVO( TruckVO vo);
	
	public boolean addOrganizationVO( OrganizationVO vo);
	
	public boolean removeOrganizationVO( OrganizationVO vo);
	
	public boolean modifyOrganizationVO( OrganizationVO vo);
	
	public boolean addEmployeeVO( EmployeeVO vo);
	
	public boolean removeEmployeeVO( EmployeeVO vo);
	
	public boolean modifyEmployeeVO( EmployeeVO vo);
	
	public boolean addStoreinCheckResultVO( StoreinCreateVO vo);
	
	public boolean removeStoreinCheckResultVO( StoreinCreateVO vo);
	
	public boolean modifyStoreinVO( StoreinCreateVO vo);
	
	public boolean addOrderCheckResultVO( OrderCreateVO vo);
	
	public boolean removeOrderCheckResultVO( OrderCreateVO vo);
	
	public boolean modifyOrderVO( OrderCreateVO vo);

	public List<String> getOrganizationName();
}

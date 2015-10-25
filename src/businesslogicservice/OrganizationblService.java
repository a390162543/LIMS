package businesslogicservice;

import java.util.List;

import po.OrganizationPO;
import vo.OrganizationVO;

public interface OrganizationblService {
	public OrganizationPO CreatOrganizationPO(OrganizationVO vo); 
	
	public boolean deleteOrganizationPO (OrganizationVO vo);
	
	public boolean queryTruckPO (OrganizationVO vo);
	
	 
	
	public List<OrganizationVO>  getOrganizationPO();
	
	 
}

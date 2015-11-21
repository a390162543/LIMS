package businesslogicservice;

import java.util.List;

import po.OrganizationPO;
import vo.OrganizationVO;

public interface OrganizationblService {
	public boolean CreatOrganizationPO(OrganizationVO vo); 
	
	public boolean deleteOrganizationPO (OrganizationVO vo);
	
	public boolean modifyOrganizationPO(OrganizationVO vo);
	
	public List<OrganizationVO>  getOrganizationVO();
	
	public List<String> getAllOrganizationName();
}

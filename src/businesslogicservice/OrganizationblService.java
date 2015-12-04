package businesslogicservice;

import java.util.List;

import vo.OrganizationVO;

public interface OrganizationblService extends OrganizationIdentifiable{
	public boolean CreatOrganizationPO(OrganizationVO vo); 
	
	public boolean deleteOrganizationPO (OrganizationVO vo);
	
	public boolean modifyOrganizationPO(OrganizationVO vo);
	
	public List<OrganizationVO>  getOrganizationVO();
	
	public List<String> getAllOrganizationName();
	
	public String getId(String name);
}

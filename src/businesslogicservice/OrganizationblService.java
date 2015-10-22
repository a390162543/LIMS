package businesslogicservice;

import java.util.List;

import po.OrganizationPO;

public interface OrganizationblService {
	public OrganizationPO CreatOrganizationPO(long id, String name, String city); 
	
	public boolean deleteOrganizationPO ();
	
	public boolean queryTruckPO ();
	
	public boolean setFocusedOrganizationPO(int index);
	
	public List<OrganizationPO>  getOrganizationPO();
	
	public boolean isExist(String name);
}

package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.OrganizationDataService; 
import po.OrganizationPO;
import vo.OrganizationVO;
import businesslogic.citybl.City;
import businesslogicservice.OrganizationblService;

public class Organization implements OrganizationblService{
	private OrganizationDataService organizationDataService;
 public Organization() {
		// TODO Auto-generated constructor stub
		try { 
        	 organizationDataService = (OrganizationDataService) Naming.lookup
        			("rmi://localhost/OrganizationData");
			 
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean CreatOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		  try { 
	        	 
				organizationDataService.insert(vo.getOrganizationPO());
				 
			 	
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	}

	@Override
	public boolean deleteOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		try { 
        	 
			organizationDataService.delete(vo.getOrganizationPO());
			}  
		  	
			catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	 
	@Override
	public List<OrganizationVO> getOrganizationVO() {
		// TODO Auto-generated method stub
		List<OrganizationVO> vos =  new ArrayList<OrganizationVO>();
		 try {
			 
			 List<OrganizationPO> pos=organizationDataService.getAll();
			 for(OrganizationPO po : pos){
				 vos.add(po.getOrganizationVO());
			 }
	           
	        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vos;
	}

	@Override
	public boolean modifyOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		 try {		 
			organizationDataService.update(vo.getOrganizationPO());	           	       
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return true;	 
	}

	@Override
	public List<String> getAllOrganizationName() {
		// TODO Auto-generated method stub
		List<OrganizationVO> vos = getOrganizationVO();
		List<String> nameList = new ArrayList<String>();
		for(OrganizationVO vo : vos)
			nameList.add(vo.getName());
		
		return nameList;
	}
	
	
	
	public String getId(String name){
		String id = "";
		try {
			  id = organizationDataService.getId(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;		
	}
	
	public double getDistanceByOrganizatioName(String organization1, String organization2){
		City city = new City();
		List<OrganizationVO> vos = getOrganizationVO();
		String city1 = "";
		String city2 = "";
		for(OrganizationVO vo : vos){
			if(vo.getName().equals(organization1))
				city1 = vo.getCity();
			if(vo.getName().equals(organization2))
				city2 = vo.getCity();
		}
		
		return city.getDistance(city1, city2);
	}

}

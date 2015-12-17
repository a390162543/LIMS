package businesslogic.organizationbl;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.DataService;
import dataservice.OrganizationDataService; 
import po.OrganizationPO;
import vo.OrganizationVO;
import businesslogic.citybl.City;
import businesslogic.idbl.IdManager;
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;

/**
 * {@code Organization}是机构管理业务逻辑层的实现类，有所有机构管理的业务逻辑服务
 * @author 刘航伸
 * @version 1.6
 *@see dataorganizaion.OrganizaionDataService
 */
public class Organization implements OrganizationblService{
	
	private OrganizationDataService organizationDataService;
	private City city;
	
	public Organization() {
		// TODO Auto-generated constructor stub
		city = new City();
		organizationDataService = DataService.getOrganizationDataService();
	}
	
	@Override
	public boolean createOrganizationPO(OrganizationVO vo) {
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
	
	/**
	 * 根据机构名称获取距离的方法
	 * @param organization1， 机构名称
	 * @param organization2， 机构名称
	 * @return 成功查询到两地距离返回其距离，否则返回0
	 */
	public double getDistanceByOrganizatioName(String organization1, String organization2){
		City city = new City();
		List<OrganizationVO> vos = getOrganizationVO();
		String city1 = "";
		String city2 = "";
		if(organization1.equals(organization2)){
			return 0;
		}
		for(OrganizationVO vo : vos){
			if(vo.getName().equals(organization1))
				city1 = vo.getCity();
			if(vo.getName().equals(organization2))
				city2 = vo.getCity();
		}
		if(city1 != null && city2 != null){
			if(city1.equals(city2))
				return 30;
			else{
				return city.getDistance(city1, city2);
			}
			
		}
		else{
			return 0;
		}
	}
 

	@Override
	public IdblService getIdblService(int ordinalLength) {
		// TODO Auto-generated method stub
		return new IdManager(organizationDataService, ordinalLength, false);
		 
	}

	@Override
	public IdblService getIdblService() {
		// 1TODO Auto-generated method stub
		return new IdManager(organizationDataService, 2, false);
	}

	@Override
	public String getCityId(String name) {
		// TODO Auto-generated method stub
		 
		String id = city.getId(name);
		return id;
	}

	@Override
	public List<String> getAllCityName() {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>();
		names = city.getAllName();
		return names;
	}
	
	public void execute(OrganizationVO vo){
		if(vo != null){
			 createOrganizationPO(vo);
		}
		
	}

	 
}

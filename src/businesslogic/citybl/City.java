package businesslogic.citybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import po.CityPO;
import dataservice.CityDataService;
import vo.CityVO;
import businesslogicservice.CityblService;

public class City implements CityblService{

	private CityDataService cityDataService;
	
	public City(){
		try { 
        	 cityDataService = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			 
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
	public boolean createCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		try { 
         
			cityDataService.insert(vo.getCityPO());
			System.out.println("citybl createcitypo");
			   	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		 try {
			 
			 cityDataService.delete(vo.getCityPO());
			 System.out.println("citybl deletecitypo");
	           
	        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();	        
	        }
		return true;
	}

	@Override
	public boolean modifyCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		 try {
			 
			 cityDataService.update(vo.getCityPO());
	           
	       
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
		return true;
	}

	@Override
	public CityVO getCity(String id) {
		// TODO Auto-generated method stub
		CityVO vo = null;
		 try {
			 
			 if(cityDataService.find(id)!=null)
				 vo = cityDataService.find(id).getCityVO();
	           
	        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vo;
	}

	@Override
	public List<CityVO> getAll() {
		// TODO Auto-generated method stub
		List<CityVO> vos =  new ArrayList<CityVO>();
		 try {
			 
			 List<CityPO> pos= cityDataService.getAll();
			 if(pos.isEmpty())
				 return vos;
			 for(CityPO po : pos){
				 vos.add(po.getCityVO());
			 }
	           
	        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
		return vos;
	}

	@Override
	public List<String> getAllName() {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList<String>();
		List<CityVO> vos = getAll();
		if(vos.isEmpty())
			return nameList;
		else {		 
			for(CityVO vo : vos)
				nameList.add(vo.getName());
			return nameList;
			}		
		}
	
	public double getDistance(String city1, String city2){
		CityPO po = null;
		try {
			po = cityDataService.findByName(city1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(po != null){
			double distance = po.getDistance().get(city2);
			return distance;
		}
		return 0;
	}

}

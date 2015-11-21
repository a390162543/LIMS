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

	@Override
	public boolean createCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		try { 
        	CityDataService eds = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			eds.insert(vo.getCityPO());
			System.out.println("citybl createcitypo");
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
		return true;
	}

	@Override
	public boolean deleteCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		 try {
			 CityDataService eds = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			 eds.delete(vo.getCityPO());
			 System.out.println("citybl deletecitypo");
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return true;
	}

	@Override
	public boolean modifyCityPO(CityVO vo) {
		// TODO Auto-generated method stub
		 try {
			 CityDataService eds = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			 eds.update(vo.getCityPO());
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
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
			 CityDataService eds = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			 if(eds.find(id)!=null)
				 vo = eds.find(id).getCityVO();
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
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
			 CityDataService eds = (CityDataService) Naming.lookup("rmi://localhost/CityData");
			 List<CityPO> pos= eds.getAll();
			 if(pos.isEmpty())
				 return vos;
			 for(CityPO po : pos){
				 vos.add(po.getCityVO());
			 }
	           
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NotBoundException e) {
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

}

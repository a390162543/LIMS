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
import businesslogicservice.OrganizationblService;

public class Organization implements OrganizationblService{

	@Override
	public boolean CreatOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		  try { 
	        	OrganizationDataService ods = (OrganizationDataService) Naming.lookup
	        			("rmi://localhost/OrganizationData");
				ods.insert(vo.getOrganizationPO());
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
	public boolean deleteOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		try { 
        	OrganizationDataService ods = (OrganizationDataService) Naming.lookup
        			("rmi://localhost/OrganizationData");
			ods.delete(vo.getOrganizationPO());
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
	public List<OrganizationVO> getOrganizationVO() {
		// TODO Auto-generated method stub
		List<OrganizationVO> vos =  new ArrayList<OrganizationVO>();
		 try {
			OrganizationDataService ods = (OrganizationDataService) Naming.lookup
						("rmi://localhost/OrganizationData");
			 List<OrganizationPO> pos= ods.getAll();
			 for(OrganizationPO po : pos){
				 vos.add(po.getOrganizationVO());
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
	public boolean modifyOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		 try {
			OrganizationDataService ods = (OrganizationDataService) Naming.lookup
					("rmi://localhost/OrganizationData");
			 ods.update(vo.getOrganizationPO());
	           
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
	public List<String> getAllOrganizationName() {
		// TODO Auto-generated method stub
		List<OrganizationVO> vos = getOrganizationVO();
		List<String> nameList = new ArrayList<String>();
		for(OrganizationVO vo : vos)
			nameList.add(vo.getName());
		
		return nameList;
	}

}

package businesslogic.employeebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.EmployeePO;
import dataservice.EmployeeDataService;
 
import vo.EmployeeVO;
import businesslogicservice.EmployeeblService;

public class Employee implements EmployeeblService{

	@Override
	public boolean creatEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		
         try { 
        	EmployeeDataService eds = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
			eds.insert(vo.getEmployeePO());
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
	public boolean deleteEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		 try {
			 EmployeeDataService eds = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
			 eds.delete(vo.getEmployeePO());
	           
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
	public boolean modifyEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		 try {
			 EmployeeDataService eds = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
			 eds.update(vo.getEmployeePO());
	           
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
	public List<EmployeeVO> getEmployeeVO() {
		// TODO Auto-generated method stub
		List<EmployeeVO> vos =  new ArrayList<EmployeeVO>();
		 try {
			 EmployeeDataService eds = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
			 List<EmployeePO> pos= eds.getAll();
			 for(EmployeePO po : pos){
				 vos.add(po.getEmployeeVO());
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
	public List<EmployeeVO> getDriverVO(String organiztion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO find(String id) {
		// TODO Auto-generated method stub
		try {
			 EmployeeDataService eds = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
			 if(eds.find(id).equals(null))
				 return null;
			 else {
				 EmployeeVO vo = eds.find(id).getEmployeeVO();
	             return vo; 
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
		return null;
	}

}

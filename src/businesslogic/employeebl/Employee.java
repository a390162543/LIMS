package businesslogic.employeebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.EmployeePO;
import systemenum.Position;
import systemenum.Power;
import dataservice.EmployeeDataService;
import vo.EmployeeVO;
import vo.PayVO;
import vo.UserVO;
import businesslogic.userbl.User;
import businesslogicservice.EmployeeblService;
import businesslogicservice.UserblService;
 

public class Employee implements EmployeeblService{

	private EmployeeDataService employeeDataService;
	 public Employee() {
		// TODO Auto-generated constructor stub

        try { 
        	employeeDataService = (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");			 
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
	public boolean creatEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		
         try { 
        	 
			employeeDataService.insert(vo.getEmployeePO());
			 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		 UserVO uservo = new UserVO(vo.getId(), "000000", Power.valueOf(vo.getPosition().toString()));
		 UserblService userblService = new User();			  		 
		 userblService.creatUserPO(uservo);

		return true;
	}

	@Override
	public boolean deleteEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		 try {
			 
			 employeeDataService.delete(vo.getEmployeePO());
			 } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return true;
	}

	@Override
	public boolean modifyEmployeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		 try {		  
			 employeeDataService.update(vo.getEmployeePO());  	        
	        } catch (RemoteException e) {
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
			 
			 List<EmployeePO> pos= employeeDataService.getAll();
			 for(EmployeePO po : pos){
				 vos.add(po.getEmployeeVO());
			 }
	           	         
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vos;
	}
	 

 
	public List<EmployeeVO> getDriverVO(String organiztion ) {
		// TODO Auto-generated method stub
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		try {
			 
			 List<EmployeePO> pos= employeeDataService.finds("organiztion", organiztion);
			 for(EmployeePO po : pos){
				 if(po.getPosition().equals(Position.DRIVER))
					 vos.add(po.getEmployeeVO());
			 }
	           	         
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vos;
	}
	

	public List<EmployeeVO> getCourierVO(String organiztion ) {
		// TODO Auto-generated method stub
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		try {
			
			 
			 List<EmployeePO> pos= employeeDataService.finds("organization", organiztion);
			 for(EmployeePO po : pos){
				 if(po.getPosition().equals(Position.COURIER))
					 vos.add(po.getEmployeeVO());
			 }
	           	         
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }  
		return vos;
	}


	@Override
	public EmployeeVO find(String id) {
		// TODO Auto-generated method stub
		try {
			 
			 if(employeeDataService.find(id).equals(null))
				 return null;
			 else {
				 EmployeeVO vo = employeeDataService.find(id).getEmployeeVO();
	             return vo; 
			}
			
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
		return null;
	}

	
//add pay
	public boolean addPay(String id, double salesCommission){
		EmployeeVO vo = find(id);
		PayVO payvo = vo.getPay();
		payvo.setSalesCommission(salesCommission + payvo.getSalesCommission());
		vo.setPay(payvo);
		modifyEmployeePO(vo);
		return true;
	}
	
	public boolean addPay(String id){
		EmployeeVO vo = find(id);
		PayVO payvo = vo.getPay();
		payvo.setCount(payvo.getCount()+1);
		vo.setPay(payvo);
		modifyEmployeePO(vo);
		return true;
	}
	

}

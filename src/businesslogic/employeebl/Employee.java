package businesslogic.employeebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import po.EmployeePO;
import systemenum.Position;
import systemenum.Power;
import dataservice.DataService;
import dataservice.EmployeeDataService;
import vo.EmployeeVO;
import vo.PayVO;
import vo.UserVO;
import businesslogic.BusinessLogicService;
import businesslogic.idbl.IdManager;
import businesslogic.userbl.User;
import businesslogicservice.EmployeeblService;
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;

 
/**
 * {@code Employee}��Ա��ҵ���߼���ʵ���࣬�ṩ�����й�Ա����ҵ���߼�����
 * @author ������
 *
 */
public class Employee implements EmployeeblService{

	private EmployeeDataService employeeDataService;
	private User  user;
	
	 public Employee() {
		// TODO Auto-generated constructor stub
		 user = new User();       
		 employeeDataService =  DataService.getEmployeeDataService();		 
			 
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
         
         //�½�һ���û�
		 UserVO uservo = new UserVO(vo.getId(), "000000", Power.valueOf(vo.getPosition().toString()));		  	  		 
		 user.creatUserPO(uservo);
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
		 
		 //ɾ���û��ʺ���Ϣ  	  		 
		 user.deleteUserPO(vo.getId());
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
	 

  /**
   * ��ȡһ������˾����Ϣ
   * @param organization, ��������
   * @return {@code List<EmployeeVO}����
   */
	public List<EmployeeVO> getDriverVO(String organiztion ) {
		// TODO Auto-generated method stub
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		try {
			 
			 List<EmployeePO> pos= employeeDataService.finds("organization", organiztion);
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

	
/**
 * ������ɹ���Ա�������۶�
 * @param id, Ա��id
 * @param salesCommission�� ���۶�
 * @return �ɹ���ӷ���true, ���򷵻�false
 */
	public boolean addPay(String id, double salesCommission){
		EmployeeVO vo = find(id);
		PayVO payvo = vo.getPay();
		payvo.setSalesCommission(salesCommission + payvo.getSalesCommission());
		vo.setPay(payvo);
		modifyEmployeePO(vo);
		return true;
	}
	/**
	 * ���� ���μƷ�Ա��һ�μ���
	 * @param id, Ա��id
	 * @return �ɹ����ӷ���true, ���򷵻�false
	 */
	public boolean addPay(String id){
		EmployeeVO vo = find(id);
		PayVO payvo = vo.getPay();
		payvo.setCount(payvo.getCount()+1);
		vo.setPay(payvo);
		modifyEmployeePO(vo);
		return true;
	}
	@Override
	public IdblService getIdblService() {
		// TODO Auto-generated method stub
		return new IdManager(employeeDataService, 3, false);
	}
	
	public boolean execute(EmployeeVO vo){
		if(vo == null){
			return false;
		}
		else{
			creatEmployeePO(vo);
			return true;
		}
		
	}
	@Override
	public String getOrganizationId(String name) {
		// TODO Auto-generated method stub
	     OrganizationblService organizationblService = BusinessLogicService.getOrganizationblService();
	     String id = organizationblService.getId(name);
		return id;
	}
	@Override
	public boolean createUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		if(vo != null){
			user.creatUserPO(vo);
			return true;
		}
		else{
			return false;
		}
		
	}
	

}

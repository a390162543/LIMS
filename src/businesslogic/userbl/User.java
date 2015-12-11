package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dataservice.DataService;
import dataservice.UserDataService;
import po.UserPO;
import vo.UserVO;
import businesslogicservice.UserblService;

/**
 * {@code User}���û�����ҵ���߼����ʵ���࣬�ṩ�����й��û�ҵ���߼�����
 * @author ������
 * @version 1.6
 * @see dataservice.UserDataService
 */
public class User implements UserblService{
	/**
	 * {@code User}�����ݲ�����
	 */
	private UserDataService userDataService;
	
	public User() {
		// TODO Auto-generated constructor stub
		userDataService = DataService.getUserDataService();
	}
	
	
	public boolean creatUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		try { 			 
			userDataService.insert(vo.getUserPO());
			 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

 
	public boolean deleteUserPO(String id) {
		// TODO Auto-generated method stub
		try {		 
			 userDataService.delete(id);          
	       
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();        
	        }
		return true;
	}

	@Override
	public boolean queryUserPO(String id, String passWord) {
		// TODO Auto-generated method stub
		UserVO vo = find(id);
		return passWord.equals(vo.getPassword());
	}
	
	@Override
	public boolean initialize(String id) {
		// TODO Auto-generated method stub
		UserVO vo = find(id);
		vo.setPassword("000000");
		try {			  
			 userDataService.update(vo.getUserPO());
	           	        
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        
	        }
		return true;
	}

	@Override
	public boolean modifyPower(UserVO vo) {
		// TODO Auto-generated method stub
		try {		 
			 userDataService.update(vo.getUserPO());   
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         
	        }
		return true;
	}

	@Override
	public List<UserVO> getUserVO() {
		// TODO Auto-generated method stub
		List<UserVO> vos =  new ArrayList<UserVO>();
		 try {			 
			 List<UserPO> pos= userDataService.getAll();
			 for(UserPO po : pos){
				 vos.add(po.getUserVO());
			 }           	       
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();	        
	        }
		return vos;
	}

	@Override
	public UserVO find(String id) {
		// TODO Auto-generated method stub
	 
		try {			 
			 if(userDataService.find(id) == null)
				 return null;
			 else{
				 UserVO vo =  userDataService.find(id).getUserVO();
			     return vo; 
			 }
			 	      
	    } catch (RemoteException e) {
	            // TODO Auto-generated catch block	       
	        }
		return null;
	}

	@Override
	public boolean modifyPassword(UserVO vo) {
		// TODO Auto-generated method stub
		try {
			userDataService.update(vo.getUserPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

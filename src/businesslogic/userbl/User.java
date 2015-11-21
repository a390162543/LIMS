package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.UserDataService;
import po.UserPO;
 
import vo.UserVO;
 
import businesslogicservice.UserblService;

public class User implements UserblService{

	@Override
	public boolean creatUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		try { 
        	UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			eds.insert(vo.getUserPO());
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
	public boolean deleteUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		try {
			 UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			 eds.delete(vo.getUserPO());
	           
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
			 UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			 eds.update(vo.getUserPO());
	           
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
	public boolean modifyPower(UserVO vo) {
		// TODO Auto-generated method stub

		try {
			 UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			 eds.update(vo.getUserPO());
	           
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
	public List<UserVO> getUserVO() {
		// TODO Auto-generated method stub
		List<UserVO> vos =  new ArrayList<UserVO>();
		 try {
			 UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			 List<UserPO> pos= eds.getAll();
			 for(UserPO po : pos){
				 vos.add(po.getUserVO());
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
	public UserVO find(String id) {
		// TODO Auto-generated method stub
	 
		try {
			 UserDataService eds = (UserDataService) Naming.lookup("rmi://localhost/UserData");
			 if(eds.find(id).equals(null))
				 return null;
			 else{
				 UserVO vo = eds.find(id).getUserVO();
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
	            return null;
	        }
		return null;
	}

	@Override
	public boolean modifyPassword(UserVO vo) {
		// TODO Auto-generated method stub
		
		return false;
	}

}

package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import dataservice.AccountDataService;
import vo.AccountVO;
import businesslogicservice.AccountblService;

public class Account implements AccountblService {

	@Override
	public boolean createAccountPO(AccountVO vo) {
        try {
        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");
            ads.insert(vo.getAccountPO());
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
	public boolean deleteAccountPO(AccountVO vo) {
        try {
        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");
            ads.delete(vo.getAccountPO());
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
	public boolean modifyAccountPO(AccountVO vo) {
		  try {
	        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");     
	        	AccountPO po = ads.find(vo.getId());
	        	po.update(vo);
	        	ads.update(po);
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
	public List<AccountVO> getAccountVO() {
        List<AccountVO> vos = new ArrayList<AccountVO>();
        try {
        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");
            List<AccountPO> pos = ads.getAll();
            for(AccountPO po : pos){
                vos.add(po.getAccountVO());
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

	public boolean updateAccountBalance(String accountId ,double money){
		try {
        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");     
        	AccountPO po = ads.find(accountId);
        	po.setMoney(po.getMoney()+money);
        	ads.update(po);
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

	
	public String[] getAllAccountId() {	
			String[] accountId = null;
	        try {
	        	AccountDataService ads = (AccountDataService) Naming.lookup("rmi://localhost/AccountData");
	            List<AccountPO> pos = ads.getAll(); 
	            accountId = new String[pos.size()];
	            for(int i = 0;i<pos.size();i++)
	                accountId[i] = pos.get(i).getId();
	            
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
	      
		return accountId;
	}
}

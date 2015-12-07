package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import dataservice.AccountDataService;
import dataservice.DataService;
import vo.AccountVO;
import businesslogicservice.AccountblService;

/**
 * {@code Account}是账户的业务逻辑的实现类，提供所有有关账户的业务逻辑服务
 * @author 刘德宽
 * @version 1.6
 * @see dataservice.AccountDataService
 */
public class Account implements AccountblService {

	private AccountDataService accountDataService;
	
	public Account(){
		accountDataService = DataService.getAccountDataService();
	}
	@Override
	public boolean createAccountPO(AccountVO vo) {
        try {
        	accountDataService.insert(vo.getAccountPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean deleteAccountPO(AccountVO vo) {
        try {
        	accountDataService.delete(vo.getAccountPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public boolean modifyAccountPO(AccountVO vo) {
		  try {
	        	AccountPO po = accountDataService.find(vo.getId());
	        	po.update(vo);
	        	accountDataService.update(po);
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return true;
	}

	@Override
	public List<AccountVO> getAccountVO() {
        List<AccountVO> vos = new ArrayList<AccountVO>();
        try {
            List<AccountPO> pos = accountDataService.getAll();
            for(AccountPO po : pos){
                vos.add(po.getAccountVO());
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vos;
	}

    /**
     * 对{@code AccounrVO}的余额进行加款和扣款
     * @param accountId {@code String}
     * @param money {@code double}
     * @return 成功则返回{@code true}，否则返回{@code false}
     */
	public boolean updateAccountBalance(String accountId ,double money){
		try {
        	AccountPO po = accountDataService.find(accountId);
        	po.setMoney(po.getMoney()+money);
        	accountDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return true;
	}

    /**
     * 获取所有账户编号信息
     * @return {@code String}数组，如果不存在或者查询失败，则返回空数组
     */  
	public String[] getAllAccountId() {	
			String[] accountId = null;
	        try {
	            List<AccountPO> pos = accountDataService.getAll(); 
	            accountId = new String[pos.size()];
	            for(int i = 0;i<pos.size();i++)
	                accountId[i] = pos.get(i).getId();
	            
	        } catch (RemoteException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	      
		return accountId;
	}
	
    /**
     * 对期初建账的{@code AccounrVO}进行执行
     * @param vo {@code AccountVO}
     * @return 成功则返回{@code true}，否则返回{@code false}
     */
	public boolean execute(AccountVO vo){
		
		return createAccountPO(vo);
	}
}

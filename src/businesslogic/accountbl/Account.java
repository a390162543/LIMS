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
 * {@code Account}���˻���ҵ���߼���ʵ���࣬�ṩ�����й��˻���ҵ���߼�����
 * @author ���¿�
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
     * ��{@code AccounrVO}�������мӿ�Ϳۿ�
     * @param accountId {@code String}
     * @param money {@code double}
     * @return �ɹ��򷵻�{@code true}�����򷵻�{@code false}
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
     * ��ȡ�����˻������Ϣ
     * @return {@code String}���飬��������ڻ��߲�ѯʧ�ܣ��򷵻ؿ�����
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
     * ���ڳ����˵�{@code AccounrVO}����ִ��
     * @param vo {@code AccountVO}
     * @return �ɹ��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean execute(AccountVO vo){
		
		return createAccountPO(vo);
	}
}

package businesslogicservice;

import po.AccountPO;

public interface AccountblService {
	public  AccountPO createAccountPO(long name, double money);
	
	public  boolean deleteAccountPO();
	
	public boolean modifyAccountPO();
	
	public boolean queryAccountPO(AccountPO account);
	
	public boolean setFocusedAccountPO(int index);
}

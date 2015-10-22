package dataservice;

import java.util.List;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountDataService {

	public boolean insert(AccountPO po);
	
	public boolean delete(AccountPO po);
	
	public boolean update(AccountPO po);
	
	public AccountPO find(long id);
	
	public List<AccountPO> finds(String field, Object value);
	
	public List<AccountPO> getAll();
	
}

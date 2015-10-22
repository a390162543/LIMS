package dataservice;

import java.util.List;

import po.PaymentPO;
import po.PrimeInfoPO;

public interface PrimeInfoDataService {

	public boolean insert(PrimeInfoPO po);
	
	public boolean delete(PrimeInfoPO po);
	
	public boolean update(PrimeInfoPO po);
	
	public PrimeInfoPO find(long id);
	
	public List<PrimeInfoPO> finds(String field, Object value);
	
	public List<PrimeInfoPO> getAll();
}

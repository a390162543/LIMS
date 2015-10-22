package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.TransferPO;

public interface TransferblService {
	public TransferPO createTransferPO(Date loadDate, long transferID, 
			long flightNumber, String depart, String destination,long containerId,
			String loadMan, List<Long> orderId, double expenses);
	
	
	public double getCost(String depart, String destination);
	
	public List<TransferPO> getTransferPO();
}

package businesslogicservice;

import java.util.List;

import po.TransferPO;
import vo.TransferVO;

public interface TransferblService {
	public TransferPO createTransferPO(TransferVO vo);
	
	
	public double getCost(TransferVO vo);
	
	public boolean modify(TransferVO vo);
	
	public List<TransferVO> getTransferPO();
	
	public boolean execute(TransferVO vo);
}

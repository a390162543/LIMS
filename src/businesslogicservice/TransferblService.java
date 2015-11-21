package businesslogicservice;

import java.util.List;

import po.TransferPO;
import vo.TransferVO;

public interface TransferblService {
	public boolean createTransferPO(TransferVO vo);
	
	
	public double getCost(TransferVO vo);
	
	public boolean modify(TransferVO vo);
	
	public List<TransferVO> getTransferVO();
	
	public boolean execute(TransferVO vo);
}

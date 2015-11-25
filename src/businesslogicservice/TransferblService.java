package businesslogicservice;

import java.util.List;

import po.TransferPO;
import vo.GoodsVO;
import vo.TransferVO;

public interface TransferblService {
	public boolean createTransferPO(TransferVO vo);
	
	
	public double getCost(String location1, String location2);
	
	public boolean modifyTransferPO(TransferVO vo);
	
	public List<TransferVO> getTransferVO();
	
	public boolean execute(TransferVO vo);
	
	public GoodsVO getGoodsVO(String id);
	
	public void addGoods(GoodsVO vo);
	
	public void deleteGoods(GoodsVO vo);
}

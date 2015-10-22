package businesslogicservice;
import java.util.List;

import po.ApprovalPO;
public interface ApprovalblService {
	
	public boolean add(LogisticsDocument LD);
	
	public List<ApprovalPO>  getApprovalPO();
		
	public boolean approve(LogisticsDocument LD);
}

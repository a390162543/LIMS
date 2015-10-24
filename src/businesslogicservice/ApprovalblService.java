package businesslogicservice;
import java.util.List;

import po.ApprovalPO;
public interface ApprovalblService {
	
	public boolean add(Object o);
	
	public List<ApprovalPO>  getApprovalPO();
		
	public boolean approve();
	
	public boolean modifyDocument(Object o);
}

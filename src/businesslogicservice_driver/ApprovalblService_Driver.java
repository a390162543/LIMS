package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.TransferPO;
import businesslogicservice.ApprovalblService;

public class ApprovalblService_Driver {
	public void driver(ApprovalblService approvalblService){
		List<Long> l = new ArrayList<Long>();
		l.add(new Long("1088336612"));
		TransferPO po = new TransferPO(new Long("02501601120000001"), new Date(),
				new Long("10240010001"), "�Ͼ�����ϼ����ת����",
				"�Ϻ����ֶ�������ת����" ,
				new Long("1025"), "�", l, 300.0);
		approvalblService.approve(po);
		approvalblService.getArrivalVO();
		approvalblService.getDeliverVO();
		approvalblService.getLoadVO();
		approvalblService.getOrderVO();
		approvalblService.getPaymentVO();
		approvalblService.getRevenueVO();
		approvalblService.getStoreinVO();
		approvalblService.getStoreoutVO();
		approvalblService.getTransferVO();
		approvalblService.modify(po);
	}
}

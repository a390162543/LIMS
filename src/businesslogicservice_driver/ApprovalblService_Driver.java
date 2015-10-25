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
		approvalblService.getArrivalPO();
		approvalblService.getDeliverPO();
		approvalblService.getLoadPO();
		approvalblService.getOrderPO();
		approvalblService.getPaymentPO();
		approvalblService.getRevenuePO();
		approvalblService.getStoreoutPO();
		approvalblService.getStoreinPO();
		approvalblService.getTransferPO();
		approvalblService.modify(po);
	}
}

package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.TransferblService;
import vo.TransferVO;
import dataservice.TransferDataService;

public class TransferblService_Driver {
	public void drive(TransferblService transferblservice){
		long l = new Long("1008356612");
		List<Long> ll = new ArrayList<Long>();
		ll.add(l);
		TransferVO vo = new TransferVO(new Long("02501610120000001"), new Date(),
				new Long("102111011"), "�Ͼ�����ϼ����ת����",  
				"�Ϻ����ֶ�������ת����",  new Long("1024"), "Tom",
				ll, 200);
		
		transferblservice.createTransferPO(vo);
		transferblservice.execute(vo);
		transferblservice.getCost(vo);
		transferblservice.getTransferVO();
		transferblservice.modify(vo);
	}
}

package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.RevenueVO;
import businesslogicservice.SettlementblService;


public class SettlementblService_Driver {

	public void drive(SettlementblService settlementblService){
		List<String> list=new ArrayList<String>();
		list.add("1008356612");
		list.add("1008356614");
		
		boolean result2=settlementblService.setAccountId(new RevenueVO("025001150118000001", new Date(),"025001150118000001" , 30.00,list,"南京市鼓楼区营业厅"),"025001150118000001");
		if(result2==true)
			System.out.println("set succeed\n");
		
		List<RevenueVO> vos = settlementblService.queryRevenueVO(new Date(), "南京市鼓楼区营业厅");
	    System.out.println("get "+vos.size()+" AccountVO!");
	}
}

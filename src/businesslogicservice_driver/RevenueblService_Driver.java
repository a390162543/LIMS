package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.RevenueVO;
import businesslogicservice.RevenueblService;

public class RevenueblService_Driver {
    public void drive(RevenueblService revenueblService){
        List<String> orderList = new ArrayList<String>();
        orderList.add(new String("1010000101"));
        RevenueVO vo = new RevenueVO(new String("025001150118000001"), new Date(), new String("025001001"), 18.8, orderList);
        
        boolean createResult = revenueblService.createRevenuePO(vo);
        if(createResult == true)
            System.out.println("create succeed!");
       
        boolean modifyResult = revenueblService.modifyRevenuePO(vo);
        if(modifyResult == true)
            System.out.println("modify succeed!");
       
        boolean executeResult = revenueblService.execute(vo);
        if(executeResult == true)
            System.out.println("execute succeed!");
        
    }
}
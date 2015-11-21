package businesslogicservice_driver;

import java.util.Date;

import vo.DeliverVO;
import businesslogicservice.DeliverblService;

public class DeliverblService_Driver {
    public void drive(DeliverblService deliverblService){
        DeliverVO vo = new DeliverVO(new String("025001150118000001"), new Date(), new String("1008000010"), new String("025001001"));
        
        boolean createResult = deliverblService.createDeliverPO(vo);
        if(createResult == true)
            System.out.println("create succeed!");
       
        boolean modifyResult = deliverblService.modifyDeliverPO(vo);
        if(modifyResult == true)
            System.out.println("modify succeed!");
        
        boolean executeResult = deliverblService.execute(vo);
        if(executeResult == true)
            System.out.println("execute succeed!");
        
    }
}
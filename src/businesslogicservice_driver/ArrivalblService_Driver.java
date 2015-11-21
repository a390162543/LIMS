package businesslogicservice_driver;

import java.util.Date;

import systemenum.GoodsState;
import vo.ArrivalVO;
import businesslogicservice.ArrivalblService;

public class ArrivalblService_Driver {
    public void drive(ArrivalblService arrivalblService){
        ArrivalVO vo = new ArrivalVO(new String("025001150118000001"), new Date(), new String("02501601120000001"), "南京市栖霞区中转中心", GoodsState.COMPLETE);
        
        boolean createResult = arrivalblService.createArrivalPO(vo);
        if(createResult == true)
            System.out.println("create succeed!");
        
        boolean modifyResult = arrivalblService.modifyArrivalPO(vo);
        if(modifyResult == true)
            System.out.println("modify succeed!");
        
        boolean executeResult = arrivalblService.execute(vo);
        if(executeResult == true)
            System.out.println("execute succeed!");
        
    }
}

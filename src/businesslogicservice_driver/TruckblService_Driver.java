package businesslogicservice_driver;

import java.util.Date;
import java.util.List;

import vo.TruckVO;
import businesslogicservice.TruckblService;

public class TruckblService_Driver {
    public void drive(TruckblService truckblService){
        TruckVO vo = new TruckVO(new Long("025001014"), "EA043247", "À’A°§88888", "EA162736", new Date(), null);
       
        boolean createResult = truckblService.createTruckPO(vo);
        if(createResult == true)
            System.out.println("create succeed!");
       
        boolean executeResult = truckblService.deleteTruckPO(vo);
        if(executeResult == true)
            System.out.println("delete succeed!");
        
        boolean modifyResult = truckblService.modifyTruckPO(vo);
        if(modifyResult == true)
            System.out.println("modify succeed!");
        
        List<TruckVO> vos = truckblService.getTruckVO();
        System.out.println("get "+vos.size()+" TruckVO!");
        
    }
}

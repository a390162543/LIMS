package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.ArrivalPO;
import systemenum.GoodsState;
import dataservice.ArrivalDataService;

public class ArrivalDataService_Driver {
    public void drive(ArrivalDataService arrivalDataService){
        ArrivalPO po = new ArrivalPO(new Long("025001150118000001"), new Date(), new Long("02501601120000001"), "南京市栖霞区中转中心", GoodsState.COMPLETE);
        try {
            arrivalDataService.init();
            arrivalDataService.insert(po);
            arrivalDataService.update(po);
            ArrivalPO poFound =arrivalDataService.find(new Long("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            List<ArrivalPO> pos = arrivalDataService.finds("id", new Long("025001150118000001"));
            System.out.println("get "+pos.size()+" ArrivalPO!");
            arrivalDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

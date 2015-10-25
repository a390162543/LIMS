package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.TruckPO;
import dataservice.TruckDataService;

public class TruckDataService_Driver {
    public void drive(TruckDataService truckDataService){
        List<Long> orderList = new ArrayList<Long>();
        orderList.add(new Long("1010000101"));
        TruckPO po = new TruckPO(new Long("025001014"), "EA043247", "À’A°§88888", "EA162736", new Date(), null);
        try {
            truckDataService.init();
            truckDataService.insert(po);
            truckDataService.update(po);
            TruckPO poFound =truckDataService.find(new Long("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            truckDataService.delete(poFound);
            List<TruckPO> pos = truckDataService.finds("id", new Long("025001150118000001"));
            System.out.println("get "+pos.size()+" TruckPO!");
            List<TruckPO> allPO = truckDataService.getAll();
            System.out.println("get "+allPO.size()+" TruckPO!");
            truckDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

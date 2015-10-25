package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.DeliverPO;
import dataservice.DeliverDataService;

public class DeliverDataService_Driver {
    public void drive(DeliverDataService deliverDataService){
        DeliverPO po = new DeliverPO(new Long("025001150118000001"), new Date(), new Long("1008000010"), new Long("025001001"));
        try {
            deliverDataService.init();
            deliverDataService.insert(po);
            deliverDataService.update(po);
            DeliverPO poFound =deliverDataService.find(new Long("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            List<DeliverPO> pos = deliverDataService.finds("id", new Long("025001150118000001"));
            System.out.println("get "+pos.size()+" DeliverPO!");
            deliverDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

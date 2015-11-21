package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.RevenuePO;
import dataservice.RevenueDataService;

public class RevenueDataService_Driver {
    public void drive(RevenueDataService revenueDataService){
        List<String> orderList = new ArrayList<String>();
        orderList.add(new String("1010000101"));
        RevenuePO po = new RevenuePO(new String("025001150118000001"), new Date(), new String("025001001"), 18.8, orderList);
        try {
            revenueDataService.init();
            revenueDataService.insert(po);
            revenueDataService.update(po);
            RevenuePO poFound =revenueDataService.find(new String("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            List<RevenuePO> pos = revenueDataService.finds("id", new String("025001150118000001"));
            System.out.println("get "+pos.size()+" RevenuePO!");
            List<RevenuePO> allPO = revenueDataService.getAll();
            System.out.println("get "+allPO.size()+" RevenuePO!");
            revenueDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

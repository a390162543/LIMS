package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.LoadPO;
import dataservice.LoadDataService;

public class LoadDataService_Driver {
    public void drive(LoadDataService loadDataService){
        List<Long> orderList = new ArrayList<Long>();
        orderList.add(new Long("1010000101"));
        LoadPO po = new LoadPO(new Long("025001150118000001"), new Date(), new Long("02500115101000000"), "南京市栖霞区中转中心", new Long("025001014"), "张三", "李四", orderList, 2.98);
        try {
            loadDataService.init();
            loadDataService.insert(po);
            loadDataService.update(po);
            LoadPO poFound =loadDataService.find(new Long("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            List<LoadPO> pos = loadDataService.finds("id", new Long("025001150118000001"));
            System.out.println("get "+pos.size()+" LoadPO!");
            loadDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

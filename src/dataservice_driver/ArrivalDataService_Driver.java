package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.ArrivalPO;
import systemenum.GoodsState;
import dataservice.ArrivalDataService;

public class ArrivalDataService_Driver {
    public void drive(ArrivalDataService arrivalDataService){
        ArrivalPO po = new ArrivalPO("025001150118000001", new Date(), "02501601120000001", "�Ͼ�����ϼ����ת����", GoodsState.COMPLETE);
        try {
            arrivalDataService.init();
            arrivalDataService.insert(po);
            arrivalDataService.update(po);
            ArrivalPO poFound =arrivalDataService.find(new String("025001150118000001"));
            if(poFound != null)
                System.out.println("find succeed!");
            List<ArrivalPO> pos = arrivalDataService.finds("id", new String("025001150118000001"));
            System.out.println("get "+pos.size()+" ArrivalPO!");
            arrivalDataService.finish();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

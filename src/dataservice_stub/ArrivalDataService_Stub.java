package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import dataservice.ArrivalDataService;

public class ArrivalDataService_Stub implements ArrivalDataService{
    
    ArrivalPO po;
    
    public ArrivalDataService_Stub(ArrivalPO po){
        this.po = po;
    }
    
    @Override
    public void insert(ArrivalPO po) throws RemoteException {
        System.out.println("insert succeed!");   
    }

    @Override
    public void update(ArrivalPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public ArrivalPO find(String id) throws RemoteException {
        System.out.println("find succeed!");
        return po;
    }

    @Override
    public List<ArrivalPO> finds(String field, Object value)
            throws RemoteException {
        System.out.println("finds succeed!");
        List<ArrivalPO> list = new ArrayList<ArrivalPO>();
        list.add(po);
        return list;
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("init succeed!");
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("finished!");
    }

    
}

package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DeliverPO;
import dataservice.DeliverDataService;

public class DeliverDataService_Stub implements DeliverDataService{
    
    DeliverPO po;
    
    public DeliverDataService_Stub(DeliverPO po){
        this.po = po;
    }
    
    @Override
    public void insert(DeliverPO po) throws RemoteException {
        System.out.println("insert succeed!");   
    }

    @Override
    public void update(DeliverPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public DeliverPO find(long id) throws RemoteException {
        System.out.println("find succeed!");
        return po;
    }

    @Override
    public List<DeliverPO> finds(String field, Object value)
            throws RemoteException {
        System.out.println("finds succeed!");
        List<DeliverPO> list = new ArrayList<DeliverPO>();
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
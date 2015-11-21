package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LoadPO;
import dataservice.LoadDataService;

public class LoadDataService_Stub implements LoadDataService{
    
    LoadPO po;
    
    public LoadDataService_Stub(LoadPO po){
        this.po = po;
    }
    
    @Override
    public void insert(LoadPO po) throws RemoteException {
        System.out.println("insert succeed!");   
    }

    @Override
    public void update(LoadPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public LoadPO find(String id) throws RemoteException {
        System.out.println("find succeed!");
        return po;
    }

    @Override
    public List<LoadPO> finds(String field, Object value)
            throws RemoteException {
        System.out.println("finds succeed!");
        List<LoadPO> list = new ArrayList<LoadPO>();
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
package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.TruckPO;
import dataservice.TruckDataService;

public class TruckDataService_Stub implements TruckDataService{
    
    TruckPO po;
    
    public TruckDataService_Stub(TruckPO po){
        this.po = po;
    }
    
    @Override
    public void insert(TruckPO po) throws RemoteException {
        System.out.println("insert succeed!");   
    }

    @Override
    public void delete(TruckPO po) throws RemoteException {
        System.out.println("delete succeed!");   
    }
    
    @Override
    public void update(TruckPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public TruckPO find(long id) throws RemoteException {
        System.out.println("find succeed!");
        return po;
    }

    @Override
    public List<TruckPO> finds(String field, Object value)
            throws RemoteException {
        System.out.println("finds succeed!");
        List<TruckPO> list = new ArrayList<TruckPO>();
        list.add(po);
        return list;
    }

    @Override
    public List<TruckPO> getAll() throws RemoteException {
        System.out.println("get all succeed!");
        List<TruckPO> list = new ArrayList<TruckPO>();
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
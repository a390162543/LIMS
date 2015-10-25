package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.RevenuePO;
import dataservice.RevenueDataService;

public class RevenueDataService_Stub implements RevenueDataService{
    
    RevenuePO po;
    
    public RevenueDataService_Stub(RevenuePO po){
        this.po = po;
    }
    
    @Override
    public void insert(RevenuePO po) throws RemoteException {
        System.out.println("insert succeed!");   
    }

    @Override
    public void update(RevenuePO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public RevenuePO find(long id) throws RemoteException {
        System.out.println("find succeed!");
        return po;
    }

    @Override
    public List<RevenuePO> finds(String field, Object value)
            throws RemoteException {
        System.out.println("finds succeed!");
        List<RevenuePO> list = new ArrayList<RevenuePO>();
        list.add(po);
        return list;
    }

    @Override
    public List<RevenuePO> getAll() throws RemoteException {
        System.out.println("get all succeed!");
        List<RevenuePO> list = new ArrayList<RevenuePO>();
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

package businesslogic.truckbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.TruckPO;
import vo.TruckVO;
import businesslogicservice.TruckblService;
import dataservice.TruckDataService;

public class Truck implements TruckblService{
    
    private TruckDataService truckDataService;
    
    public Truck(){
        try {
            truckDataService = (TruckDataService) Naming.lookup("rmi://localhost/TruckData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean createTruckPO(TruckVO vo) {
        try {
            truckDataService.insert(vo.getTruckPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteTruckPO(TruckVO vo) {
        try {
            truckDataService.delete(vo.getTruckPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyTruckPO(TruckVO vo) {
        TruckPO po;
        try {
            po = truckDataService.find(vo.getId());
            po.update(vo);
            truckDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<TruckVO> getTruckVO() {
        List<TruckVO> vos = new ArrayList<TruckVO>();
        List<TruckPO> pos;
        try {
            pos = truckDataService.getAll();
            for(TruckPO po : pos){
                vos.add(po.getTruckVO());
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vos;
    }

}

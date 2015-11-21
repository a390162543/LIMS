package businesslogic.arrivalbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.ArrivalPO;
import dataservice.ArrivalDataService;
import vo.ArrivalVO;
import businesslogicservice.ArrivalblService;

public class Arrival implements ArrivalblService{

    private ArrivalDataService arrivalDataService;
    
    public Arrival(){
        try {
            arrivalDataService = (ArrivalDataService) Naming.lookup("rmi://localhost/ArrivalData");
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
    public boolean createArrivalPO(ArrivalVO vo) {
        try {
            arrivalDataService.insert(vo.getArrivalPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyArrivalPO(ArrivalVO vo) {
        ArrivalPO po;
        try {
            po = arrivalDataService.find(vo.getId());
            po.update(vo);
            arrivalDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean execute(ArrivalVO vo) {
        // TODO Auto-generated method stub
        return false;
    }

}

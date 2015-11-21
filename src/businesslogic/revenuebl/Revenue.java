package businesslogic.revenuebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.RevenuePO;
import dataservice.RevenueDataService;
import vo.RevenueVO;
import businesslogicservice.RevenueblService;

public class Revenue implements RevenueblService{

    private RevenueDataService revenueDataService;
    
    public Revenue(){
        try {
            revenueDataService = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
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
    public boolean createRevenuePO(RevenueVO vo) {
        try {
            revenueDataService.insert(vo.getRevenuePO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyRevenuePO(RevenueVO vo) {
        RevenuePO po;
        try {
            po = revenueDataService.find(vo.getId());
            po.update(vo);
            revenueDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean execute(RevenueVO vo) {
        // TODO Auto-generated method stub
        return false;
    }

}

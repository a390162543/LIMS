package businesslogic.deliverbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DeliverPO;
import systemenum.DocumentState;
import dataservice.DeliverDataService;
import vo.DeliverVO;
import businesslogicservice.DeliverblService;

public class Deliver implements DeliverblService{
    
    private DeliverDataService deliverDataService;
    
    public Deliver(){
        try {
            deliverDataService = (DeliverDataService) Naming.lookup("rmi://localhost/DeliverData");
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
    public boolean createDeliverPO(DeliverVO vo) {
        try {
            deliverDataService.insert(vo.getDeliverPO());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyDeliverPO(DeliverVO vo) {
        DeliverPO po;
        try {
            po = deliverDataService.find(vo.getId());
            po.update(vo);
            deliverDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean execute(DeliverVO vo) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public List<DeliverVO> getPendingDeliverVO(){
        List<DeliverPO> pos = null;
        List<DeliverVO> vos = new ArrayList<DeliverVO>();
        try {
            pos = deliverDataService.finds("documentState", DocumentState.PENDING);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(DeliverPO po:pos){
            vos.add(po.getDeliverVO());
        }
        return vos;
    }
    
}

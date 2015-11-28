package businesslogic.deliverbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DeliverPO;
import po.OrderPO;
import systemenum.DocumentState;
import dataservice.DataService;
import dataservice.DeliverDataService;
import dataservice.OrderDataService;
import vo.DeliverVO;
import businesslogic.BusinessLogicUtil;
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
        try {
            DeliverPO po = deliverDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            deliverDataService.update(po);
            
            OrderDataService orderDataService = DataService.getOrderDataService();
            
            OrderPO orderPO = orderDataService.find(vo.getOrderId());
            
            String deliverInfo = orderPO.getDeliverInfo();
            deliverInfo += BusinessLogicUtil.getTime(vo.getDeliverDate())+
                    " 货物正在由快递员"+vo.getCourierId()+"派件\n";
            orderPO.setDeliverInfo(deliverInfo);
            
            orderDataService.update(orderPO);
                
            
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

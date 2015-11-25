package businesslogic.arrivalbl;

import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.ArrivalPO;
import po.OrderPO;
import po.TransferPO;
import systemenum.DocumentState;
import dataservice.ArrivalDataService;
import dataservice.DataService;
import dataservice.OrderDataService;
import dataservice.TransferDataService;
import vo.ArrivalVO;
import businesslogic.BusinessLogicUtil;
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
        try {
            ArrivalPO po = arrivalDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            arrivalDataService.update(po);
            TransferDataService transferDataService = DataService.getTransferDataService();
            TransferPO transferPO = transferDataService.find(vo.getTransferId());
            List<String> orders = transferPO.getOrderId();
            OrderDataService orderDataService = DataService.getOrderDataService();
            for(String order : orders){
                OrderPO orderPO = orderDataService.find(order);
                
                orderPO.setNowLocation(vo.getDestination());
                
                String deliverInfo = orderPO.getDeliverInfo();
                deliverInfo += BusinessLogicUtil.getTime(vo.getArrivalDate())+
                        " 货物已到达"+vo.getDestination()+"\n";
                orderPO.setDeliverInfo(deliverInfo);
                
                orderDataService.update(orderPO);
                
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public List<ArrivalVO> getPendingArrivalVO(){
        List<ArrivalPO> pos = null;
        List<ArrivalVO> vos = new ArrayList<ArrivalVO>();
        try {
            pos = arrivalDataService.finds("documentState", DocumentState.PENDING);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(ArrivalPO po:pos){
            vos.add(po.getArrivalVO());
        }
        return vos;
    }
    
    
    public List<ArrivalVO> finds(String field, Object value){
        List<ArrivalPO> pos = null;
        List<ArrivalVO> vos = new ArrayList<ArrivalVO>();
        try {
            pos = arrivalDataService.finds(field, value);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(ArrivalPO po:pos){
            vos.add(po.getArrivalVO());
        }
        return vos;
    }
}

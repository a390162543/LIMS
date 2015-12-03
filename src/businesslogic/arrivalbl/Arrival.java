package businesslogic.arrivalbl;

import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;

import po.ArrivalPO;
import po.TransferPO;
import systemenum.DocumentState;
import dataservice.ArrivalDataService;
import dataservice.DataService;
import dataservice.TransferDataService;
import vo.ArrivalVO;
import vo.LoadVO;
import vo.OrderDeliverInfoVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.idbl.IdManager;
import businesslogic.loadbl.Load;
import businesslogic.orderbl.Order;
import businesslogicservice.ArrivalblService;
import businesslogicservice.IdblService;

public class Arrival implements ArrivalblService{

    private ArrivalDataService arrivalDataService;
    
    public Arrival(){
            arrivalDataService = DataService.getArrivalDataService();
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
            List<String> orders;

            if(vo.isTransferId()){
                TransferDataService transferDataService = DataService.getTransferDataService();
                TransferPO transferPO = transferDataService.find(vo.getTransferId());
                orders = transferPO.getOrderId();
            }else{
                Load loadbl = new Load();
                LoadVO loadVO = loadbl.getLoadVO(vo.getId());
                orders = loadVO.getOrderId();
            }

            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getArrivalDate())+
                        " 货物已到达"+vo.getDestination()+"\n";   
                OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(orderId, vo.getDestination(), vo.getDestination(), deliverInfo);
                orderbl.modifyDeliverInfo(orderDeliverInfoVO);
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

    @Override
    public IdblService getIdblService() {
        return new IdManager(arrivalDataService, 6);
    }
}

package businesslogic.arrivalbl;

import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;

import po.ArrivalPO;
import systemenum.DocumentState;
import dataservice.ArrivalDataService;
import dataservice.DataService;
import vo.ArrivalVO;
import vo.LoadVO;
import vo.OrderDeliverInfoVO;
import vo.TransferVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.idbl.IdManager;
import businesslogic.loadbl.Load;
import businesslogic.orderbl.Order;
import businesslogic.transferbl.Transfer;
import businesslogicservice.ArrivalblService;
import businesslogicservice.IdblService;

/**
 * {@code Arrival}是到达单业务逻辑的实现类，提供所有有关到达单的业务逻辑服务
 * @author 林祖华
 * @version 1.6
 * @see dataservice.ArrivalDataService
 */
public class Arrival implements ArrivalblService{

    /**
     * {@code Arrival}的数据层服务引用
     */
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
            //更改到达单的状态
            ArrivalPO po = arrivalDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            arrivalDataService.update(po);
            
            //获取订单列表，要先判断ArrivalVO的transferId是否是中转单
            List<String> orders;

            if(vo.isTransferId()){
                Transfer transferbl = new Transfer();
                TransferVO transferVO = transferbl.getTransferVO(vo.getTransferId());
                orders = transferVO.getOrderId();
            }else{
                Load loadbl = new Load();
                LoadVO loadVO = loadbl.getLoadVO(vo.getTransferId());
                orders = loadVO.getOrderId();
            }

            //获取订单业务逻辑，并且更新订单状态
            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getArrivalDate())+
                        " 货物已到达"+vo.getDestination();   
                OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(orderId, vo.getDestination(), vo.getDestination(), deliverInfo);
                orderbl.modifyDeliverInfo(orderDeliverInfoVO);
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获取所有待审批的{@code ArrivalVO}
     * @return {@code Arrival}的列表，如果没有符合条件的{@code ArrivalVO}，或者查询
     * 失败，则返回一个空列表
     */
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
    
    /**
     * 获取符合条件的{@code ArrivalVO}
     * 
     * <p><Strong>该方法不推荐使用</Strong>
     * @param field {@code ArrivalPO}对应的变量名
     * @param value {@code ArrivalPO}对应的变量值
     * @return 符合条件的{@code ArrivalVO}列表，如果不存在或者查询失败，则返回空列表
     */
    @Deprecated
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

    @Override
    public LoadVO getLoadVO(String id) {
        Load loadbl = new Load();
        return loadbl.getLoadVO(id);
    }

    @Override
    public TransferVO getTransferVO(String id) {
        Transfer transferbl = new Transfer();
        return transferbl.getTransferVO(id);
    }
    
    
}

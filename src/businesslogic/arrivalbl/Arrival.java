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
 * {@code Arrival}�ǵ��ﵥҵ���߼���ʵ���࣬�ṩ�����йص��ﵥ��ҵ���߼�����
 * @author ���滪
 * @version 1.6
 * @see dataservice.ArrivalDataService
 */
public class Arrival implements ArrivalblService{

    /**
     * {@code Arrival}�����ݲ��������
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
            //���ĵ��ﵥ��״̬
            ArrivalPO po = arrivalDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            arrivalDataService.update(po);
            
            //��ȡ�����б�Ҫ���ж�ArrivalVO��transferId�Ƿ�����ת��
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

            //��ȡ����ҵ���߼������Ҹ��¶���״̬
            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getArrivalDate())+
                        " �����ѵ���"+vo.getDestination();   
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
     * ��ȡ���д�������{@code ArrivalVO}
     * @return {@code Arrival}���б����û�з���������{@code ArrivalVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
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
     * ��ȡ����������{@code ArrivalVO}
     * 
     * <p><Strong>�÷������Ƽ�ʹ��</Strong>
     * @param field {@code ArrivalPO}��Ӧ�ı�����
     * @param value {@code ArrivalPO}��Ӧ�ı���ֵ
     * @return ����������{@code ArrivalVO}�б���������ڻ��߲�ѯʧ�ܣ��򷵻ؿ��б�
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

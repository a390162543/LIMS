package businesslogic.loadbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LoadPO;
import po.OrderPO;
import systemenum.DocumentState;
import dataservice.DataService;
import dataservice.LoadDataService;
import dataservice.OrderDataService;
import vo.GoodsVO;
import vo.LoadVO;
import vo.OrderDeliverInfoVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.employeebl.Employee;
import businesslogic.idbl.IdManager;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.organizationbl.Organization;
import businesslogicservice.IdblService;
import businesslogicservice.LoadblService;

/**
 * {@code Load}��װ����ҵ���߼���ʵ���࣬�ṩ�����й�װ������ҵ���߼�����
 * @author ���滪
 * @version 1.4
 * @see dataservice.LoadDataService
 */
public class Load implements LoadblService{
    
    /**
     * һ��װ����ά���Ļ����б�
     */
    private GoodsList goodsList;
    /**
     * {@code Load}�����ݲ��������
     */
    private LoadDataService loadDataService;
    
    public Load(){
        goodsList = new GoodsList();
        loadDataService = DataService.getLoadDataService();
    }
    
    @Override
    public boolean createLoadPO(LoadVO vo) {
        try {
            loadDataService.insert(vo.getLoadPO());
            
            Log logbl = new Log();
            logbl.createLogPO("������װ����"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyLoadPO(LoadVO vo) {
        LoadPO po;
        try {
            po = loadDataService.find(vo.getId());
            po.update(vo);
            loadDataService.update(po);
            
            Log logbl = new Log();
            logbl.createLogPO("�޸���װ����"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    @Override
    public boolean addGoods(GoodsVO vo){
        goodsList.add(vo);
        return true;
    }
    
    @Override
    public boolean deleteGoods(GoodsVO vo){
        goodsList.delete(vo);
        return true;
    }
    
    @Override
    public double getCost(String location1, String location2){
        Organization organization = new Organization();
        double distance = organization.getDistanceByOrganizatioName(location1, location2);
        double weight = goodsList.getWeight();
        double cost = 0.0;
        double rate = 2.0;
        cost = weight * rate * distance / 1000;
        return cost;
    }
    
    @Override
    public GoodsVO getGoodsVO(String id) {
        // TODO Auto-generated method stub  
        try {
            OrderDataService orderDataService = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
            if(orderDataService.find(id) == null)
                return null;
            else{
                OrderPO po = orderDataService.find(id);
                GoodsVO vo = po.getGoodsVO();
                 
                return vo;
            }
            
             
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
        return null;
    }
    
    @Override
    public boolean execute(LoadVO vo) {
        try {
            //����װ������״̬
            LoadPO po = loadDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            loadDataService.update(po);

            //��ȡ�����б�
            List<String> orders = vo.getOrderId();
            
            //��ȡ����ҵ���߼������Ҹ��¶���״̬
            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getLoadingDate())+
                        " �����"+vo.getDepart()+"����";
                OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(orderId, vo.getDestination(), vo.getDestination(), deliverInfo);
                orderbl.modifyDeliverInfo(orderDeliverInfoVO);
            }
            
            //����˾������
            Employee employeebl = new Employee();
            String driverId = vo.getDriverId();
            employeebl.addPay(driverId);
            
            Log logbl = new Log();
            logbl.createLogPO("������װ����"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * ��ȡ���д�������{@code LoadVO}
     * @return {@code Load}���б����û�з���������{@code LoadVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
     */
    public List<LoadVO> getPendingLoadVO(){
        List<LoadPO> pos = null;
        List<LoadVO> vos = new ArrayList<LoadVO>();
        try {
            pos = loadDataService.finds("documentState", DocumentState.PENDING);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(LoadPO po:pos){
            vos.add(po.getLoadVO());
        }
        return vos;
    }
    
    /**
     * ����{@code id}��ʾ��ȡһ��{@code LoadVO}����
     * @param id ��Ҫ���ҵ�{@code id}
     * @return ��Ӧ��{@code LoadVO}���������ʧ�ܻ��߲����ڣ��򷵻�{@code null}
     */
    public LoadVO getLoadVO(String id){
        try {
            LoadPO po = loadDataService.find(id);
            if(po != null)
                return po.getLoadVO();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public IdblService getIdblService() {
        return new IdManager(loadDataService, 6);
    }

}

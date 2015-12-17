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
 * {@code Load}是装车单业务逻辑的实现类，提供所有有关装车单的业务逻辑服务
 * @author 林祖华
 * @version 1.4
 * @see dataservice.LoadDataService
 */
public class Load implements LoadblService{
    
    /**
     * 一次装车所维护的货物列表
     */
    private GoodsList goodsList;
    /**
     * {@code Load}的数据层服务引用
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
            logbl.createLogPO("创建了装车单"+vo.getId());
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
            logbl.createLogPO("修改了装车单"+vo.getId());
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
            //更改装车单的状态
            LoadPO po = loadDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            loadDataService.update(po);

            //获取订单列表
            List<String> orders = vo.getOrderId();
            
            //获取订单业务逻辑，并且更新订单状态
            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getLoadingDate())+
                        " 货物从"+vo.getDepart()+"出发";
                OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(orderId, vo.getDestination(), vo.getDestination(), deliverInfo);
                orderbl.modifyDeliverInfo(orderDeliverInfoVO);
            }
            
            //增加司机工资
            Employee employeebl = new Employee();
            String driverId = vo.getDriverId();
            employeebl.addPay(driverId);
            
            Log logbl = new Log();
            logbl.createLogPO("审批了装车单"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * 获取所有待审批的{@code LoadVO}
     * @return {@code Load}的列表，如果没有符合条件的{@code LoadVO}，或者查询
     * 失败，则返回一个空列表
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
     * 根据{@code id}表示获取一个{@code LoadVO}对象
     * @param id 需要查找的{@code id}
     * @return 对应的{@code LoadVO}，如果查找失败或者不存在，则返回{@code null}
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

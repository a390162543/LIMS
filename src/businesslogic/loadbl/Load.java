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
import dataservice.LoadDataService;
import dataservice.OrderDataService;
import vo.GoodsVO;
import vo.LoadVO;
import vo.OrderDeliverInfoVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.idbl.IdManager;
import businesslogic.orderbl.Order;
import businesslogicservice.IdblService;
import businesslogicservice.LoadblService;

public class Load implements LoadblService{
    
    private GoodsList goodsList;
    private LoadDataService loadDataService;
    
    public Load(){
        goodsList = new GoodsList();
        try {
            loadDataService = (LoadDataService) Naming.lookup("rmi://localhost/LoadData");
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
    public boolean createLoadPO(LoadVO vo) {
        try {
            loadDataService.insert(vo.getLoadPO());
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
        
        return 0;
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
                System.out.println("find orderpo");
                System.out.println(po.getOrderId());
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
            LoadPO po = loadDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            loadDataService.update(po);

            List<String> orders = vo.getOrderId();
            
            Order orderbl = new Order();
            for(String orderId : orders){
                String deliverInfo = BusinessLogicUtil.getTime(vo.getLoadingDate())+
                        " 货物从"+vo.getDepart()+"出发\n";
                OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(orderId, vo.getDestination(), vo.getDestination(), deliverInfo);
                orderbl.modifyDeliverInfo(orderDeliverInfoVO);
                
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

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

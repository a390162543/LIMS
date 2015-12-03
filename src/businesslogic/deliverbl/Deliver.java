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
import vo.EmployeeVO;
import vo.OrderDeliverInfoVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.employeebl.Employee;
import businesslogic.idbl.IdManager;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;
import businesslogicservice.DeliverblService;
import businesslogicservice.IdblService;

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

            Order orderbl = new Order();
            String deliverInfo = BusinessLogicUtil.getTime(vo.getDeliverDate())+
                    " 货物正在由快递员"+vo.getCourierId()+"派件\n";
            OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(vo.getOrderId(), LoginController.getOrganizationName(), "", deliverInfo);
            orderbl.modifyDeliverInfo(orderDeliverInfoVO);
                
            
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

    @Override
    public IdblService getIdblService() {
        return new IdManager(deliverDataService, 6);
    }

    @Override
    public List<EmployeeVO> getAllCouriers() {
        String organization = LoginController.getOrganizationName();
        Employee employee = new Employee();
        return employee.getCourierVO(organization);
    }
    
}

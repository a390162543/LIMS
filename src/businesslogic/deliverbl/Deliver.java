package businesslogic.deliverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DeliverPO;
import systemenum.DocumentState;
import dataservice.DataService;
import dataservice.DeliverDataService;
import vo.DeliverVO;
import vo.EmployeeVO;
import vo.OrderDeliverInfoVO;
import businesslogic.BusinessLogicUtil;
import businesslogic.employeebl.Employee;
import businesslogic.idbl.IdManager;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;
import businesslogicservice.DeliverblService;
import businesslogicservice.IdblService;

/**
 * {@code Deliver}是派件单业务逻辑的实现类，提供所有有关派件单的业务逻辑服务
 * @author 林祖华
 * @version 1.3
 * @see dataservice.DeliverDataService
 */
public class Deliver implements DeliverblService{
    
    /**
     * {@code Deliver}的数据层服务引用
     */
    private DeliverDataService deliverDataService;
    
    public Deliver(){
            deliverDataService = DataService.getDeliverDataService();
    }
    
    @Override
    public boolean createDeliverPO(DeliverVO vo) {
        try {
            deliverDataService.insert(vo.getDeliverPO());
            
            Log logbl = new Log();
            logbl.createLogPO("创建了派件单"+vo.getId());
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
            
            Log logbl = new Log();
            logbl.createLogPO("修改了派件单"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean execute(DeliverVO vo) {
        try {
            //更改派件单的状态
            DeliverPO po = deliverDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            deliverDataService.update(po);


            //由快递员id获取姓名
            Employee employeebl = new Employee();
            EmployeeVO employeeVO = employeebl.find(vo.getCourierId());
            String courier = vo.getCourierId();
            if(employeeVO != null){
                courier = employeeVO.getName()+"("+vo.getCourierId()+")";
            }
            
            //获取订单业务逻辑，并且更新订单状态
            Order orderbl = new Order();
            String deliverInfo = BusinessLogicUtil.getTime(vo.getDeliverDate())+
                    "\n"+"货物正在由快递员"+courier+"派件";
            OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(vo.getOrderId(), LoginController.getOrganizationName(), "", deliverInfo);
            orderbl.modifyDeliverInfo(orderDeliverInfoVO);
                
            Log logbl = new Log();
            logbl.createLogPO("审批了派件单"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获取所有待审批的{@code DeliverVO}
     * @return {@code Deliver}的列表，如果没有符合条件的{@code DeliverVO}，或者查询
     * 失败，则返回一个空列表
     */
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

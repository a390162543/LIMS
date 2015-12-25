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
 * {@code Deliver}���ɼ���ҵ���߼���ʵ���࣬�ṩ�����й��ɼ�����ҵ���߼�����
 * @author ���滪
 * @version 1.3
 * @see dataservice.DeliverDataService
 */
public class Deliver implements DeliverblService{
    
    /**
     * {@code Deliver}�����ݲ��������
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
            logbl.createLogPO("�������ɼ���"+vo.getId());
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
            logbl.createLogPO("�޸����ɼ���"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean execute(DeliverVO vo) {
        try {
            //�����ɼ�����״̬
            DeliverPO po = deliverDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            deliverDataService.update(po);


            //�ɿ��Աid��ȡ����
            Employee employeebl = new Employee();
            EmployeeVO employeeVO = employeebl.find(vo.getCourierId());
            String courier = vo.getCourierId();
            if(employeeVO != null){
                courier = employeeVO.getName()+"("+vo.getCourierId()+")";
            }
            
            //��ȡ����ҵ���߼������Ҹ��¶���״̬
            Order orderbl = new Order();
            String deliverInfo = BusinessLogicUtil.getTime(vo.getDeliverDate())+
                    "\n"+"���������ɿ��Ա"+courier+"�ɼ�";
            OrderDeliverInfoVO orderDeliverInfoVO = new OrderDeliverInfoVO(vo.getOrderId(), LoginController.getOrganizationName(), "", deliverInfo);
            orderbl.modifyDeliverInfo(orderDeliverInfoVO);
                
            Log logbl = new Log();
            logbl.createLogPO("�������ɼ���"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * ��ȡ���д�������{@code DeliverVO}
     * @return {@code Deliver}���б����û�з���������{@code DeliverVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
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

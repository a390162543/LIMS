package businesslogic.revenuebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.OrderPO;
import po.RevenuePO;
import systemenum.DocumentState;
import dataservice.DataService;
import dataservice.OrderDataService;
import dataservice.RevenueDataService;
import vo.EmployeeVO;
import vo.OrderRevenueVO;
import vo.RevenueVO;
import businesslogic.accountbl.Account;
import businesslogic.employeebl.Employee;
import businesslogic.idbl.IdManager;
import businesslogic.logbl.Log;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.RevenueblService;

/**
 * {@code Revenue}���տҵ���߼���ʵ���࣬�ṩ�����й��տ��ҵ���߼�����
 * @author ���滪
 * @version 1.7
 * @see dataservice.RevenueDataService
 */
public class Revenue implements RevenueblService{

    /**
     * {@code Revenue}�����ݲ��������
     */
    private RevenueDataService revenueDataService;
    /**
     * һ���տ���ά���Ķ����б�
     */
    private OrderList orderList;
    
    public Revenue(){
        orderList = new OrderList();
        revenueDataService = DataService.getRevenueDataService();
    }
    
    @Override
    public boolean createRevenuePO(RevenueVO vo) {
        try {
            revenueDataService.insert(vo.getRevenuePO());
            
            Log logbl = new Log();
            logbl.createLogPO("�������տ"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modifyRevenuePO(RevenueVO vo) {
        RevenuePO po;
        try {
            po = revenueDataService.find(vo.getId());
            po.update(vo);
            revenueDataService.update(po);
            
            Log logbl = new Log();
            logbl.createLogPO("�޸����տ"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * �޸Ĳ����ύ�տ
     * @param vo ��Ҫ�޸ĵ�{@code RevenuePO}��Ӧ��{@code RevenueVO}
     * @return �޸ĳɹ�����{@code true}�����򷵻�false
     */
    public boolean modifyAndCommitRevenuePO(RevenueVO vo) {
        RevenuePO po;
        try {
            po = revenueDataService.find(vo.getId());
            po.update(vo);
            po.setDocumentState(DocumentState.PENDING);
            revenueDataService.update(po);
            
            Log logbl = new Log();
            logbl.createLogPO("�ύ���տ"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    

    @Override
    public boolean execute(RevenueVO vo) {
        try {
            //�����տ��״̬
            RevenuePO po = revenueDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            revenueDataService.update(po);
            //ִ���տ���ݣ�������Ӧ���˻����д��
            Account account = new Account();
            account.updateAccountBalance(vo.getAccountId(), vo.getRevenue());
            //���ӿ��Ա����
            Employee employeebl = new Employee();
            String courierId = vo.getCourierId();
            double revenue = vo.getRevenue();
            employeebl.addPay(courierId, revenue);
            
            Log logbl = new Log();
            logbl.createLogPO("�������տ"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public OrderRevenueVO getOrderRevenueVO(String id) {
        // TODO Auto-generated method stub  
        try {
            OrderDataService orderDataService = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
            if(orderDataService.find(id) == null)
                return null;
            else{
                OrderPO po = orderDataService.find(id);
                System.out.println("find orderpo");
                System.out.println(po.getOrderId());
                OrderRevenueVO vo = po.getOrderRevenueVO();
                 
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
    
    /**
     * ��ȡ���д�������{@code RevenueVO}
     * @return {@code Revenue}���б����û�з���������{@code RevenueVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
     */
    public List<RevenueVO> getPendingRevenueVO(){
        List<RevenuePO> pos = null;
        List<RevenueVO> vos = new ArrayList<RevenueVO>();
        try {
            pos = revenueDataService.finds("documentState", DocumentState.PENDING);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(RevenuePO po:pos){
            vos.add(po.getRevenueVO());
        }
        return vos;
    }
    
    /**
     * ��ȡ����δ�ύ��{@code RevenueVO}
     * @return {@code Revenue}���б����û�з���������{@code RevenueVO}�����߲�ѯ
     * ʧ�ܣ��򷵻�һ�����б�
     */
    public List<RevenueVO> getUncommittedRevenueVO(){
        List<RevenuePO> pos = null;
        List<RevenueVO> vos = new ArrayList<RevenueVO>();
        try {
            pos = revenueDataService.finds("documentState", DocumentState.UNCOMMITTED);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(RevenuePO po:pos){
            vos.add(po.getRevenueVO());
        }
        return vos;
    }
    
    /**
     * ���ݸ��������ںͻ����������з���������{@code RevenueVO}
     * @param date ��������
     * @param organization ���һ�����
     * @return ����������{@code RevenueVO}���б��������ʧ�ܻ��߲����ڣ��򷵻�һ�����б�
     */
    public List<RevenueVO> queryRevenueVO(Date date, String organization) {
        List<RevenueVO> vos = new ArrayList<RevenueVO>();
        try {
            revenueDataService  = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
            List<RevenuePO> pos = revenueDataService.finds("date", date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(RevenuePO po : pos){
               if(po.getOrganization().equals(organization)&&sdf.format(po.getRevenueDate()).equals(sdf.format(date))&&po.getDocumentState().equals(DocumentState.PASS))
                    vos.add(po.getRevenueVO());         
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (RemoteException e) {

            e.printStackTrace();
        } catch (NotBoundException e) {

            e.printStackTrace();
        }
        return vos;
        
    }
    
    /**
     * ���ݸ��������ڲ������з���������{@code RevenueVO}
     * @param begindate ��ʼ����
     * @param enddate ��������
     * @return ����������{@code RevenueVO}���б��������ʧ�ܻ��߲����ڣ��򷵻�һ�����б�
     */
    public List<RevenueVO> queryRevenueVO(Date begindate, Date enddate) {
        List<RevenueVO> vos = new ArrayList<RevenueVO>();
        try {
            revenueDataService  = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
            List<RevenuePO> pos = revenueDataService.finds("date", begindate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(RevenuePO po : pos){
                if((po.getRevenueDate().before(enddate)||sdf.format(po.getRevenueDate()).equals(sdf.format(enddate)))&&po.getDocumentState().equals(DocumentState.PASS))
                    vos.add(po.getRevenueVO());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (RemoteException e) {

            e.printStackTrace();
        } catch (NotBoundException e) {
  
            e.printStackTrace();
        }
        return vos;
        
    }

    
    @Override
    public boolean add(OrderRevenueVO vo) {
        orderList.add(vo);
        return true;
    }

    @Override
    public boolean delete(OrderRevenueVO vo) {
        orderList.delete(vo);
        return true;
    }

    @Override
    public double getSum() {
        return orderList.getRevenue();
    }
    
    @Override
    public List<EmployeeVO> getAllCouriers() {
        String organization = LoginController.getOrganizationName();
        Employee employee = new Employee();
        return employee.getCourierVO(organization);
    }
    
    @Override
    public IdblService getIdblService() {
        return new IdManager(revenueDataService, 6);
    }
    
}

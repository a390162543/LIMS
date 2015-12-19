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
 * {@code Revenue}是收款单业务逻辑的实现类，提供所有有关收款单的业务逻辑服务
 * @author 林祖华
 * @version 1.7
 * @see dataservice.RevenueDataService
 */
public class Revenue implements RevenueblService{

    /**
     * {@code Revenue}的数据层服务引用
     */
    private RevenueDataService revenueDataService;
    /**
     * 一次收款所维护的订单列表
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
            logbl.createLogPO("创建了收款单"+vo.getId());
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
            logbl.createLogPO("修改了收款单"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * 修改并且提交收款单
     * @param vo 需要修改的{@code RevenuePO}对应的{@code RevenueVO}
     * @return 修改成功返回{@code true}，否则返回false
     */
    public boolean modifyAndCommitRevenuePO(RevenueVO vo) {
        RevenuePO po;
        try {
            po = revenueDataService.find(vo.getId());
            po.update(vo);
            po.setDocumentState(DocumentState.PENDING);
            revenueDataService.update(po);
            
            Log logbl = new Log();
            logbl.createLogPO("提交了收款单"+vo.getId());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    

    @Override
    public boolean execute(RevenueVO vo) {
        try {
            //更改收款单的状态
            RevenuePO po = revenueDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            revenueDataService.update(po);
            //执行收款单内容，即对相应的账户进行打款
            Account account = new Account();
            account.updateAccountBalance(vo.getAccountId(), vo.getRevenue());
            //增加快递员工资
            Employee employeebl = new Employee();
            String courierId = vo.getCourierId();
            double revenue = vo.getRevenue();
            employeebl.addPay(courierId, revenue);
            
            Log logbl = new Log();
            logbl.createLogPO("审批了收款单"+vo.getId());
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
     * 获取所有待审批的{@code RevenueVO}
     * @return {@code Revenue}的列表，如果没有符合条件的{@code RevenueVO}，或者查询
     * 失败，则返回一个空列表
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
     * 获取所有未提交的{@code RevenueVO}
     * @return {@code Revenue}的列表，如果没有符合条件的{@code RevenueVO}，或者查询
     * 失败，则返回一个空列表
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
     * 根据给定的日期和机构查找所有符合条件的{@code RevenueVO}
     * @param date 查找日期
     * @param organization 查找机构名
     * @return 符合条件的{@code RevenueVO}的列表，如果查找失败或者不存在，则返回一个空列表
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
     * 根据给定的日期查找所有符合条件的{@code RevenueVO}
     * @param begindate 起始日期
     * @param enddate 结束日期
     * @return 符合条件的{@code RevenueVO}的列表，如果查找失败或者不存在，则返回一个空列表
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

package businesslogic.revenuebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.RevenuePO;
import systemenum.DocumentState;
import dataservice.RevenueDataService;
import vo.RevenueVO;
import businesslogic.accountbl.Account;
import businesslogicservice.RevenueblService;

public class Revenue implements RevenueblService{

    private RevenueDataService revenueDataService;
    
    public Revenue(){
        try {
            revenueDataService = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
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
    public boolean createRevenuePO(RevenueVO vo) {
        try {
            revenueDataService.insert(vo.getRevenuePO());
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
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean modifyAndCommitRevenuePO(RevenueVO vo) {
        RevenuePO po;
        try {
            po = revenueDataService.find(vo.getId());
            po.update(vo);
            po.setDocumentState(DocumentState.PENDING);
            revenueDataService.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    

    @Override
    public boolean execute(RevenueVO vo) {
        try {
            RevenuePO po = revenueDataService.find(vo.getId());
            po.setDocumentState(DocumentState.PASS);
            revenueDataService.update(po);
            Account account = new Account();
            account.updateAccountBalance(vo.getAccountId(), vo.getRevenue());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

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
    
}

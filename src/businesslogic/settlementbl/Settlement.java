package businesslogic.settlementbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataservice.RevenueDataService;
import po.RevenuePO;
import vo.RevenueVO;
import businesslogicservice.SettlementblService;

public class Settlement implements SettlementblService{

	@Override
	public List<RevenueVO> queryRevenueVO(Date date, String organization) {
//      List<RevenueVO> vos = new ArrayList<RevenueVO>();
//      try {
//      	RevenueDataService rds = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
//          List<RevenuePO> pos = rds.finds("date", date);
//          for(RevenuePO po : pos){
//          	if(po.get)
//          		vos.add(po.getRevenueVO());
//          }
//      } catch (MalformedURLException e) {
//
//          e.printStackTrace();
//      } catch (RemoteException e) {
//
//          e.printStackTrace();
//      } catch (NotBoundException e) {
//
//          e.printStackTrace();
//      }
//      return vos;
		return null;
	}

	@Override
	public boolean setAccountId(RevenueVO vo ,String accountId) {
//		try {
//			RevenueDataService rds = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
//			vo.setAccountId(accountId);
//			rds.update(vo.getRevenuePO());		
//		} catch (MalformedURLException | RemoteException | NotBoundException e) {
//			e.printStackTrace();
//		}
		
		return true;
	}

}

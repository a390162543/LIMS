package businesslogic.storeoutbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import po.StoreinPO;
import po.StoreoutPO;
import dataservice.OrderDataService;
import dataservice.StoreinDataService;
import dataservice.StoreoutDataService;
import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreoutCheckResultVO;
import vo.StoreoutCreateVO;
import vo.StoreoutQueryVO;
import vo.OutOrderCheckResultVO;
import businesslogic.orderbl.Order;
import businesslogicservice.StoreoutblService;

public class Storeout implements StoreoutblService{

	@Override
	public boolean createStoreoutPO(StoreoutCreateVO vo) {
		try {
			StoreoutDataService storeoutDataService = (StoreoutDataService) Naming.lookup("rmi://localhost/StoreoutData");
			storeoutDataService.insert(vo.getStoreoutPO());
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
		
		return false;
	}

	@Override
	public boolean modifyStoreout(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excute(StoreoutCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo) {
		String field = vo.getFiled();
		Date value = vo.getFromDate();
		Date toDate = vo.getToDate();
		List<OutOrderCheckResultVO> outCheckResultVOs = new ArrayList<OutOrderCheckResultVO>();
		List<StoreoutPO> storeoutPOs = null;
		try {
			StoreoutDataService storeoutDataService = (StoreoutDataService) Naming.lookup("rmi://localhost/StoreoutData");
			storeoutPOs = storeoutDataService.finds(field, value);	
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
		
		for(StoreoutPO po : storeoutPOs) {
			if (po.getDate().compareTo(toDate)<=0) {
				for (int i = 0; i < po.getOrderId().size(); i++) {
					Order order = new Order();
					OutOrderCheckResultVO checkResultVO = order.findStoreout(po.getOrderId().get(i));
					checkResultVO.setDate(po.getDate());
					checkResultVO.setDestination(po.getDestination());
					outCheckResultVOs.add(checkResultVO);
				}
				
			}
		}
		
		return outCheckResultVOs;	
	}
	
	public List<StoreoutQueryVO> getStoreoutQueryVOs(String field, Object value) {
		List<StoreoutQueryVO> storeoutQueryVOs = new ArrayList<StoreoutQueryVO>();
		List<StoreoutPO> storeoutPOs = null;
		try {
			StoreoutDataService storeoutDataService = (StoreoutDataService) Naming.lookup("rmi://localhost/StoreoutData");
			storeoutPOs = storeoutDataService.finds(field, value);	
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
		for (StoreoutPO po : storeoutPOs) {
			storeoutQueryVOs.add(po.getStoreoutQueryVO());
		}
		return storeoutQueryVOs;
		
	}

}

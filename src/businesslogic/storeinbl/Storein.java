package businesslogic.storeinbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.POA;

import po.StoreinPO;
import dataservice.StoreinDataService;
import vo.StoreinCheckResultVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinQueryVO;
import vo.InOrderCheckResultVO;
import businesslogic.orderbl.Order;
import businesslogicservice.StoreinblService;

public class Storein implements StoreinblService{

	@Override
	public boolean createStoreinPO(StoreinCreateVO vo) {
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			storeinDataService.insert(vo.getStoreinPO());
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
		return true;
	}

	@Override
	public boolean modifyStorein(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excute(StoreinCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo) {
		String field = vo.getFiled();
		Date value = vo.getFromDate();
		Date toDate = vo.getToDate();
		List<InOrderCheckResultVO> inCheckResultVOs = new ArrayList<InOrderCheckResultVO>();
		List<StoreinPO> storeinPOs = null;
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			storeinPOs = storeinDataService.finds(field, value);	
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
		for(StoreinPO po : storeinPOs) {
			if (po.getInDate().compareTo(toDate)<=0) {
				for (int i = 0; i < po.getOrderId().size(); i++) {
					Order order = new Order();
					InOrderCheckResultVO checkResultVO = order.findStorein(po.getOrderId().get(i));
					checkResultVO.setDate(po.getInDate());
					checkResultVO.setDestination(po.getDestination());
					inCheckResultVOs.add(checkResultVO);
				}
			}		
	    }	
	return inCheckResultVOs;
	}
	
	public List<StoreinQueryVO> storeinQuery(String field, Object value){
		List<StoreinQueryVO> storeinQueryVOs = new ArrayList<StoreinQueryVO>();
		List<StoreinPO> storeinPOs = null;
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			storeinPOs = storeinDataService.finds(field, value);	
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
		for (StoreinPO po : storeinPOs) {
			storeinQueryVOs.add(po.getStoreinQueryVOs());
		}
		return storeinQueryVOs;
	}
	
}

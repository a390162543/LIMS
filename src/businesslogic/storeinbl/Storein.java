package businesslogic.storeinbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import po.StoreinPO;
import systemenum.DocumentState;
import systemenum.StorageState;
import dataservice.StoreinDataService;
import vo.StorageLocationVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinOrderVO;
import vo.StoreinQueryVO;
import vo.InOrderCheckResultVO;
import businesslogic.orderbl.Order;
import businesslogic.storagebl.Storage;
import businesslogic.storagebl.StorageHelper;
import businesslogicservice.StoreinblService;

public class Storein implements StoreinblService{

	@Override
	public boolean createStoreinPO(StoreinCreateVO vo) {
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			StoreinPO storeinPO = vo.getStoreinPO();
			storeinPO.setDocumentState(DocumentState.PENDING);
			storeinDataService.insert(storeinPO);
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
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			StoreinPO storeinPO = vo.getStoreinPO();
			StoreinPO updatePO = storeinPO.updateModifyInfo(vo);
			updatePO.setDocumentState(DocumentState.PASS);
			storeinDataService.insert(updatePO);
			List<String> orderId = updatePO.getOrderId();
			List<Integer> areaNum = updatePO.getAreaNum();
			List<Integer> rowNum = updatePO.getRowNum();
			List<Integer> frameNum = updatePO.getFrameNum();
			List<Integer> item = updatePO.getItem();	
			Order order = new Order();
			StorageHelper helper = new StorageHelper();
			for (int i = 0; i < areaNum.size(); i++) {
				StoreinOrderVO storeinOrderVO = new StoreinOrderVO(orderId.get(i), areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i));
				order.setStorageState(storeinOrderVO);
			}
			for (int i = 0; i < areaNum.size(); i++) {
				StorageLocationVO storageLocationVO = new StorageLocationVO("0250", areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i), StorageState.ISSTORED);
				helper.changeLocationState(storageLocationVO);
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
		return true;
	}

	@Override
	public boolean execute(StoreinCreateVO vo) {
		
		try {
			StoreinDataService storeinDataService = (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			StoreinPO storeinPO = storeinDataService.find(vo.getId());
			storeinPO.setDocumentState(DocumentState.PASS);
			storeinDataService.update(storeinPO);
			List<String> orderId = storeinPO.getOrderId();
			List<Integer> areaNum = storeinPO.getAreaNum();
			List<Integer> rowNum = storeinPO.getRowNum();
			List<Integer> frameNum = storeinPO.getFrameNum();
			List<Integer> item = storeinPO.getItem();	
			Order order = new Order();
			StorageHelper helper = new StorageHelper();
			for (int i = 0; i < areaNum.size(); i++) {
				StoreinOrderVO storeinOrderVO = new StoreinOrderVO(orderId.get(i), areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i));
				order.setStorageState(storeinOrderVO);
			}
			for (int i = 0; i < areaNum.size(); i++) {
				StorageLocationVO storageLocationVO = new StorageLocationVO("0250", areaNum.get(i), rowNum.get(i), frameNum.get(i), item.get(i), StorageState.ISSTORED);
				helper.changeLocationState(storageLocationVO);
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
		return true;
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
	
	public List<StoreinCreateVO> getStoreinPendingVOs() {
		List<StoreinCreateVO> storeinPendingVOs = new ArrayList<StoreinCreateVO>();
		List<StoreinPO> pendingStoreinPOs = null;
		try {
			StoreinDataService storeinDataService =  (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			pendingStoreinPOs = storeinDataService.finds("documentState", DocumentState.PENDING);
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
		for (StoreinPO po : pendingStoreinPOs) {
			storeinPendingVOs.add(po.getStoreinCreateVO());
		}
		return storeinPendingVOs;
	}

	@Override
	public boolean changeLocationState(StorageLocationVO vo) {
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		return true;
	}

	@Override
	public boolean restoreLocationState(StorageLocationVO vo) {
		StorageHelper helper = new StorageHelper();
		helper.changeLocationState(vo);
		return true;
	}
	
	
	public boolean primeInfoExecute (List<StoreinCreateVO> vos){
		try {
			StoreinDataService storeinDataService =  (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
			for (StoreinCreateVO storeinCreateVO : vos) {
				StoreinPO po = storeinCreateVO.getStoreinPO();
				storeinDataService.insert(po);
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
		
		return true;
	}
	
}

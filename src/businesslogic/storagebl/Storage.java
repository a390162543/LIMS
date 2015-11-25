package businesslogic.storagebl;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoragePO;
import systemenum.StorageState;
import dataservice.StorageDataService;
import vo.StorageCheckVO;
import vo.StorageQueryResultVO;
import vo.StorageSetAreaVO;
import vo.StoreinCheckVo;
import vo.StoreinCreateVO;
import vo.StoreinOrderVO;
import vo.StoreinQueryVO;
import vo.StoreoutCreateVO;
import vo.StoreoutQueryVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogicservice.StorageblService;

public class Storage implements StorageblService{


	public boolean setArea(StorageSetAreaVO vo) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find(vo.getStorageId());
			if (po==null) {
				po = vo.getInitialStoragePO();
			}
			StoragePO updatePo = po.getUpdateStoragePO(vo);
			storageDataService.update(updatePo);
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

	
	public List<StorageCheckVO> storeCheck(Date date) {
		
		
		return null;
	}

	
	public boolean isExceeded() {
		
		return false;
	}


	public boolean gainExcel() {
		
		return false;
	}

	
	public boolean setAlarm(double alarm) {
		
		return false;
	}

	
	public int getTotalStorein(List<StoreinCreateVO> storeinList) {
	
		return 0;
	}

	
	public int getTotalStoreout(List<StoreoutCreateVO> storeoutList) {
		
		return 0;
	}

	
	public List<StoreoutCreateVO> storeoutQuery(Date fromDate, Date toDate) {
		
		return null;
	}

	
	public List<StoreinCreateVO> storeinQuery(Date fromDate, Date toDate) {
		
		return null;
	}


	@Override
	public StorageSetAreaVO getStorageData(String id) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find(id);
			if (po!=null) {
				return po.getStorageSetAreaVO();	
			}
			else {
				return null;
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


	@Override
	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo) {
		Storeout storeout = new Storeout();
		List<OutOrderCheckResultVO> resultVOs = storeout.storeoutCheck(vo);
		for(OutOrderCheckResultVO tempvo : resultVOs){
//			System.out.println(tempvo.getDate());
//			System.out.println(tempvo.getOrderId());
//			System.out.println(tempvo.getItem());
		}
		
		return resultVOs;
	}


	@Override
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo) {
		Storein storein = new Storein();
		
		List<InOrderCheckResultVO> resultVOs = storein.storeinCheck(vo);
		for(InOrderCheckResultVO tempvo : resultVOs){
			
//			System.out.println(tempvo.getDate());
//			System.out.println(tempvo.getOrderId());
//			System.out.println(tempvo.getItem());
//			System.out.println(tempvo.getAreaNum());
//			System.out.println(tempvo.getDestination());
	}

	return resultVOs;
		
	}


	@Override
	public List<StorageQueryResultVO> storageQuery(String field , Object value) {
		Storein storein = new Storein();
		Storeout storeout = new Storeout();
		List<StorageQueryResultVO> storageQueryResultVOs = new ArrayList<StorageQueryResultVO>();
		List<StoreinQueryVO> storeinQueryVOs = storein.storeinQuery(field, value);
		List<StoreoutQueryVO> storeoutQueryVOs = storeout.getStoreoutQueryVOs(field, value);
		List<String> storeoutId = new ArrayList<String>();
		for (StoreoutQueryVO vo : storeoutQueryVOs) {
			storeoutId.addAll(vo.getOrderId());
		}
		for (StoreinQueryVO vo : storeinQueryVOs) {
			for (int i = 0; i < vo.getOrderId().size(); i++) {
				if (!storeoutId.contains(vo.getOrderId().get(i))) {
					StorageQueryResultVO storageQueryResultVO = new StorageQueryResultVO(vo.getOrderId().get(i), vo.getAreaNum().get(i), 
							vo.getRowNum().get(i), vo.getFrameNum().get(i), vo.getItem().get(i), vo.getDate(), vo.getDestination());
					storageQueryResultVOs.add(storageQueryResultVO);
				}
			}
		}
		
		return storageQueryResultVOs;
	}
	
	public boolean changeStorageState (StoreinOrderVO vo) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find("0250");
			StorageHelper helper = po.getStorageHelperData()[vo.getAreaNum()][vo.getRowNum()][vo.getFrameNum()][vo.getItem()];
			helper.setState(StorageState.ISSTORING);
			storageDataService.update(po);
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
	
	public boolean restoreStorageState (StoreinOrderVO vo) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find("0250");
			StorageHelper helper = po.getStorageHelperData()[vo.getAreaNum()][vo.getRowNum()][vo.getFrameNum()][vo.getItem()];
			helper.setState(StorageState.ISAVAILABLE);
			storageDataService.update(po);
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
	
	public boolean setStorageState (StoreinOrderVO vo) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find("0250");
			StorageHelper helper = po.getStorageHelperData()[vo.getAreaNum()][vo.getRowNum()][vo.getFrameNum()][vo.getItem()];
			helper.setState(StorageState.ISSTORED);
			storageDataService.update(po);
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

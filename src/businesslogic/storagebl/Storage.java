package businesslogic.storagebl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import po.StoragePO;
import presentation.storageui.storagequeryui.StorageQueryTableModel;
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
import businesslogic.ExcelExporter;
import businesslogic.orderbl.Order;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogicservice.StorageblService;

public class Storage implements StorageblService{


	public boolean setArea(StorageSetAreaVO vo) {
		try {
			StorageDataService storageDataService = (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
			StoragePO po = storageDataService.find(vo.getStorageId());
			StorageHelper storageHelper = new StorageHelper();
			if (po==null) {
				po = vo.getInitialStoragePO();
				//在库存里添加辅助类，用于TXT的初始化，更新
				storageHelper.initLocationInfo("0250", vo.getAirCapacity(), vo.getCarCapacity(), vo.getTrainCapacity(), vo.getMotorCapacity());
				storageDataService.update(po);
				return true;
			}
		
			
			StoragePO updatePo = po.getUpdateStoragePO(vo);
			storageHelper.changeLocationInfo(po, updatePo);
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


	public boolean gainExcel(JTable storageQueryTable) {
		ExcelExporter excelExporter = new ExcelExporter();
		String path = System.getProperty("user.home")+System.getProperty("file.separator")+"Desktop/"
				+new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString()+" data"+".xls";
		File storageData = new File(path);
		if(!storageData.getParentFile().exists())
            storageData.getParentFile().mkdirs();
        try {
            storageData.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		try {
			excelExporter.export(storageQueryTable, storageData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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
		return resultVOs;
	}


	@Override
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo) {
		
		Storein storein = new Storein();
		List<InOrderCheckResultVO> resultVOs = storein.storeinCheck(vo);
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
	
	
}

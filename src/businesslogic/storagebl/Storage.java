package businesslogic.storagebl;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import po.StoragePO;
import systemenum.Position;
import dataservice.DataService;
import dataservice.StorageDataService;
import vo.LogVO;
import vo.StorageQueryResultVO;
import vo.StorageSetAreaVO;
import vo.StorageVO;
import vo.StoreinCheckVo;
import vo.StoreinQueryVO;
import vo.StoreoutQueryVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import businesslogic.ExcelExporter;
import businesslogic.logbl.Log;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogic.userbl.LoginController;
import businesslogicservice.StorageblService;


/**
 * 实现StorageblService中的方法，并提供与其他模块交互的方法
 * 
 * @author lc
 * @version 1.5
 *
 */
public class Storage implements StorageblService{


	public boolean setArea(StorageSetAreaVO vo) {
		
		StorageDataService storageDataService = DataService.getStorageDataService();

		StoragePO po = null;
		try {
			po = storageDataService.find(vo.getStorageId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StorageHelper storageHelper = new StorageHelper();
		if (po == null) {
			po = vo.getInitialStoragePO();
			// 在库存里添加辅助类，用于TXT的初始化，更新
			storageHelper.initLocationInfo(LoginController.getOrganizationId(),
					vo.getAirCapacity(), vo.getCarCapacity(),
					vo.getTrainCapacity(), vo.getMotorCapacity());
			try {
				storageDataService.update(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String operation = "进行了库存"+"("+vo.getStorageId()+")"+"分区调整";
			LogVO logVO = new LogVO(operation, LoginController.getEmployeeId(), LoginController.getEmployeeName(), Position.STORAGEMANAGER);
			Log log = new Log();
			log.createLogPO(logVO);
			return true;
		}

		StoragePO updatePo = po.getUpdateStoragePO(vo);
		storageHelper.changeLocationInfo(po, updatePo);
		try {
			storageDataService.update(updatePo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}


	public boolean gainExcel(JTable storageQueryTable) {
		ExcelExporter excelExporter = new ExcelExporter();
		String path = System.getProperty("user.home")
				+ System.getProperty("file.separator")
				+ "Desktop/"
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())
						.toString() + " data" + ".xls";
		File storageData = new File(path);
		if (!storageData.getParentFile().exists())
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

	
	


	@Override
	public StorageSetAreaVO getStorageData(String id) {
		
		StorageDataService storageDataService = DataService.getStorageDataService();
		StoragePO po = null;
		try {
			po = storageDataService.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po != null) {
			return po.getStorageSetAreaVO();
		} else {
			return null;
		}
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
	
	
	/**
	 * 增加当前库存中货物的数量
	 * 
	 * @param storageId {@code String}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 */
	public boolean addNowCapacity(String storageId) {
		StorageDataService storageDataService = DataService.getStorageDataService();
		
		StoragePO po = null;
		try {
			po = storageDataService.find(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nowCapacity = po.getNowCapacity();
		nowCapacity++;
		po.setNowCapacity(nowCapacity);
		try {
			storageDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	/**
	 * 减少当前库存中货物的数量
	 * 
	 * @param storageId {@code String}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 */
	public boolean reduceNowCapacity(String storageId){
		StorageDataService storageDataService = DataService.getStorageDataService();
		
		StoragePO po = null;
		try {
			po = storageDataService.find(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nowCapacity = po.getNowCapacity();
		nowCapacity--;
		po.setNowCapacity(nowCapacity);
		try {
			storageDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return true;
	}
	
	
	/**
	 * 获取要查找的库存的相关信息
	 * 
	 * @param storageId {@code String}
	 * @return 成功则返回一个{@code StorageVO}，失败则返回{@code false}
	 */
	public StorageVO getStorageVO (String storageId){
		
		StorageDataService storageDataService = DataService.getStorageDataService();
		StorageVO storageVO = null;
		StoragePO po = null;
		try {
			po = storageDataService.find(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		storageVO = po.getStorageVO();

		return storageVO;
	}
}

package businesslogic.storagebl;


import java.rmi.RemoteException;
import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;
import dataservice.DataService;
import dataservice.StorageLocationDataService;


/**
 * 提供改变和获取库存位置状态的信息的方法
 * 
 * @author lc
 * @version 1.4
 *
 */

public class StorageHelper {
	
	/**
	 * 初始化库存各个位置的状态
	 * 
	 * @param storageId {@code String}
	 * @param airNum {@code int}
	 * @param carNum {@code int}
	 * @param trainNUm {@code int}
	 * @param freeNum {@code int}
	 * @return 成功则返回{@code true}，失败则 返回{@code false}
	 * 
	 */
	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNUm, int freeNum) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		
		try {
			storageLocationDataService.initLocationInfo(storageId, airNum,
					carNum, trainNUm, freeNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * 改变库存中存储位置的状态
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return 成功则返回{@code true}，失败则 返回{@code false}
	 */
	public boolean changeLocationState(StorageLocationVO vo) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		StorageLocationPO po = vo.getStorageLocationPO();
		
		try {
			storageLocationDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * 获取要查找的库存中的位置的状态
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return 返回一个{@code StorageState}
	 */
	public StorageState getLocationState(StorageLocationVO vo) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		StorageState state = null;
		
		try {
			state = storageLocationDataService.getLocationState(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return state;
	}
	
	/**
	 * 进行库存分区调整后改变相应位置的状态
	 * 
	 * @param orginalPO
	 * @param updatePO
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * 
	 */
	public boolean changeLocationInfo(StoragePO orginalPO, StoragePO updatePO) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		
		try {
			storageLocationDataService.changeLocationInfo(orginalPO, updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * 获取当前库存中航空区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxAir(String storageId) {
		
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		int max = 0;
		
		try {
			max = storageLocationDataService.getMaxAir(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return max;
	}
	
	
	/**
	 * 获取当前库存中铁运区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxTrain(String storageId) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		int max = 0;
		
		try {
			max = storageLocationDataService.getMaxTrain(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		return max;
	}
	

	/**
	 * 获取当前库存中汽运区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxCar(String storageId) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		int max = 0;
		
		try {
			max = storageLocationDataService.getMaxCar(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return max;
	}
	
	/**
	 * 获取当前库存中机动区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxFree(String storageId) {
		StorageLocationDataService storageLocationDataService = DataService.getStorageLocationDataService();
		int max = 0;
		
		try {
			max = storageLocationDataService.getMaxFree(storageId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return max;
	}
}

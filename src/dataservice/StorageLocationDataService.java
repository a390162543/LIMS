package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;


/**
 * StorageLocationDataService的职责是负责将业务逻辑层涉及的库存位置状态改变的信息
 * 提交给数据层进行相应的处理
 * 
 * @author lc
 * @version 1.3
 *
 */
public interface StorageLocationDataService extends Remote{

	/**
	 * 
	 * @param po {@code StorageLocationPO}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 * @throws RemoteException
	 */
	public boolean update(StorageLocationPO po) throws RemoteException;
	
	/**
	 * 初始化库存各个位置的状态
	 * 
	 * @param storageId {@code String}
	 * @param airNum {@code int}
	 * @param carNum {@code int}
	 * @param trainNUm {@code int}
	 * @param freeNum {@code int}
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * @throws RemoteException
	 */
	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNUm, int freeNum) throws RemoteException;
	
	/**
	 * 进行库存分区调整后改变相应位置的状态
	 * 
	 * @param orginalPO
	 * @param updatePO
	 * @return 成功返回{@code true}，失败返回{@code false}
	 * @throws RemoteException
	 */
	public boolean changeLocationInfo(StoragePO orginalPO, StoragePO updatePO) throws RemoteException;
	
	/**
	 * 初始化RMI
	 * 
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	
	/**
	 * 结束StorageLocationDataService的使用
	 *  
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

	/**
	 * 获取库存中相应位置的状态
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return 成功返回一个{@code StorageState}，失败返回{@code null}
	 * @throws RemoteException
	 */
	public StorageState getLocationState(StorageLocationVO vo) throws RemoteException;
	
	/**
	 * 获取当前库存中航空区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxAir(String storageId) throws RemoteException;
	
	/**
	 * 获取当前库存中铁运区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxTrain(String storageId) throws RemoteException;
	
	/**
	 * 获取当前库存中汽运区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxCar(String storageId) throws RemoteException;
	
	/**
	 * 获取当前库存中机动区存储货物的最大排
	 * 
	 * @param storageId {@code String}
	 * @return 返回一个{@code int}
	 * @throws RemoteException
	 */
	public int getMaxFree(String storageId) throws RemoteException;
}

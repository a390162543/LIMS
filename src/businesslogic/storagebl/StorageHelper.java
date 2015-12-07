package businesslogic.storagebl;


import java.rmi.RemoteException;
import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;
import dataservice.DataService;
import dataservice.StorageLocationDataService;


/**
 * �ṩ�ı�ͻ�ȡ���λ��״̬����Ϣ�ķ���
 * 
 * @author lc
 * @version 1.4
 *
 */

public class StorageHelper {
	
	/**
	 * ��ʼ��������λ�õ�״̬
	 * 
	 * @param storageId {@code String}
	 * @param airNum {@code int}
	 * @param carNum {@code int}
	 * @param trainNUm {@code int}
	 * @param freeNum {@code int}
	 * @return �ɹ��򷵻�{@code true}��ʧ���� ����{@code false}
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
	 * �ı����д洢λ�õ�״̬
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���� ����{@code false}
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
	 * ��ȡҪ���ҵĿ���е�λ�õ�״̬
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return ����һ��{@code StorageState}
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
	 * ���п�����������ı���Ӧλ�õ�״̬
	 * 
	 * @param orginalPO
	 * @param updatePO
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
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
	 * ��ȡ��ǰ����к������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
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
	 * ��ȡ��ǰ������������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
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
	 * ��ȡ��ǰ������������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
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
	 * ��ȡ��ǰ����л������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
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

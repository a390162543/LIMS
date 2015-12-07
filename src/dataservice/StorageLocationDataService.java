package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;


/**
 * StorageLocationDataService��ְ���Ǹ���ҵ���߼����漰�Ŀ��λ��״̬�ı����Ϣ
 * �ύ�����ݲ������Ӧ�Ĵ���
 * 
 * @author lc
 * @version 1.3
 *
 */
public interface StorageLocationDataService extends Remote{

	/**
	 * 
	 * @param po {@code StorageLocationPO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 * @throws RemoteException
	 */
	public boolean update(StorageLocationPO po) throws RemoteException;
	
	/**
	 * ��ʼ��������λ�õ�״̬
	 * 
	 * @param storageId {@code String}
	 * @param airNum {@code int}
	 * @param carNum {@code int}
	 * @param trainNUm {@code int}
	 * @param freeNum {@code int}
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 * @throws RemoteException
	 */
	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNUm, int freeNum) throws RemoteException;
	
	/**
	 * ���п�����������ı���Ӧλ�õ�״̬
	 * 
	 * @param orginalPO
	 * @param updatePO
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 * @throws RemoteException
	 */
	public boolean changeLocationInfo(StoragePO orginalPO, StoragePO updatePO) throws RemoteException;
	
	/**
	 * ��ʼ��RMI
	 * 
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	
	/**
	 * ����StorageLocationDataService��ʹ��
	 *  
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

	/**
	 * ��ȡ�������Ӧλ�õ�״̬
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return �ɹ�����һ��{@code StorageState}��ʧ�ܷ���{@code null}
	 * @throws RemoteException
	 */
	public StorageState getLocationState(StorageLocationVO vo) throws RemoteException;
	
	/**
	 * ��ȡ��ǰ����к������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
	 * @throws RemoteException
	 */
	public int getMaxAir(String storageId) throws RemoteException;
	
	/**
	 * ��ȡ��ǰ������������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
	 * @throws RemoteException
	 */
	public int getMaxTrain(String storageId) throws RemoteException;
	
	/**
	 * ��ȡ��ǰ������������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
	 * @throws RemoteException
	 */
	public int getMaxCar(String storageId) throws RemoteException;
	
	/**
	 * ��ȡ��ǰ����л������洢����������
	 * 
	 * @param storageId {@code String}
	 * @return ����һ��{@code int}
	 * @throws RemoteException
	 */
	public int getMaxFree(String storageId) throws RemoteException;
}

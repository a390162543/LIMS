package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StoragePO;



/**
 * StorageDataService��ְ���Ǹ���Storageҵ���߼����漰�ĶԱ�������ݵ��޸ġ����ʵĲ�������
 * ��̨�����ݲ㴦��
 * 
 * @author lc
 * @version 1.1
 *
 */
public interface StorageDataService extends Remote {
	
    
	/**
	 * ����һ��StoragePO
	 * 
	 * @param po {@code StoragePO}
	 * @throws RemoteException
	 */
    public void update(StoragePO po) throws RemoteException;
    
    /**
     * ����ID������Ӧ��StoragePO
     * 
     * @param id {@code String}
     * @return �ɹ��򷵻�һ��{@code StoragePO}��ʧ���򷵻�{@code null}
     * @throws RemoteException
     */
    public StoragePO find(String id) throws RemoteException;
    
    /**
     * ��ʼ��RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ��������StorageDataService��ʹ��
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
    

}

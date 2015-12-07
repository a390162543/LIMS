package dataservice;

/**
 * StoreoutDataService��ְ���ǽ��߼�����ڳ��ⵥ�Ĳ����������ݲ������Ӧ�Ĵ���
 * 
 * @author lc
 * @version 1.3
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.StoreoutPO;

public interface StoreoutDataService extends DataIdentifiable,Remote {
	
	/**
	 * ��һ���´�����StoreoutPOд�����ݲ�
	 * 
	 * @param po {@code StoreoutPO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 * @throws RemoteException
	 */
	public boolean insert(StoreoutPO po) throws RemoteException;
      
	/**
	 * ����ҵ���߼��������StoreoutPO
	 * 
	 * @param po {@code StoreoutPO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 * @throws RemoteException
	 */
    public boolean update(StoreoutPO po) throws RemoteException;
    
    /**
     * ����ID������Ӧ�ĳ��ⵥ
     * 
     * @param id {@code String}
     * @return �ɹ��򷵻�һ��{@code StoreoutPO},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public StoreoutPO find(String id) throws RemoteException;
    
    /**
     * �����������ҳ��ⵥ
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return �ɹ��򷵻�һ��{@code List<StoreoutPO>},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public List<StoreoutPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ȡ���еĳ��ⵥ
     * 
     * @return �ɹ��򷵻�һ��{@code List<StoreoutPO>},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public List<StoreoutPO> getAll() throws RemoteException;
    
    /**
     * ��ʼ��RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����StoreoutDataService��ʹ��
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
}

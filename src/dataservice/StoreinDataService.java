package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.StoreinPO;



/**
 * StoreinDataService��ְ���ǽ��߼��������ⵥ�Ĳ����������ݲ������Ӧ�Ĵ���
 * 
 * @author lc
 * @version 1.3
 *
 */
public interface StoreinDataService extends DataIdentifiable,Remote{
	
	/**
	 * ��һ���´�����StoreinPOд�����ݲ�
	 * 
	 * @param po {@code StoreinPO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 * @throws RemoteException
	 */
	public boolean insert(StoreinPO po) throws RemoteException;
    
	/**
	 * ����ҵ���߼��������StoreinPO
	 * 
	 * @param po {@code StoreinPO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 * @throws RemoteException
	 * 
	 */
    public boolean  update(StoreinPO po) throws RemoteException;
    
    /**
     * ����ID������Ӧ����ⵥ
     * 
     * @param id {@code String}
     * @return �ɹ��򷵻�һ��{@code StoreinPO},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public StoreinPO find(String id) throws RemoteException;
    
    /**
     * ��������������ⵥ
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return �ɹ��򷵻�һ��{@code List<StoreinPO>},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public List<StoreinPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ȡ���е���ⵥ
     * 
     * @return �ɹ��򷵻�һ��{@code List<StoreinPO>},ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public List<StoreinPO> getAll() throws RemoteException;
    
    /**
     * ��ʼ��RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����StoreinDataService��ʹ��
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
  
}

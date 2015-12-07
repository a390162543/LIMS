package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrderPO;


/**
 * OrderDataService��ְ���Ǹ���Orderҵ���߼����漰�ĶԱ�������ݵ��޸ġ����ʵĲ�������
 * ��̨�����ݲ㴦��
 * 
 * @author lc
 * @version 1.1
 *
 */
public interface OrderDataService extends DataIdentifiable,Remote{
	
	/**
	 * ����һ��OrderPO
	 * 
	 * @param po {@code OrderPO}
	 * @throws RemoteException
	 */
	public void insert(OrderPO po) throws RemoteException;
    
	/**
	 * ����һ��OrderPO
	 * 
	 * @param po {@code OrderPO}
	 * @throws RemoteException
	 */
    public void update(OrderPO po) throws RemoteException;
    
    /**
     * ���ݶ�����ID������Ӧ��OrderPO
     * 
     * @param id {@code String}
     * @return �ɹ��򷵻�һ��{@code OrderPO}��ʧ���򷵻�null
     * @throws RemoteException
     */
    public OrderPO find(String id) throws RemoteException;
    
    /**
     * ����Ҫ����ҷ���������OrderPO
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return �ɹ��򷵻�һ��{@code List<OrderPO>}��ʧ�ܷ���{@code null}
     * @throws RemoteException
     */
    public List<OrderPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ȡ���е�OrderPO
     * @return �ɹ��򷵻�{@code List<OrderPO>}��ʧ���򷵻�{@code null}
     * @throws RemoteException
     */
    public List<OrderPO> getAll() throws RemoteException;
    
    /**
     * ��ʼ��RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * OrderDataService����ʹ��
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
}

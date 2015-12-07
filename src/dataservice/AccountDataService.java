package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;

/**
 * {@code AccountDataService}���˻������ݲ�����ṩ�˻���{@code insert}��{@code update},
 * {@code delete}��{@code find}��{@code getAll}�ȷ���
 * @author ���¿�
 * @version 1.2
 */
public interface AccountDataService extends Remote{

	/**
	 * �����ݲ����һ��{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void insert(AccountPO po) throws RemoteException;

	/**
	 * �����ݲ�ɾ��һ��{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void delete(AccountPO po) throws RemoteException;
	
	/**
	 * �����ݲ����һ��{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void update(AccountPO po) throws RemoteException;
	
	/**
	 * ����id��ȡ��Ӧ��{@code AccountPO}
	 * @param id {@code String} 
	 * @return {@code AccountPO}
	 * @throws RemoteException
	 */
	public AccountPO find(String id) throws RemoteException;
	
	/**
	 * ��ȡ���е�{@code AccountPO}
	 * @return {@code AccountPO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
	 * @throws RemoteException
	 */
	public List<AccountPO> getAll() throws RemoteException;
	
	/**
	 * �˻����ݲ�ĳ�ʼ��
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * �˻����ݲ�Ľ���
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}

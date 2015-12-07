package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.PrimeInfoPO;
/**
 * {@code PrimeInfoDataService}���ڳ����˵����ݲ�����ṩ�ڳ��˵���{@code insert}
 * {@code getAll}�ȷ���
 * @author ���¿�
 * @version 1.2
 */
public interface PrimeInfoDataService extends Remote{
	/**
	 * �����ݲ����һ��{@code PrimeInfoPO}
	 * @param po {@code PrimeInfoPO}
	 * @throws RemoteException
	 */
	public void insert(PrimeInfoPO po) throws RemoteException;
	
	/**
	 * ��ȡ���е�{@code PrimeInfoPO}
	 * @return {@code PrimeInfoPO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
	 * @throws RemoteException
	 */
	public List<PrimeInfoPO> getAll() throws RemoteException;
	
	/**
	 * �ڳ��˵����ݲ�ĳ�ʼ��
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * �ڳ��˵����ݲ�Ľ���
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}

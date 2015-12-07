package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.LogPO;
/**
 * {@code LogDataService}����Ҫ������¼�����ݲ�����ṩ��Ҫ������¼��{@code insert}��
 * {@code finds}�ȷ���
 * @author ���¿�
 * @version 1.2
 */
public interface LogDataService  extends Remote{
	/**
	 * �����ݲ����һ��{@code LogPO}
	 * @param po {@code LogPO}
	 * @throws RemoteException
	 */
	public void insert(LogPO po) throws RemoteException;
	
	/**
	 * ���ݱ������ͱ���ֵ��ȡ��Ӧ��{@code LogPO}
     * @param field {@code LogPO}��Ӧ�ı�����
     * @param value {@code LogPO}��Ӧ�ı���ֵ
	 * @return {@code LogPO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
	 * @throws RemoteException
	 */
	public List<LogPO> finds(String field, Object value) throws RemoteException;
	
	/**
	 * ��־��¼���ݲ�ĳ�ʼ��
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * ��־��¼���ݲ�Ľ���
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}

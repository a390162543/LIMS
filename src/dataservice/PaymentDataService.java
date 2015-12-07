package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.PaymentPO;
/**
 * {@code PaymentDataService}�Ǹ�������ݲ�����ṩ�����{@code insert}��{@code update}��
 * {@code find},{@code finds}�ȷ���
 * @author ���¿�
 * @version 1.2
 */
public interface PaymentDataService extends DataIdentifiable, Remote{
	/**
	 * �����ݲ����һ��{@code PaymentPO}
	 * @param po {@code PaymentPO}
	 * @throws RemoteException
	 */
	public void insert(PaymentPO po) throws RemoteException;
	
	/**
	 * �����ݲ����һ��{@code PaymentPO}
	 * @param po {@code PaymentPO}
	 * @throws RemoteException
	 */
	public void update(PaymentPO po) throws RemoteException;
	
	/**
	 * ����id��ȡ��Ӧ��{@code PaymentPO}
	 * @param id {@code String} 
	 * @return {@code PaymentPO}
	 * @throws RemoteException
	 */
	public PaymentPO find(String id) throws RemoteException;
	
	/**
	 * ���ݱ������ͱ���ֵ��ȡ��Ӧ��{@code PaymentPO}
     * @param field {@code PaymentPO}��Ӧ�ı�����
     * @param value {@code PaymentPO}��Ӧ�ı���ֵ
	 * @return {@code PaymentPO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
	 * @throws RemoteException
	 */
	public List<PaymentPO> finds(String field, Object value) throws RemoteException;
	
	/**
	 * ������ݲ�ĳ�ʼ��
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * ��������ݲ�Ľ���
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}

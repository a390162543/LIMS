package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliverPO;

/**
 * {@code DeliverDataService}���ɼ��������ݲ�����ṩ{@code DeliverPO}��{@code insert}��
 * {@code update}��{@code find}��{@code finds}�ȷ���
 * @author ���滪
 * @version 1.2
 */
public interface DeliverDataService extends DataIdentifiable,Remote{
    
    /**
     * �����ݲ����һ��{@code DeliverPO}
     * @param po ��Ҫ�����{@code DeliverPO}
     * @throws RemoteException
     */
    public void insert(DeliverPO po) throws RemoteException;
    
    /**
     * �����ݲ����һ��{@code DeliverPO}
     * @param po ��Ҫ���µ�{@code DeliverPO}
     * @throws RemoteException
     */
    public void update(DeliverPO po) throws RemoteException;
    
    /**
     * ��{@code id}��ʶ�����ݲ����һ��{@code DeliverPO}
     * @param id ��Ҫ���ҵ�{@code DeliverPO}��Ӧ��{@code id}��ʶ
     * @return ���ز��ҵ���{@code DeliverPO}���������ʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     * @throws RemoteException
     */
    public DeliverPO find(String id) throws RemoteException;
    
    /**
     * ��{@code field}��{@code value}�����ݲ����{@code DeliverPO}���б�
     * @param field {@code DeliverPO}�ı�����
     * @param value {@code DeliverPO}��Ӧ�ı���ֵ
     * @return ����������{@code DeliverPO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<DeliverPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ʼ��{@code DeliverDataService}�����ݲ����
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����{@code DeliverDataService}�����ݲ����
     * @throws RemoteException
     */
    public void finish() throws RemoteException;
    

}

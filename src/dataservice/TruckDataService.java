package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TruckPO;

/**
 * {@code TruckDataService}�ǳ�����Ϣ�����ݲ�����ṩ{@code TruckPO}��{@code insert}��
 * {@code update}��{@code find}��{@code finds}�ȷ���
 * @author ���滪
 * @version 1.2
 */
public interface TruckDataService extends DataIdentifiable,Remote{
    
    /**
     * �����ݲ����һ��{@code TruckPO}
     * @param po ��Ҫ�����{@code TruckPO}
     * @throws RemoteException
     */
    public void insert(TruckPO po) throws RemoteException;
    
    /**
     * �����ݲ�ɾ��һ��{@code TruckPO}
     * @param po ��Ҫɾ����{@code TruckPO}
     * @throws RemoteException
     */
    public void delete(TruckPO po) throws RemoteException;
    
    /**
     * �����ݲ����һ��{@code TruckPO}
     * @param po ��Ҫ���µ�{@code TruckPO}
     * @throws RemoteException
     */
    public void update(TruckPO po) throws RemoteException;
    
    /**
     * ��{@code id}��ʶ�����ݲ����һ��{@code TruckPO}
     * @param id ��Ҫ���ҵ�{@code TruckPO}��Ӧ��{@code id}��ʶ
     * @return ���ز��ҵ���{@code TruckPO}���������ʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     * @throws RemoteException
     */
    public TruckPO find(String id) throws RemoteException;

    /**
     * ��{@code field}��{@code value}�����ݲ����{@code TruckPO}���б�
     * @param field {@code TruckPO}�ı�����
     * @param value {@code TruckPO}��Ӧ�ı���ֵ
     * @return ����������{@code TruckPO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<TruckPO> finds(String field, Object value) throws RemoteException;

    /**
     * ��ȡ���ݲ�����{@code TruckPO}�ĵ��б�
     * @return {@code TruckPO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<TruckPO> getAll() throws RemoteException;
    
    /**
     * ��ʼ��{@code TruckDataService}�����ݲ����
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����{@code TruckDataService}�����ݲ����
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}

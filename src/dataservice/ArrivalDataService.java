package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

/**
 * {@code ArrivalDataService}�ǵ��ﵥ�����ݲ�����ṩ{@code ArrivalPO}��{@code insert}��
 * {@code update}��{@code find}��{@code finds}�ȷ���
 * @author ���滪
 * @version 1.2
 */
public interface ArrivalDataService extends DataIdentifiable,Remote{
    
    /**
     * �����ݲ����һ��{@code ArrivalPO}
     * @param po ��Ҫ�����{@code ArrivalPO}
     * @throws RemoteException
     */
    public void insert(ArrivalPO po) throws RemoteException;
    
    /**
     * �����ݲ����һ��{@code ArrivalPO}
     * @param po ��Ҫ���µ�{@code ArrivalPO}
     * @throws RemoteException
     */
    public void update(ArrivalPO po) throws RemoteException;
    
    /**
     * ��{@code id}��ʶ�����ݲ����һ��{@code ArrivalPO}
     * @param id ��Ҫ���ҵ�{@code ArrivalPO}��Ӧ��{@code id}��ʶ
     * @return ���ز��ҵ���{@code ArrivalPO}���������ʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     * @throws RemoteException
     */
    public ArrivalPO find(String id) throws RemoteException;
    
    /**
     * ��{@code field}��{@code value}�����ݲ����{@code ArrivalPO}���б�
     * @param field {@code ArrivalPO}�ı�����
     * @param value {@code ArrivalPO}��Ӧ�ı���ֵ
     * @return ����������{@code ArrivalPO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<ArrivalPO> finds(String field, Object value) throws RemoteException;
    

    /**
     * ��ʼ��{@code ArrivalDataService}�����ݲ����
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����{@code ArrivalDataService}�����ݲ����
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}

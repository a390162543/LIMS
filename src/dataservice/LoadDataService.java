package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LoadPO;

/**
 * {@code LoadDataService}��װ���������ݲ�����ṩ{@code LoadPO}��{@code insert}��
 * {@code update}��{@code find}��{@code finds}�ȷ���
 * @author ���滪
 * @version 1.2
 */
public interface LoadDataService extends DataIdentifiable,Remote{
    
    /**
     * �����ݲ����һ��{@code LoadPO}
     * @param po ��Ҫ�����{@code LoadPO}
     * @throws RemoteException
     */
    public void insert(LoadPO po) throws RemoteException;
    
    /**
     * �����ݲ����һ��{@code LoadPO}
     * @param po ��Ҫ���µ�{@code LoadPO}
     * @throws RemoteException
     */
    public void update(LoadPO po) throws RemoteException;
    
    /**
     * ��{@code id}��ʶ�����ݲ����һ��{@code LoadPO}
     * @param id ��Ҫ���ҵ�{@code LoadPO}��Ӧ��{@code id}��ʶ
     * @return ���ز��ҵ���{@code LoadPO}���������ʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     * @throws RemoteException
     */
    public LoadPO find(String id) throws RemoteException;
    
    /**
     * ��{@code field}��{@code value}�����ݲ����{@code LoadPO}���б�
     * @param field {@code LoadPO}�ı�����
     * @param value {@code LoadPO}��Ӧ�ı���ֵ
     * @return ����������{@code LoadPO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<LoadPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ʼ��{@code LoadDataService}�����ݲ����
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����{@code LoadDataService}�����ݲ����
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}

package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.RevenuePO;

/**
 * {@code RevenueDataService}���ɼ��������ݲ�����ṩ{@code RevenuePO}��{@code insert}��
 * {@code update}��{@code find}��{@code finds}�ȷ���
 * @author ���滪
 * @version 1.2
 */
public interface RevenueDataService extends DataIdentifiable,Remote{
    
    /**
     * �����ݲ����һ��{@code RevenuePO}
     * @param po ��Ҫ�����{@code RevenuePO}
     * @throws RemoteException
     */
    public void insert(RevenuePO po) throws RemoteException;
    
    /**
     * �����ݲ����һ��{@code RevenuePO}
     * @param po ��Ҫ���µ�{@code RevenuePO}
     * @throws RemoteException
     */
    public void update(RevenuePO po) throws RemoteException;
    
    /**
     * ��{@code id}��ʶ�����ݲ����һ��{@code RevenuePO}
     * @param id ��Ҫ���ҵ�{@code RevenuePO}��Ӧ��{@code id}��ʶ
     * @return ���ز��ҵ���{@code RevenuePO}���������ʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     * @throws RemoteException
     */
    public RevenuePO find(String id) throws RemoteException;
    
    /**
     * ��{@code field}��{@code value}�����ݲ����{@code RevenuePO}���б�
     * @param field {@code RevenuePO}�ı�����
     * @param value {@code RevenuePO}��Ӧ�ı���ֵ
     * @return ����������{@code RevenuePO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<RevenuePO> finds(String field, Object value) throws RemoteException;
    
    /**
     * ��ȡ���ݲ�����{@code RevenuePO}�ĵ��б�
     * @return {@code RevenuePO}���б��������ʧ�ܻ򲻴��ڣ��򷵻�һ�����б�
     * @throws RemoteException
     */
    public List<RevenuePO> getAll() throws RemoteException;
    
    /**
     * ��ʼ��{@code RevenueDataService}�����ݲ����
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * ����{@code RevenueDataService}�����ݲ����
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 

}

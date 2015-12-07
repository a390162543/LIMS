package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.IdData;

/**
 * {@code DataIdentifiable}�������Ҫ�ṩ{@code IdDataService}�����ݲ����ӿ�
 * 
 * <p>���������ݲ㴴���ĵ��ݡ���������Ա�����������ݲ�ӿڶ���Ҫ�̳д˽ӿ�
 * @author ���滪
 * @version 1.2
 */
public interface DataIdentifiable extends Remote{
    
    /**
     * ��ȡ�������Ӧ��{@code IdDataService}
     * @return {@code IdDataService}
     * @throws RemoteException
     */
    default IdDataService getIdDataService() throws RemoteException {
        return new IdData(this);
    };
    
    /**
     * �ж���Ӧ{@code id}��ʶ�����ݳ־û����������ݲ�洢���Ƿ����
     * @param id ��Ҫ���ҵ�{@code id}��ʶ
     * @return �����򷵻�{@code true}�����򷵻�false
     * @throws RemoteException
     */
    public boolean isAvailable(String id) throws RemoteException;
    
}

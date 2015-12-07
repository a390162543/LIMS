package dataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * {@code IdDataService}�ṩ��ҵ���߼����ȡ�µı������Ҫ�����ݷ���
 * 
 * <p>���������ݲ㴴���ĵ��ݡ���������Ա�����������ݲ����ӿڶ���Ҫ�ṩ��ȡ�ýӿ�ʵ�����
 * ʵ������ķ���
 * 
 * @author ���滪
 * @version 1.1
 */
public interface IdDataService extends Remote,Serializable{
   
    /**
     * ����{@code tag}��ʶ��ȡ���´�����{@code id}
     * @param tag ��Ӧ{@code id}��ǰ׺��ʶ
     * @return ����һ��{@code id}���������ʧ�ܻ򲻴��ڣ��򷵻ؿ��ַ���{@code ""}
     * @throws RemoteException
     */
    public String getId(String tag) throws RemoteException;
    
    /**
     * ����{@code tag}��{@code id}��¼���´�����{@code id}
     * @param tag ��Ӧ{@code id}��ǰ׺��ʶ
     * @param id ��Ҫ��¼��{@code id}
     * @return ���³ɹ��򷵻�{@code true}�����򷵻�false
     * @throws RemoteException
     */
    public boolean updateId(String tag, String id) throws RemoteException;

}

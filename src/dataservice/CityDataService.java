package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
 
/**
 * {@code CityDataService}�ǳ��е����ݲ����
 * @author ������
 * @version 1.2
 */
public interface CityDataService extends Remote{
	/**
	 * ������������һ��{@code CityPO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(CityPO po) throws RemoteException;
	 
	 /**
	  * ��������ɾ��һ��{@code CityPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(CityPO po) throws RemoteException;
	 
	 /**
	  *  ����������һ��{@code CityPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(CityPO po) throws RemoteException;	 
	 
	 /**
	  * ����{@code CityPO}Ψһ��ʶ{@code id}����һ��{@code CityPO}����
	  * @param id�� ����id
	  * @return {@code CityPO}����
	  * @throws RemoteException
	  */
	 public CityPO find(String id) throws RemoteException;
	 
	 /**
	  * ��ȡ����{@code CityPO}�б�
	  * @return {@code List<CityPO>}
	  * @throws RemoteException
	  */
	 public List<CityPO> getAll()throws RemoteException;
	 
	 /**
	  *    
	  * @throws RemoteException
	  */
	 public void finish() throws RemoteException; 
	 
	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	 
	 /**
	  * ͨ��{@code CityPO}Ψһ��ʶ{@code name}����{@code CityPO}����
	  * @param name����������
	  * @return ������д��ڣ�����{@code CityPO}����,���򷵻�null
	  * @throws RemoteException
	  */
	 public CityPO findByName(String name) throws RemoteException;
	 
	 /**
	  * ͨ��{@code CityPO}Ψһ��ʶ{@code name}�����{@code id}
	  * @param name����������
	  * @return ������д��ڣ�����{@code id},���򷵻�null
	  * @throws RemoteException
	  */
	 public String getId(String name) throws RemoteException;
}

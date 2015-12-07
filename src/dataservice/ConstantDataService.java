package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.ConstantPO;

/**
 * {@code ConstantDataService}�Ǽ۸�����ݲ����
 * @author ������
 * @version 1.2
 */
public interface ConstantDataService extends Remote{
	/**
	 * ������������һ��{@code ConstantO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(ConstantPO po) throws RemoteException;
	 
	 /**
	  * ��������ɾ��һ��{@code ConstantPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(ConstantPO po) throws RemoteException;
	   
	 /**
	  *  ����������һ��{@code ConstantPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(ConstantPO po) throws RemoteException;	 
	   
	 /**
	  * ��ȡ{@code ConstantPO}����
	  * @return {@code ConstantPO}����
	  * @throws RemoteException
	  */
	 public ConstantPO getConstantPO() throws RemoteException;
	        
	 public void finish() throws RemoteException; 
	 
	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;

}

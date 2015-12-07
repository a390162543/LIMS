package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.IdData;

/**
 * {@code DataIdentifiable}标记了需要提供{@code IdDataService}的数据层服务接口
 * 
 * <p>所有在数据层创建的单据、机构、人员、车辆的数据层接口都需要继承此接口
 * @author 林祖华
 * @version 1.2
 */
public interface DataIdentifiable extends Remote{
    
    /**
     * 获取与自身对应的{@code IdDataService}
     * @return {@code IdDataService}
     * @throws RemoteException
     */
    default IdDataService getIdDataService() throws RemoteException {
        return new IdData(this);
    };
    
    /**
     * 判断相应{@code id}标识的数据持久化对象在数据层存储区是否存在
     * @param id 需要查找的{@code id}标识
     * @return 存在则返回{@code true}，否则返回false
     * @throws RemoteException
     */
    public boolean isAvailable(String id) throws RemoteException;
    
}

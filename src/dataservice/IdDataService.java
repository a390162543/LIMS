package dataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * {@code IdDataService}提供给业务逻辑层获取新的编号所需要的数据服务
 * 
 * <p>所有在数据层创建的单据、机构、人员、车辆的数据层服务接口都需要提供获取该接口实现类的
 * 实例对象的方法
 * 
 * @author 林祖华
 * @version 1.1
 */
public interface IdDataService extends Remote,Serializable{
   
    /**
     * 根据{@code tag}标识获取最新创建的{@code id}
     * @param tag 对应{@code id}的前缀标识
     * @return 返回一个{@code id}，如果查找失败或不存在，则返回空字符串{@code ""}
     * @throws RemoteException
     */
    public String getId(String tag) throws RemoteException;
    
    /**
     * 根据{@code tag}与{@code id}记录最新创建的{@code id}
     * @param tag 对应{@code id}的前缀标识
     * @param id 需要记录的{@code id}
     * @return 更新成功则返回{@code true}，否则返回false
     * @throws RemoteException
     */
    public boolean updateId(String tag, String id) throws RemoteException;

}

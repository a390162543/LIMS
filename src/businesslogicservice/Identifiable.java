package businesslogicservice;

/**
 * {@code Identifiable}标记了需要提供{@code IdblService}的业务逻辑接口
 * 
 * <p>所有在界面层创建的单据、机构、人员、车辆的业务逻辑接口都需要继承此接口
 * @author 林祖华
 * @version 1.0
 */
public interface Identifiable {
    
    /**
     * 获取业务逻辑模块对应的{@code IdblService}
     * @return 
     */
    public IdblService getIdblService();
    
}

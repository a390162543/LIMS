package businesslogicservice;

/**
 * {@code IdblService}提供给界面层获取新的编号的方法
 * 
 * <p>所有在界面层创建的单据、机构、人员、车辆的业务逻辑接口都需要提供获取该接口实现类的
 * 实例对象的方法
 * 
 * @author 林祖华
 * @version 1.1
 */
public interface IdblService {
    
    /**
     * 获取一个新的{@code id}
     * 
     * @return 新建的{@code id}
     */
    public String createNewId();
    
    /**
     * 根据传来的{@code tag}获取一个新的{@code id}
     * @param tag  标记字符串，一般为{@code id}生成规则的前端自定义序列
     * @return  新建的{@code id}
     */
    public String createNewId(String tag);
    
}

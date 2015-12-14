package businesslogicservice;

import java.util.List;
import java.util.Date;

import vo.LogVO;

/**
 * {@code LogblService}提供给界面层主要操作记录处理的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
public interface LogblService {
    /**
     * 创建并记录日志信息
     * @param vo 界面层传来的{@code LogVO}
     * @return 成功创建则返回{@code true}，否则返回{@code false}
     */
	public boolean createLogPO (String operation);
	
    /**
     * 根据日期查询获取相应的日志信息
     * @param date 界面层传来的{@code Date}
     * @return {@code LogVO}的列表，如果没有日志信息或获取失败，则返回空列表
     */
	public List<LogVO>  queryLogVO (Date date);
	
    /**
     * 获取单一日志对象的具体信息
     * @param vo 界面层传来的{@code LogVO}
     * @return {@code String}，如果没有账户信息或获取失败，则返回空字符串
     */
	public String getLogInfo(LogVO vo);
}

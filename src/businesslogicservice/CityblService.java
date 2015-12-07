package businesslogicservice;

import java.util.List;

import vo.CityVO;
/**
 * {@code CitybiService}提供给城市相关界面处理的业务逻辑服务
 * @author 刘航伸
 *@version 1.4
 */
public interface CityblService {
	  /**
     * 创建并记录城市信息
     * 
     * @param vo 界面层传递来的{@code CityVO}
     * @return  成功创建返回{@code true}，否则返回{@code false}
     */
	public boolean createCityPO(CityVO vo);
	
	  /**
     * 删除到达单信息
     * 
     * @param vo 界面层传递来的{@code CItyVO}
     * @return  成功删除返回{@code true}，否则返回{@code false}
     */
	public boolean deleteCityPO(CityVO vo);
	
	  /**
     * 修改到达单信息
     * 
     * @param vo 界面层传递来的{@code CityVO}
     * @return  成功修改返回{@code true}，否则返回{@code false}
     */
	public boolean modifyCityPO(CityVO vo);
		 
    /**
     * 根据{@code id}获取一个{@code CityVO}对象
     * 
     * @param id {@code CityVO}的{@code id}标识
     * @return 返回一个{@code CityVO}对象，如果查询失败或不存在，则返回{@code null}
     */
	public CityVO getCity(String id);
	
	 
    /**
     * 获取所有City信息
    
     * @return 返回一个{@code List<CityVO>}对象，如果为空，则返回{@code null}
     */
	public List<CityVO> getAll();
	
	 
	 /**
     * 获取所有城市名称
    
     * @return 返回一个{@code List<String>}对象，如果为空，则返回{@code null}
     */	public List<String> getAllName();
	
     
}

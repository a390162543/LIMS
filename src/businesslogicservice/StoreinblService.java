package businesslogicservice;


import vo.StorageLocationVO;
import vo.StoreinCreateVO;



/**
 * StoreinblService的职责是负责将和货物入库相关的操作，包括创建入库单、修改入库单、入库单的执行、
 * 入库过程中库存位置状态的变化交给业务逻辑处理
 * 
 * @author lc
 * @version 1.3
 */
public interface StoreinblService extends Identifiable {
	
	/**
	 * 创建入库单
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return 成功返回{@code true}   失败返回{@code false}
	 */
	public boolean createStoreinPO (StoreinCreateVO vo);
	
	/**
	 * 修改入库单
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return 成功返回{@code true},失败返回{@code false}
	 */
	public boolean modifyStorein (StoreinCreateVO vo);
	
	/**
	 * 入库单执行
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return 成功返回{@code true},失败返回{@code false}
	 */
	public boolean execute (StoreinCreateVO vo);
	
	/**
	 * 入库单确认添加一项货物时，改变相应的库存的位置的状态,该位置将不能再放置货物
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return 成功返回{@code true}, 失败返回{@code false}
	 */
	public boolean changeLocationState (StorageLocationVO vo);
	
	
	/**
	 * 入库单在创建时取消后，将原来被占用的库存中的位置设置为可用
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return 成功返回{@code true}, 失败返回{@code false}
	 */
	public boolean restoreLocationState (StorageLocationVO vo);
	
	
}

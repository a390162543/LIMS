package businesslogicservice;

import java.util.List;

import vo.StoreoutCreateVO;



/**
 * StoreoutblService的职责是负责将和货物出库相关的操作，包括创建出库单、修改出库单、出库单的执行、
 * 出库过程中库存位置状态的变化交给业务逻辑处理
 * 
 * @author lc
 * @version 1.2
 */
public interface StoreoutblService extends Identifiable{

	/**
	 * 创建出库单
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return 成功返回{@code true}   失败返回{@code false}
	 */
	public boolean createStoreoutPO (StoreoutCreateVO vo);
	
	/**
	 * 修改出库单
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return 成功返回{@code true},失败返回{@code false}
	 */
	public boolean modifyStoreout (StoreoutCreateVO vo);
	
	/**
	 * 出库单执行
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return 成功返回{@code true},失败返回{@code false}
	 */
	public boolean execute (StoreoutCreateVO vo);
	
	/**
	 * 出库单确认添加一项货物时，改变相应的库存的位置的状态,将该位置设置成可用
	 * 
	 * @param orderId {@code String}
	 * @return 成功返回{@code true}, 失败返回{@code false}
	 */
	public boolean changeLocationState (String orderId);

	/**
	 * 出库单在创建时取消后，将未出库的货物在库存的位置设置成不可用
	 * 
	 * @param orderId {@code String}
	 * @return 成功返回{@code true}, 失败返回{@code false}
	 */
	public boolean restoreLcationState (String orderId);
	
	public  List<String> getTransferVO (String transferId);
	
	public List<String> getLoadVO (String loadId);
}

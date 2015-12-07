package businesslogicservice;


import java.util.List;

import javax.swing.JTable;

import vo.StorageQueryResultVO;
import vo.StorageSetAreaVO;
import vo.StoreinCheckVo;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;

/**
 * StorageblService 的职责是负责与库存相关的操作，包括库存分区调整、设置警戒值，库存盘点、库存查看、导出excel表格界面发来的
 * 请求转发给后台逻辑处理
 * 
 * @author lc
 * @version 1.2
 *
 */
public interface StorageblService {
	
	/**
	 * 调整库存各个区的大小以及设置警戒值
	 * 
	 * @param vo {@code StorageSetAreaVO}
	 * @return 成功返回{@code true}， 失败返回{@code false}
	 */
	public boolean setArea(StorageSetAreaVO vo);
	
	/**
	 * 将库存盘点返回的数据导出excel表格	
	 * 
	 * @param table {@code JTable}
	 * @return 成功返回{@code true}， 失败返回{@code false}
	 */
	public boolean gainExcel(JTable table);
	
	/**
	 * 查看一段时间内入库货物的情况
	 * 
	 * @param vo {@code StoreinCheckVo}
	 * @return 返回一个 {@code List<OutOrderCheckResultVO>}
	 */
	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo);
	
	/**
	 * 查看一段时间内出库货物的情况
	 * 
	 * @param vo {@code StoreinCheckVo}
	 * @return 返回一个 {@code List<InOrderCheckResultVO>}
	 */
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo);
	
	/**
	 * 盘点当前库存里各区货物的情况
	 * 
	 * @param field {@code String}
	 * @param value {@code String}
	 * @return 返回一个 {@code List<StorageQueryResultVO>}
	 */
	public List<StorageQueryResultVO> storageQuery(String field,Object value);

	/**
	 * 用于查看当前库存各个区的大小
	 * 
	 * @param id {@code String}
	 * @return 返回一个{@code StorageSetAreaVO}
	 */
	public StorageSetAreaVO getStorageData(String id);
}

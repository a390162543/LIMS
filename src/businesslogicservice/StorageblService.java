package businesslogicservice;


import java.util.List;

import javax.swing.JTable;

import vo.StorageQueryResultVO;
import vo.StorageSetAreaVO;
import vo.StoreinCheckVo;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;

/**
 * StorageblService ��ְ���Ǹ���������صĲ������������������������þ���ֵ������̵㡢���鿴������excel�����淢����
 * ����ת������̨�߼�����
 * 
 * @author lc
 * @version 1.2
 *
 */
public interface StorageblService {
	
	/**
	 * �������������Ĵ�С�Լ����þ���ֵ
	 * 
	 * @param vo {@code StorageSetAreaVO}
	 * @return �ɹ�����{@code true}�� ʧ�ܷ���{@code false}
	 */
	public boolean setArea(StorageSetAreaVO vo);
	
	/**
	 * ������̵㷵�ص����ݵ���excel���	
	 * 
	 * @param table {@code JTable}
	 * @return �ɹ�����{@code true}�� ʧ�ܷ���{@code false}
	 */
	public boolean gainExcel(JTable table);
	
	/**
	 * �鿴һ��ʱ��������������
	 * 
	 * @param vo {@code StoreinCheckVo}
	 * @return ����һ�� {@code List<OutOrderCheckResultVO>}
	 */
	public List<OutOrderCheckResultVO> storeoutCheck(StoreinCheckVo vo);
	
	/**
	 * �鿴һ��ʱ���ڳ����������
	 * 
	 * @param vo {@code StoreinCheckVo}
	 * @return ����һ�� {@code List<InOrderCheckResultVO>}
	 */
	public List<InOrderCheckResultVO> storeinCheck(StoreinCheckVo vo);
	
	/**
	 * �̵㵱ǰ����������������
	 * 
	 * @param field {@code String}
	 * @param value {@code String}
	 * @return ����һ�� {@code List<StorageQueryResultVO>}
	 */
	public List<StorageQueryResultVO> storageQuery(String field,Object value);

	/**
	 * ���ڲ鿴��ǰ���������Ĵ�С
	 * 
	 * @param id {@code String}
	 * @return ����һ��{@code StorageSetAreaVO}
	 */
	public StorageSetAreaVO getStorageData(String id);
}

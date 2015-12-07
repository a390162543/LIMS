package businesslogicservice;

import java.util.List;

import vo.CityVO;
/**
 * {@code CitybiService}�ṩ��������ؽ��洦���ҵ���߼�����
 * @author ������
 *@version 1.4
 */
public interface CityblService {
	  /**
     * ��������¼������Ϣ
     * 
     * @param vo ����㴫������{@code CityVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
	public boolean createCityPO(CityVO vo);
	
	  /**
     * ɾ�����ﵥ��Ϣ
     * 
     * @param vo ����㴫������{@code CItyVO}
     * @return  �ɹ�ɾ������{@code true}�����򷵻�{@code false}
     */
	public boolean deleteCityPO(CityVO vo);
	
	  /**
     * �޸ĵ��ﵥ��Ϣ
     * 
     * @param vo ����㴫������{@code CityVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
	public boolean modifyCityPO(CityVO vo);
		 
    /**
     * ����{@code id}��ȡһ��{@code CityVO}����
     * 
     * @param id {@code CityVO}��{@code id}��ʶ
     * @return ����һ��{@code CityVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public CityVO getCity(String id);
	
	 
    /**
     * ��ȡ����City��Ϣ
    
     * @return ����һ��{@code List<CityVO>}�������Ϊ�գ��򷵻�{@code null}
     */
	public List<CityVO> getAll();
	
	 
	 /**
     * ��ȡ���г�������
    
     * @return ����һ��{@code List<String>}�������Ϊ�գ��򷵻�{@code null}
     */	public List<String> getAllName();
	
     
}

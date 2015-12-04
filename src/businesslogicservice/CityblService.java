package businesslogicservice;

import java.util.List;

import vo.CityVO;

public interface CityblService {
	public boolean createCityPO(CityVO vo);
	
	public boolean deleteCityPO(CityVO vo);
	
	public boolean modifyCityPO(CityVO vo);
	
	public CityVO getCity(String id);
	
	public List<CityVO> getAll();
	
	public List<String> getAllName();
	
	public String getId(String name);
}

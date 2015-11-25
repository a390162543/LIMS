package businesslogicservice_stub;


import vo.StoreinCreateVO;
import vo.StoreinOrderVO;
import businesslogicservice.StoreinblService;

public class StoreinblService_Stub implements StoreinblService {
	
	
	@Override
	public boolean createStoreinPO(StoreinCreateVO vo) {
		return true;
	}

	@Override
	public boolean execute(StoreinCreateVO vo) {
		return true;
	}

	@Override
	public boolean modifyStorein(StoreinCreateVO vo) {
		return true;
	}

	@Override
	public boolean changeLocationState(StoreinOrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean restoreLocationState(StoreinOrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}

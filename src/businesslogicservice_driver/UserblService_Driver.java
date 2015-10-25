package businesslogicservice_driver;

import businesslogicservice.UserblService;
import systemenum.Power;
import vo.UserVO;

public class UserblService_Driver {
	public void drive(UserblService userblservice){
	UserVO vo = new UserVO(new Long("1008356612"), "hzy", Power.COURIER);
	
	userblservice.creatUserPO(vo);
	userblservice.deleteUserPO(vo);
	userblservice.initialize(vo);
	userblservice.modifyPower(vo);
	userblservice.queryUserPO(vo);
	userblservice.getUserPO();
	
	}
}	

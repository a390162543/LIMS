package businesslogicservice_driver;

import vo.ConstantVO;
import businesslogicservice.ConstantblService;

public class ConstantblService_Driver {
	public void driver(ConstantblService constantblservice){ 
		ConstantVO vo = new ConstantVO();
		constantblservice.getDistance(vo);
		constantblservice.getPrice();
		constantblservice.priceModify(2.21);
		constantblservice.distanceModify(vo);
	}

}

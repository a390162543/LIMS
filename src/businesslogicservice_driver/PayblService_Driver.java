package businesslogicservice_driver;

import java.util.Date;

import po.EmployeePO;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import businesslogicservice.PayblService;

public class PayblService_Driver {
	public void drive(PayblService payblservice){
		EmployeePO po = new EmployeePO(new Long("025001001"), "Ahri", 
				"南京市栖霞区中转中心",Position.MANAGER, new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE);
		
		payblservice.addPayByCount();
		payblservice.addSalesCommission(20);
		payblservice.getMonthlyPay(po);
	}
}

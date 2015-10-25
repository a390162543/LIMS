package businesslogicservice_driver;

import po.EmployeePO;
import systemenum.Position;
import vo.EmployeeVO;
import businesslogicservice.PayblService;

public class PayblService_Driver {
	public void drive(PayblService payblservice){
		EmployeePO po = new EmployeePO(new Long("025001001"), "Ahri", 
				"�Ͼ�����ϼ����ת����",Position.MANAGER);
		
		payblservice.addPayByCount();
		payblservice.addSalesCommission(20);
		payblservice.getMonthlyPay(po);
	}
}

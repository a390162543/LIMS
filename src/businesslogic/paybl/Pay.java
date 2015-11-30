package businesslogic.paybl;

 
 
import vo.PayVO;
import businesslogicservice.PayblService;

public class Pay implements PayblService{

	@Override
	public int addPayByCount(PayVO vo) {
		// TODO Auto-generated method stub
		 
		return vo.getCount() + 1;
	}

	@Override
	public double addSalesCommission(double account, PayVO vo) {
		// TODO Auto-generated method stub
		double d = account * vo.getRate();
		return d;
	}

	@Override
	public double getMonthlyPay(PayVO vo) {
		// TODO Auto-generated method stub
		double sum = vo.getBasePay() + vo.getCount()*vo.getPayByCount() + vo.getSalesCommission()*vo.getRate();
		return sum;
	}

	 
}

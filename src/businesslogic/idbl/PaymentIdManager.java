package businesslogic.idbl;

import businesslogic.userbl.LoginController;
import dataservice.DataIdentifiable;
/**
 * {@code PaymentIdManager}是{@code IdManager}的子类，提供所有有关付款单编号的业务逻辑服务
 * @author 刘德宽
 *
 */
public class PaymentIdManager extends IdManager{

	/**
	 * PaymentIdManager的构造函数
	 * @param dataService {@code DataIdentifiable}
	 * @param ordinalLength {@code int}
	 */
	public PaymentIdManager(DataIdentifiable dataService, int ordinalLength) {
		super(dataService, ordinalLength);
		// TODO Auto-generated constructor stub
	}

    @Override
    /**
     * 父类 {@code createNewId}的重载
     */
    public String createNewId() {
        String tag = LoginController.getEmployeeId();
        return createNewId(tag);
    }
}

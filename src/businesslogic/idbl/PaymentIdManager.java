package businesslogic.idbl;

import businesslogic.userbl.LoginController;
import dataservice.DataIdentifiable;
/**
 * {@code PaymentIdManager}��{@code IdManager}�����࣬�ṩ�����йظ����ŵ�ҵ���߼�����
 * @author ���¿�
 *
 */
public class PaymentIdManager extends IdManager{

	/**
	 * PaymentIdManager�Ĺ��캯��
	 * @param dataService {@code DataIdentifiable}
	 * @param ordinalLength {@code int}
	 */
	public PaymentIdManager(DataIdentifiable dataService, int ordinalLength) {
		super(dataService, ordinalLength);
		// TODO Auto-generated constructor stub
	}

    @Override
    /**
     * ���� {@code createNewId}������
     */
    public String createNewId() {
        String tag = LoginController.getEmployeeId();
        return createNewId(tag);
    }
}

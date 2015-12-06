package businesslogic.idbl;

import businesslogic.userbl.LoginController;
import dataservice.DataIdentifiable;

public class PaymentIdManager extends IdManager{

	public PaymentIdManager(DataIdentifiable dataService, int ordinalLength) {
		super(dataService, ordinalLength);
		// TODO Auto-generated constructor stub
	}

    @Override
    public String createNewId() {
        String tag = LoginController.getEmployeeId();
        return createNewId(tag);
    }
}

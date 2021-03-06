package vo;

import java.util.Date;
import java.util.List;
import po.TransferPO;
import systemenum.ShipForm;

/**
 * {@code TransferPO}是中转单业务逻辑层与界面层之间传递的对象，
 * 记录了中转单的所有信息
 * @author 刘航伸
 * @see systemenum.DocumentState
 * @see systemenum.ShipForm shipForm
 */
public class TransferVO {
	public ShipForm getShipForm() {
		return shipForm;
	}

	public void setShipForm(ShipForm shipForm) {
		this.shipForm = shipForm;
	}

	private String id;
	private Date date;
	private  String flightNum;
	private  String depart;
	private  String destination;
	private  String containerId;
	private  String loadMan;
	private  List<String> orderId;
	private double expenses;
	private ShipForm shipForm;
	  
	public TransferVO(String id, Date loadDate, String flightNum, String depart,
			String destination, String containerId, String loadMan,
			List<String> orderId, double expenses, ShipForm shipForm) {
		super();
		this.id = id;
		this.date = loadDate;
		this.flightNum = flightNum;
		this.depart = depart;
		this.destination = destination;
		this.containerId = containerId;
		this.loadMan = loadMan;
		this.orderId = orderId;
		this.expenses = expenses;
		this.shipForm = shipForm;
	}
	
	public TransferPO getTransferPO(){
		return new TransferPO(id, date, flightNum, 
				depart, destination, containerId, loadMan, orderId, expenses,shipForm);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLoadDate() {
		return date;
	}

	public void setLoadDate(Date loadDate) {
		this.date = loadDate;
	}

	public String getFlightNumbe() {
		return flightNum;
	}

	public void setFlightNumbe(String flightNumbe) {
		this.flightNum = flightNumbe;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getLoadMan() {
		return loadMan;
	}

	public void setLoadMan(String loadMan) {
		this.loadMan = loadMan;
	}

	public List<String> getOrderId() {
		return orderId;
	}

	public void setOrderId(List<String> orderId) {
		this.orderId = orderId;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	  
	  

}

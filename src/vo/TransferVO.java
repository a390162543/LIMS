package vo;

import java.util.Date;
import java.util.List;

import po.TransferPO;

public class TransferVO {
	private String id;
	private Date date;
	private  String flightNum;
	private  String depart;
	private  String destination;
	private  String containerId;
	private  String loadMan;
	private  List<String> orderId;
	private double expenses;
	  
	public TransferVO(String id, Date loadDate, String flightNum, String depart,
			String destination, String containerId, String loadMan,
			List<String> orderId, double expenses) {
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
	}
	
	public TransferPO getTransferPO(){
		return new TransferPO(id, date, flightNum, 
				depart, destination, containerId, loadMan, orderId, expenses);
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

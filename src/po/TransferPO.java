package po;

import java.util.Date;
import java.util.List;

import systemenum.DocumentState;

public class TransferPO {
	private long id;
	private Date loadDate;
	private long flightNumbe;
	private String depart;
	private String destination;
	private long containerId;
	private String loadMan;
	private List<Long> orderId;
	private double expenses;
	private DocumentState documentState;

	public TransferPO(long id, Date date, long flightNum, String depart,
			String destination, long containerId, String loadMan, List<Long> orderId, 
			double expenses ){
		this.id = id;
		this.loadDate = date;
		this.flightNumbe = flightNum;
		this.depart = depart;
		this.destination = destination;
		this.containerId = containerId;
		this.loadMan = loadMan;
		this.orderId = orderId;
		this.expenses = expenses;
	 
	}

	
	public DocumentState getDocumentState() {
		return documentState;
	}


	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}


	public long getId() {
		return id;
	}

	public Date getLoadDate() {
		return loadDate;
	}
	
	public long getFlightNumbe() {
		return flightNumbe;
	}

	public String getDepart() {
		return depart;
	}

	public String getDestination() {
		return destination;
	}

	public long getContainerId() {
		return containerId;
	}

	public String getLoadMan() {
		return loadMan;
	}

	public List<Long> getOrderId() {
		return orderId;
	}

	public double getExpenses() {
		return expenses;
	}


	public void setDepart(String depart) {
		this.depart = depart;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public void setLoadMan(String loadMan) {
		this.loadMan = loadMan;
	}
	
	
} 

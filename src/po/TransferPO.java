package po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import vo.TransferVO;

public class TransferPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 208815852313880249L;
	private String id;
	private Date loadDate;
	private String flightNumbe;
	private String depart;
	private String destination;
	private String containerId;
	private String loadMan;
	private List<String> orderId;
	private double expenses;
	private DocumentState documentState;

	public TransferPO(String id, Date date, String flightNum, String depart,
			String destination, String containerId, String loadMan, List<String> orderId, 
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
		documentState = DocumentState.PENDING;
	}

	public TransferVO getTransferVO(){
		return new TransferVO(id, loadDate, flightNumbe, depart,
				destination, containerId, loadMan, orderId, expenses);
	}
	public DocumentState getDocumentState() {
		return documentState;
	}


	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}


	public String getId() {
		return id;
	}

	public Date getLoadDate() {
		return loadDate;
	}
	
	public String getFlightNumbe() {
		return flightNumbe;
	}

	public String getDepart() {
		return depart;
	}

	public String getDestination() {
		return destination;
	}

	public String getContainerId() {
		return containerId;
	}

	public String getLoadMan() {
		return loadMan;
	}

	public List<String> getOrderId() {
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

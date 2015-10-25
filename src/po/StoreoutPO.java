package po;

import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import systemenum.ShipForm;

public class StoreoutPO {
	
	private long id;
	private DocumentState documentState;
	private List<Long> orderId;
	private Date date;
	private List<String> destination;
	private List<ShipForm> shipForm;
	private long transferId;
	
	
	public StoreoutPO(long id,List<Long> orderId, Date date, List<String> destination,
			List<ShipForm> shipForm, long transferId) {
		super();
		this.id = id;
		this.documentState = DocumentState.PENDING;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
	}
	
	
	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}

	public long getStoreoutId() {
		return id;
	}
	
	public List<Long> getOrderId() {
		return orderId;
	}
	public Date getDate() {
		return date;
	}
	public List<String> getDestination() {
		return destination;
	}
	public List<ShipForm> getShipForm() {
		return shipForm;
	}
	public long getTransferId() {
		return transferId;
	}
	
	


}

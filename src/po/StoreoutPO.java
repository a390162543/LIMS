package po;

import java.util.Date;
import java.util.List;

import systemenum.ShipForm;

public class StoreoutPO {
	
	private List<Long> orderId;
	private Date date;
	private List<String> destination;
	private List<ShipForm> shipForm;
	private long transferId;
	
	
	public StoreoutPO(List<Long> orderId, Date date, List<String> destination,
			List<ShipForm> shipForm, long transferId) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
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

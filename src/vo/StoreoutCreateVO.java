package vo;

import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.ShipForm;


/**
 * 创建出库单是从界面传来的VO 
 * @author lc
 * @version 1.4
 *
 */
public class StoreoutCreateVO {
	
	private String id;
	private List<String> orderId;
	private Date date;
	private String destination;
	private ShipForm shipForm;
	private String transferId;
	private String organization;
	
	
	public StoreoutCreateVO(String id, List<String> orderId, Date date,
			String destination, ShipForm shipForm, String transferId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
	}
	
	


	public StoreoutCreateVO(String id, List<String> orderId, Date date,
			String destination, ShipForm shipForm, String transferId,
			String organization) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
		this.organization = organization;
	}



	

	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}




	public String getId() {
		return id;
	}

	public List<String> getOrderId() {
		return orderId;
	}

	public Date getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public ShipForm getShipForm() {
		return shipForm;
	}

	public String getTransferId() {
		return transferId;
	}
	
	/**
	 * 根据VO获取相应的PO
	 * 
	 * @return 返回一个{@code StoreoutPO}
	 */
	public StoreoutPO getStoreoutPO(){
		return new StoreoutPO(id, orderId, date, destination, shipForm, transferId, organization);
	}
	
	
}

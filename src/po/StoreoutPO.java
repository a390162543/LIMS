package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import systemenum.ShipForm;
import vo.StoreinCheckResultVO;
import vo.StoreoutCheckResultVO;
import vo.StoreoutQueryVO;

public class StoreoutPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3110687625240396461L;
	/**
	 * 
	 */
	
	
	private String id;
	private DocumentState documentState;
	private List<String> orderId;
	private Date date;
	private String destination;
	private ShipForm shipForm;
	private String transferId;
	private String organization;
	
	
	public StoreoutPO(String id,List<String> orderId, Date date, String destination,
			ShipForm shipForm, String transferId) {
		super();
		this.id = id;
		this.documentState = DocumentState.PENDING;
		this.orderId = orderId;
		this.date = date;
		this.destination = destination;
		this.shipForm = shipForm;
		this.transferId = transferId;
	}
	
	
	
	
	public StoreoutPO(String id, List<String> orderId,
			Date date, String destination, ShipForm shipForm, String transferId,
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




	public void setOrganizationn(){
		
	}
	
	public String getOrganization(){
		return organization;
	}
	
	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}

	public String getStoreoutId() {
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
	
	public List<StoreoutCheckResultVO> getStoreoutCheckResultVOs(){
		
		List<StoreoutCheckResultVO> storeoutCheckResultVOs = new ArrayList<StoreoutCheckResultVO>();
		for (int i = 0; i < orderId.size(); i++) {
			StoreoutCheckResultVO vo = new StoreoutCheckResultVO(orderId.get(i), destination, date);
			storeoutCheckResultVOs.add(vo);
			
		}
		return storeoutCheckResultVOs;
	}


	public StoreoutQueryVO getStoreoutQueryVO() {
		return new StoreoutQueryVO(orderId);
	}
}

package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import vo.DeliverVO;

public class DeliverPO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 8531669270881322113L;
    
    private String id;
    private Date deliverDate;
    private String orderId;
    private String courierId;
    private DocumentState documentState;
    
    public DeliverPO(String id, Date deliverDate, String orderId,
            String courierId) {
        this.id = id;
        this.deliverDate = deliverDate;
        this.orderId = orderId;
        this.courierId = courierId;
        this.documentState = DocumentState.PENDING;
    }

    public String getIdString(){
        return String.format("%018d", id);
    }
    
    public String getOrderIdString(){
        return String.format("%010d", orderId);
    }
    
    public String getCourierIdString(){
        return String.format("%09d", courierId);
    }
    
    public String getId() {
        return id;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCourierId() {
        return courierId;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public void update(DeliverVO vo) {
        this.id = vo.getId();
        this.deliverDate = vo.getDeliverDate();
        this.orderId = vo.getOrderId();
        this.courierId = vo.getCourierId();
    }
    
    public DeliverVO getDeliverVO(){
        return new DeliverVO(id, deliverDate, orderId, courierId);
    }
}

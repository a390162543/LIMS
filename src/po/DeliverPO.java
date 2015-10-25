package po;

import java.util.Date;

import systemenum.DocumentState;

public class DeliverPO {

    private long id;
    private Date DeliverDate;
    private long orderId;
    private long courierId;
    private DocumentState documentState;
    
    public DeliverPO(long id, Date deliverDate, long orderId,
            long courierId) {
        this.id = id;
        DeliverDate = deliverDate;
        this.orderId = orderId;
        this.courierId = courierId;
        this.documentState = DocumentState.PENDING;
    }

    public long getId() {
        return id;
    }

    public Date getDeliverDate() {
        return DeliverDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getCourierId() {
        return courierId;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

}

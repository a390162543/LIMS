package vo;

import java.util.Date;

public class DeliverVO {

    private long id;
    private Date DeliverDate;
    private long orderId;
    private long courierId;
    
    public DeliverVO(long id, Date deliverDate, long orderId,
            long courierId) {
        this.id = id;
        DeliverDate = deliverDate;
        this.orderId = orderId;
        this.courierId = courierId;
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

}

package vo;

import java.util.Date;

import po.DeliverPO;

public class DeliverVO {

    private String id;
    private Date deliverDate;
    private String orderId;
    private String courierId;
    
    public DeliverVO(String id, Date deliverDate, String orderId,
            String courierId) {
        this.id = id;
        this.deliverDate = deliverDate;
        this.orderId = orderId;
        this.courierId = courierId;
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

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public DeliverPO getDeliverPO() {
        return new DeliverPO(id, deliverDate, orderId, courierId);
    }

}

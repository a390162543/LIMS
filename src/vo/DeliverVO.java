package vo;

import java.util.Date;

import po.DeliverPO;

/**
 * {@code DeliverVO}是派件单界面与业务逻辑层之间传递的值对象，
 * 记录了派件单的所有信息
 * @author 林祖华
 * @version 1.3
 * @see systemenum.GoodsState
 * @see po.DeliverPO
 */
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

    /**
     * 获取一个{@code DeliverVO}对应的{@code DeliverPO}对象
     * @return {@code DeliverPO}对象
     */
    public DeliverPO getDeliverPO() {
        return new DeliverPO(id, deliverDate, orderId, courierId);
    }

}

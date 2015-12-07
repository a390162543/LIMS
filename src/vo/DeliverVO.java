package vo;

import java.util.Date;

import po.DeliverPO;

/**
 * {@code DeliverVO}���ɼ���������ҵ���߼���֮�䴫�ݵ�ֵ����
 * ��¼���ɼ�����������Ϣ
 * @author ���滪
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
     * ��ȡһ��{@code DeliverVO}��Ӧ��{@code DeliverPO}����
     * @return {@code DeliverPO}����
     */
    public DeliverPO getDeliverPO() {
        return new DeliverPO(id, deliverDate, orderId, courierId);
    }

}

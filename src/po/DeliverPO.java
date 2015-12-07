package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import vo.DeliverVO;

/**
 * {@code DeliverPO}是派件单业务逻辑层与数据层之间传递的持久化对象，
 * 记录了派件单的所有信息
 * @author 林祖华
 * @see systemenum.DocumentState
 * @see vo.DeliverVO
 */
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

    /**
     * 用一个{@code DeliverVO}对象更新{@code DeliverPO}的信息
     * @param vo {@code DeliverVO}对象
     */
    public void update(DeliverVO vo) {
        this.id = vo.getId();
        this.deliverDate = vo.getDeliverDate();
        this.orderId = vo.getOrderId();
        this.courierId = vo.getCourierId();
    }
    
    /**
     * 获取该{@code DeliverPO}对应的{@code DeliverVO}对象
     * @return {@code DeliverVO}对象
     */
    public DeliverVO getDeliverVO(){
        return new DeliverVO(id, deliverDate, orderId, courierId);
    }
}

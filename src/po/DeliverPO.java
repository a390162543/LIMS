package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import vo.DeliverVO;

/**
 * {@code DeliverPO}���ɼ���ҵ���߼��������ݲ�֮�䴫�ݵĳ־û�����
 * ��¼���ɼ�����������Ϣ
 * @author ���滪
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
     * ��һ��{@code DeliverVO}�������{@code DeliverPO}����Ϣ
     * @param vo {@code DeliverVO}����
     */
    public void update(DeliverVO vo) {
        this.id = vo.getId();
        this.deliverDate = vo.getDeliverDate();
        this.orderId = vo.getOrderId();
        this.courierId = vo.getCourierId();
    }
    
    /**
     * ��ȡ��{@code DeliverPO}��Ӧ��{@code DeliverVO}����
     * @return {@code DeliverVO}����
     */
    public DeliverVO getDeliverVO(){
        return new DeliverVO(id, deliverDate, orderId, courierId);
    }
}

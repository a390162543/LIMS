package po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import vo.RevenueVO;

/**
 * {@code RevenuePO}是收款单业务逻辑层与数据层之间传递的持久化对象，
 * 记录了收款单的所有信息
 * @author 林祖华
 * @see systemenum.DocumentState
 * @see vo.RevenueVO
 */
public class RevenuePO implements Serializable{
     
    /**
     * 
     */
    private static final long serialVersionUID = 3958175122085897221L;
    
    private String id;
    private Date revenueDate;
    private String courierId;
    private double revenue;
    private List<String> orderId;
    private String accountId;
    private String organization;
    private DocumentState documentState;
    
    @Deprecated
    public RevenuePO(String id, Date revenueDate, String courierId, double revenue,
            List<String> orderId) {
        this.id = id;
        this.revenueDate = revenueDate;
        this.courierId = courierId;
        this.revenue = revenue;
        this.orderId = orderId;
        this.documentState = DocumentState.UNCOMMITTED;
    }
    
    public RevenuePO(String id, Date revenueDate, String courierId, double revenue,
            List<String> orderId,String organization) {
        this.id = id;
        this.revenueDate = revenueDate;
        this.courierId = courierId;
        this.revenue = revenue;
        this.orderId = orderId;
        this.accountId = "";
        this.organization = organization;
        this.documentState = DocumentState.UNCOMMITTED;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getId() {
        return id;
    }

    public Date getRevenueDate() {
        return revenueDate;
    }

    public String getCourierId() {
        return courierId;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    /**
     * 用一个{@code RevenueVO}对象更新{@code RevenuePO}的信息
     * @param vo {@code RevenueVO}对象
     */
    public void update(RevenueVO vo) {
        this.id = vo.getId();
        this.revenueDate = vo.getRevenueDate();
        this.courierId = vo.getCourierId();
        this.revenue = vo.getRevenue();
        this.orderId = vo.getOrderId();
        this.accountId = vo.getAccountId();
        this.organization = vo.getOrganization();
    }

    /**
     * 获取该{@code RevenuePO}对应的{@code RevenueVO}对象
     * @return {@code RevenueVO}对象
     */
    public RevenueVO getRevenueVO(){
        return new RevenueVO(id, revenueDate, courierId, revenue, orderId, accountId, organization);
    }


}

package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import vo.RevenueVO;

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
    


    public String getIdString(){
        return String.format("%018d", id);
    }
    
    public String getAccountIdString(){
        return String.format("%019d", accountId);
    }
    
    public String getcourierIdString(){
        return String.format("%09d", courierId);
    }
    
    public List<String> getOrderIdStringList(){
        List<String> orderIdStrings = new ArrayList<String>();
        for(String id : orderId){
            orderIdStrings.add(String.format("%010d", id));
        }
        return orderIdStrings;
    }
    
    public double getRevenue() {
        return revenue;
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
    
    public void update(RevenueVO vo) {
        this.id = vo.getId();
        this.revenueDate = vo.getRevenueDate();
        this.courierId = vo.getCourierId();
        this.revenue = vo.getRevenue();
        this.orderId = vo.getOrderId();
        this.accountId = vo.getAccountId();
        this.organization = vo.getOrganization();
    }

    public RevenueVO getRevenueVO(){
        return new RevenueVO(id, revenueDate, courierId, revenue, orderId, accountId, organization);
    }


}

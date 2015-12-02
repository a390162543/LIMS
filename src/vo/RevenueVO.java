package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.RevenuePO;

public class RevenueVO {
    
    private String id;
    private Date revenueDate;
    private String courierId;
    private double revenue;
    private List<String> orderId;
    private String accountId;
    private String organization;
    
    public RevenueVO(String id, Date revenueDate, String courierId, double revenue,
            List<String> orderId) {
        this.id = id;
        this.revenueDate = revenueDate;
        this.courierId = courierId;
        this.revenue = revenue;
        this.orderId = orderId;
    }
    
    public RevenueVO(String id, Date revenueDate, String courierId, double revenue,
            List<String> orderId,String organization) {
        this.id = id;
        this.revenueDate = revenueDate;
        this.courierId = courierId;
        this.revenue = revenue;
        this.orderId = orderId;
        this.accountId = "";
        this.organization = organization;
    }
    
    public RevenueVO(String id, Date revenueDate, String courierId, double revenue,
            List<String> orderId, String accountId, String organization) {
        this.id = id;
        this.revenueDate = revenueDate;
        this.courierId = courierId;
        this.revenue = revenue;
        this.orderId = orderId;
        this.accountId = accountId;
        this.organization = organization;
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
    
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public RevenuePO getRevenuePO() {
        return new RevenuePO(id, revenueDate, courierId, revenue, orderId, organization);
    }



}

package po;

import java.util.Date;
import java.util.List;

public class RevenuePO {
    
    private long id;
    private Date RevenueDate;
    private long courierID;
    private double revenue;
    private List<Long> orderID;
    
    public RevenuePO(long id, Date revenueDate, long courierID, double revenue,
            List<Long> orderID) {
        this.id = id;
        RevenueDate = revenueDate;
        this.courierID = courierID;
        this.revenue = revenue;
        this.orderID = orderID;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public long getId() {
        return id;
    }

    public Date getRevenueDate() {
        return RevenueDate;
    }

    public long getCourierID() {
        return courierID;
    }

    public List<Long> getOrderID() {
        return orderID;
    }

}

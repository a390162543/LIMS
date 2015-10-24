package vo;

import java.util.Date;
import java.util.List;

public class LoadVO {
    
    private long id;
    private Date loadingDate;
    private long transportId;
    private String arrive;
    private long truckId;
    private String loadMan;
    private String transman;
    private List<Long> OrderId;
    private double cost;
    
    public LoadVO(long id, Date loadingDate, long transportId, String arrive,
            long truckId, String loadMan, String transman, List<Long> orderId,
            double cost) {
        super();
        this.id = id;
        this.loadingDate = loadingDate;
        this.transportId = transportId;
        this.arrive = arrive;
        this.truckId = truckId;
        this.loadMan = loadMan;
        this.transman = transman;
        OrderId = orderId;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public long getTransportId() {
        return transportId;
    }

    public String getArrive() {
        return arrive;
    }

    public long getTruckId() {
        return truckId;
    }

    public String getLoadMan() {
        return loadMan;
    }

    public String getTransman() {
        return transman;
    }

    public List<Long> getOrderId() {
        return OrderId;
    }

    public double getCost() {
        return cost;
    }
    
    

}

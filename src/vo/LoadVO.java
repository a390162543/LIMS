package vo;


import java.util.Date;
import java.util.List;

import po.LoadPO;
/**
 * {@code LoadVO}是装车单界面与业务逻辑层之间传递的值对象，
 * 记录了装车单的所有信息
 * @author 林祖华
 * @version 1.5
 * @see systemenum.GoodsState
 * @see po.LoadPO
 */
public class LoadVO {
    
    private String id;
    private Date loadingDate;
    private String transportId;
    private String depart;
    private String destination;
    private String driverId;
    private String truckId;
    private String loadMan;
    private String transman;
    private List<String> orderId;
    private double cost;
    
    @Deprecated
    public LoadVO(String id, Date loadingDate, String transportId, String arrive,
            String truckId, String loadMan, String transman, List<String> orderId,
            double cost) {
        super();
        this.id = id;
        this.loadingDate = loadingDate;
        this.transportId = transportId;
        this.destination = arrive;
        this.truckId = truckId;
        this.loadMan = loadMan;
        this.transman = transman;
        this.orderId = orderId;
        this.cost = cost;
    }
    
    public LoadVO(String id, Date loadingDate, String transportId, String depart,
            String destination, String truckId, String loadMan, String transman,
            List<String> orderId, double cost) {
        super();
        this.id = id;
        this.loadingDate = loadingDate;
        this.transportId = transportId;
        this.depart = depart;
        this.destination = destination;
        this.truckId = truckId;
        this.loadMan = loadMan;
        this.transman = transman;
        this.orderId = orderId;
        this.cost = cost;
    }
    
    public LoadVO(String id, Date loadingDate, String transportId, String depart,
            String destination, String driverId, String truckId, String loadMan, String transman,
            List<String> orderId, double cost) {
        super();
        this.id = id;
        this.loadingDate = loadingDate;
        this.transportId = transportId;
        this.depart = depart;
        this.destination = destination;
        this.driverId = driverId;
        this.truckId = truckId;
        this.loadMan = loadMan;
        this.transman = transman;
        this.orderId = orderId;
        this.cost = cost;
    }
    
    public String getId() {
        return id;
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public String getTransportId() {
        return transportId;
    }

    public String getDestination() {
        return destination;
    }

    public String getTruckId() {
        return truckId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getLoadMan() {
        return loadMan;
    }

    public String getTransman() {
        return transman;
    }

    public void setLoadMan(String loadMan) {
        this.loadMan = loadMan;
    }

    public void setTransman(String transman) {
        this.transman = transman;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public double getCost() {
        return cost;
    }

    public String getDepart() {
        return depart;
    }
    
    /**
     * 获取一个{@code LoadVO}对应的{@code LoadPO}对象
     * @return {@code LoadPO}对象
     */
    public LoadPO getLoadPO() {
        return new LoadPO(id, loadingDate, transportId, depart, destination, driverId, truckId, loadMan, transman, orderId, cost);
    }




}

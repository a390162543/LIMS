package po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import vo.LoadVO;

/**
 * {@code LoadPO}是装车单业务逻辑层与数据层之间传递的持久化对象，
 * 记录了装车单的所有信息
 * @author 林祖华
 * @see systemenum.DocumentState
 * @see vo.LoadVO
 */
public class LoadPO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -2926597235162544784L;
    
    private String id;
    private Date loadingDate;
    private String transportId;
    private String depart;
    private String destination;
    private String truckId;
    private String loadMan;
    private String transman;
    private List<String> orderId;
    private double cost;
    private DocumentState documentState;
    
    @Deprecated
    public LoadPO(String id, Date loadingDate, String transportId, String arrive,
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
        this.documentState = DocumentState.PENDING;
    }
    
    public LoadPO(String id, Date loadingDate, String transportId, String depart,
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
        this.documentState = DocumentState.PENDING;
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

    public String getDepart() {
        return depart;
    }
    
    public String getDestination() {
        return destination;
    }

    public String getTruckId() {
        return truckId;
    }

    public String getLoadMan() {
        return loadMan;
    }

    public String getTransman() {
        return transman;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public double getCost() {
        return cost;
    }
    
    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    /**
     * 用一个{@code LoadVO}对象更新{@code LoadPO}的信息
     * @param vo {@code LoadVO}对象
     */
    public void update(LoadVO vo) {
        this.id = vo.getId();
        this.loadingDate = vo.getLoadingDate();
        this.transportId = vo.getTransportId();
        this.depart = vo.getDepart();
        this.destination = vo.getDestination();
        this.truckId = vo.getTruckId();
        this.loadMan = vo.getLoadMan();
        this.transman = vo.getTransman();
        this.orderId = vo.getOrderId();
        this.cost = vo.getCost();
    }

    /**
     * 获取该{@code LoadPO}对应的{@code LoadVO}对象
     * @return {@code LoadVO}对象
     */
    public LoadVO getLoadVO(){
        return new LoadVO(id, loadingDate, transportId, depart, destination, truckId, loadMan, transman, orderId, cost);
    }

    
    

}

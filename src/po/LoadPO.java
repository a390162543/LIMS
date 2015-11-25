package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import vo.LoadVO;

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

    public String getIdString(){
        return String.format("%018d", id);
    }
    
    public String getTransportIdString(){
        return String.format("%010d", transportId);
    }
    
    public String getTruckIdString(){
        return String.format("%09d", truckId);
    }
    
    public List<String> getOrderIdStringList(){
        List<String> orderIdStrings = new ArrayList<String>();
        for(String id : orderId){
            orderIdStrings.add(String.format("%010d", id));
        }
        return orderIdStrings;
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

    public LoadVO getLoadVO(){
        return new LoadVO(id, loadingDate, transportId, depart, destination, truckId, loadMan, transman, orderId, cost);
    }

    
    

}

package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import systemenum.GoodsState;
import vo.ArrivalVO;

public class ArrivalPO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -1192785585276119630L;
    private String id;
    private Date arrivalDate;
    private String transferId;
    private String depart;
    private String destination;
    private GoodsState goodsState;
    private DocumentState documentState;
    
    public ArrivalPO(String id, Date arrivalDate, String transferId,
            String depart, GoodsState gs){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.goodsState = gs;
        this.documentState = DocumentState.PENDING;
    }
    
    public ArrivalPO(String id, Date arrivalDate, String transferId,
            String depart, String destination, GoodsState gs){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.destination = destination;
        this.goodsState = gs;
        this.documentState = DocumentState.PENDING;
    }

    public String getIdString(){
        if(destination.contains("中转中心"))
            return String.format("%016d", id);
        else
            return String.format("%018d", id);
    }
    
    public String getTransferIdString(){
        if(depart.contains("中转中心") && destination.contains("中转中心"))
            return String.format("%017d", transferId);
        else if(depart.contains("中转中心"))
            return String.format("%016d", transferId);
        else
            return String.format("%018d", transferId);
    }
    
    public String getId() {
        return id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public String getTransferId() {
        return transferId;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public GoodsState getGoodsState() {
        return goodsState;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public void update(ArrivalVO vo) {
        this.id = vo.getId();
        this.arrivalDate = vo.getArrivalDate();
        this.transferId = vo.getTransferId();
        this.depart = vo.getDepart();
        this.destination = vo.getDestination();
        this.goodsState = vo.getGoodsState();
    }



}

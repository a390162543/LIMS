package vo;

import java.util.Date;

import po.ArrivalPO;
import systemenum.GoodsState;

public class ArrivalVO {
    
    private String id;
    private Date arrivalDate;
    private String transferId;
    private String depart;
    private String destination;
    private GoodsState goodsState;
    
    public ArrivalVO(String id, Date arrivalDate, String transferId,
            String depart, GoodsState gs){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.goodsState = gs;
    }
    
    public ArrivalVO(String id, Date arrivalDate, String transferId,
            String depart, String destination, GoodsState goodsState){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.destination = destination;
        this.goodsState = goodsState;
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

    public GoodsState getGoodsState() {
        return goodsState;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public ArrivalPO getArrivalPO() {
        return new ArrivalPO(id, arrivalDate, transferId, depart, destination, goodsState);
    }

}

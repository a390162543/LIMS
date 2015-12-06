package vo;

import java.util.Date;

import po.ArrivalPO;
import systemenum.GoodsState;

/**
 * {@code ArrivalVO}是到达单界面与业务逻辑层之间传递的值对象，
 * 记录了到达单的所有信息
 * @author 林祖华
 * @version 1.6
 * @see systemenum.GoodsState
 */
public class ArrivalVO {
    

    private String id;
    private Date arrivalDate;
    private String transferId;
    private boolean isTransferId;
    private String depart;
    private String destination;
    private GoodsState goodsState;
    
    @Deprecated
    public ArrivalVO(String id, Date arrivalDate, String transferId,
            String depart, GoodsState gs){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.goodsState = gs;
        if(transferId.length() == 19)
            isTransferId = true;
    }
    
    public ArrivalVO(String id, Date arrivalDate, String transferId,
            String depart, String destination, GoodsState goodsState){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.destination = destination;
        this.goodsState = goodsState;
        if(transferId.length() == 17)
            isTransferId = true;
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
    
    public boolean isTransferId() {
        return isTransferId;
    }
    
    public String getDepart() {
        return depart;
    }

    public GoodsState getGoodsState() {
        return goodsState;
    }
    
    public void setGoodsState(GoodsState goodsState) {
        this.goodsState = goodsState;
    }

    public String getDestination() {
        return destination;
    }
    
    /**
     * 获取一个{@code ArrivalVO}对应的{@code ArrivalPO}对象
     * @return {@code ArrivalPO}对象
     */
    public ArrivalPO getArrivalPO() {
        return new ArrivalPO(id, arrivalDate, transferId, depart, destination, goodsState);
    }



}

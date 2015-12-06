package vo;

import java.util.Date;

import po.ArrivalPO;
import systemenum.GoodsState;

/**
 * {@code ArrivalVO}�ǵ��ﵥ������ҵ���߼���֮�䴫�ݵ�ֵ����
 * ��¼�˵��ﵥ��������Ϣ
 * @author ���滪
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
     * ��ȡһ��{@code ArrivalVO}��Ӧ��{@code ArrivalPO}����
     * @return {@code ArrivalPO}����
     */
    public ArrivalPO getArrivalPO() {
        return new ArrivalPO(id, arrivalDate, transferId, depart, destination, goodsState);
    }



}

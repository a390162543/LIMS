package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import systemenum.GoodsState;
import vo.ArrivalVO;

/**
 * {@code ArrivalPO}是到达单业务逻辑层与数据层之间传递的持久化对象，
 * 记录了到达单的所有信息
 * @author 林祖华
 * @see systemenum.GoodsState
 * @see systemenum.DocumentState
 * @see vo.ArrivalVO
 */
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
    
    @Deprecated
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

    /**
     * 用一个{@code ArrivalVO}对象更新{@code ArrivalPO}的信息
     * @param vo {@code ArrivalVO}对象
     */
    public void update(ArrivalVO vo) {
        this.id = vo.getId();
        this.arrivalDate = vo.getArrivalDate();
        this.transferId = vo.getTransferId();
        this.depart = vo.getDepart();
        this.destination = vo.getDestination();
        this.goodsState = vo.getGoodsState();
    }

    /**
     * 获取该{@code ArrivalPO}对应的{@code ArrivalVO}对象
     * @return {@code ArrivalVO}对象
     */
    public ArrivalVO getArrivalVO(){
        return new ArrivalVO(id, arrivalDate, transferId, depart, destination, goodsState);
    }

}

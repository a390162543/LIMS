package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DocumentState;
import systemenum.GoodsState;
import vo.ArrivalVO;

/**
 * {@code ArrivalPO}�ǵ��ﵥҵ���߼��������ݲ�֮�䴫�ݵĳ־û�����
 * ��¼�˵��ﵥ��������Ϣ
 * @author ���滪
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
     * ��һ��{@code ArrivalVO}�������{@code ArrivalPO}����Ϣ
     * @param vo {@code ArrivalVO}����
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
     * ��ȡ��{@code ArrivalPO}��Ӧ��{@code ArrivalVO}����
     * @return {@code ArrivalVO}����
     */
    public ArrivalVO getArrivalVO(){
        return new ArrivalVO(id, arrivalDate, transferId, depart, destination, goodsState);
    }

}

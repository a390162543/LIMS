package po;

import java.util.Date;

import systemenum.DocumentState;
import systemenum.GoodsState;

public class ArrivalPO {
    
    private long id;
    private Date arrivalDate;
    private long transferId;
    private String depart;
    private GoodsState gs;
    private DocumentState documentState;
    
    public ArrivalPO(Long id, Date arrivalDate, long transferId,
            String depart, GoodsState gs){
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.transferId = transferId;
        this.depart = depart;
        this.gs = gs;
        this.documentState = DocumentState.PENDING;
    }

    public long getId() {
        return id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public long getTransferId() {
        return transferId;
    }

    public String getDepart() {
        return depart;
    }

    public GoodsState getGs() {
        return gs;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

}

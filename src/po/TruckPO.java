package po;

import java.util.Date;

import javax.swing.ImageIcon;

import systemenum.DocumentState;

public class TruckPO {
    
    private long id;
    private String engineNumber;
    private String truckNumber;
    private String chassisNumber;
    private Date purchaseDate;
    private ImageIcon truckImage;
    private DocumentState documentState;
    
    public TruckPO(long id, String engineNumber, String truckNumber,
            String chassisNumber, Date purchaseDate, ImageIcon truckImage) {
        this.id = id;
        this.engineNumber = engineNumber;
        this.truckNumber = truckNumber;
        this.chassisNumber = chassisNumber;
        this.purchaseDate = purchaseDate;
        this.truckImage = truckImage;
        this.documentState = DocumentState.PENDING;
    }

    public long getId() {
        return id;
    }
    
    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ImageIcon getTruckImage() {
        return truckImage;
    }

    public void setTruckImage(ImageIcon truckImage) {
        this.truckImage = truckImage;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }



    
}

package vo;

import java.util.Date;

import javax.swing.ImageIcon;

import po.TruckPO;

public class TruckVO {
    
    private String id;
    private String organization;
    private String engineNumber;
    private String truckNumber;
    private String chassisNumber;
    private Date purchaseDate;
    private ImageIcon truckImage;
    
    public TruckVO(String id, String engineNumber, String truckNumber,
            String chassisNumber, Date purchaseDate, ImageIcon truckImage) {
        this.id = id;
        this.engineNumber = engineNumber;
        this.truckNumber = truckNumber;
        this.chassisNumber = chassisNumber;
        this.purchaseDate = purchaseDate;
        this.truckImage = truckImage;
    }
    
    public TruckVO(String id, String organization,String engineNumber, String truckNumber,
            String chassisNumber, Date purchaseDate, ImageIcon truckImage) {
        this.id = id;
        this.organization = organization;
        this.engineNumber = engineNumber;
        this.truckNumber = truckNumber;
        this.chassisNumber = chassisNumber;
        this.purchaseDate = purchaseDate;
        this.truckImage = truckImage;
    }

    public String getIdString(){
        return String.format("%09d", id);
    }
    
    public String getId() {
        return id;
    }
    
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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
    
    public String getServedTime(){
        int day = (int) ((System.currentTimeMillis()-purchaseDate.getTime())/(1000*60*60*24));
        return day+"Ìì";
    } 
    public ImageIcon getTruckImage() {
        return truckImage;
    }

    public void setTruckImage(ImageIcon truckImage) {
        this.truckImage = truckImage;
    }

    public TruckPO getTruckPO(){
        return new TruckPO(this.id, this.getOrganization(), this.engineNumber, this.truckNumber, this.chassisNumber, this.purchaseDate, this.truckImage);
    }

    
}

package businesslogicservice;

import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

import po.TruckPO;

public interface TruckblService {
    
    public TruckPO createTruckPO(long truckID,String engineNumber,
            String truckNumber,String chassisNumber,Date purchaseDate,
            ImageIcon truckImage);
    
    public boolean deleteTruckPO();
    
    public TruckPO modifyTruckPO(long truckID,String engineNumber,
            String truckNumber,String chassisNumber,Date purchaseDate,
            ImageIcon truckImage);

    public TruckPO queryTruckPO();
    
    public boolean setFocusedTruckPO(int index);
    
    public List<TruckPO> getTruckPO();
}

package businesslogic.truckbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.TruckDataService;
import dataservice.IdDataService;
import businesslogic.BusinessLogicUtil;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdManager;

public class TruckIdManager implements IdManager{

    
    private IdDataService idDataService;
    private TruckDataService truckDataService;
    private final int ORDINAL_LENGTH = 3;
    
    public TruckIdManager() {
        try {
            idDataService = (IdDataService) Naming.lookup("rmi://localhost/IdData");
            truckDataService = (TruckDataService) Naming.lookup("rmi://localhost/TruckData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }
    
    @Override
    public String createNewId() {
        String tag = LoginController.getOrganizationId();
        String previousId = "";
        String id = "";
        try {
            previousId = idDataService.getTruckId(tag);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        //如果先前的Id并不存在，直接创建Id
        if(previousId == null || previousId.equals("")){
            id = tag+BusinessLogicUtil.formatByZero("0", ORDINAL_LENGTH);
        }else{
               String previousOrdinal = previousId.substring(tag.length());
               int tempOrdinal = new Integer(previousOrdinal)+1;
               int divisor = (int) Math.pow(10, ORDINAL_LENGTH);
               for(int i=tempOrdinal%divisor;;i++){
                   id = tag+BusinessLogicUtil.formatByZero(""+i, ORDINAL_LENGTH);
                   try {
                       if(truckDataService.find(id) == null)
                           break;
                   } catch (RemoteException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
        }
        try {
            idDataService.updateTruckId(tag, id);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }

}

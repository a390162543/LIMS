package businesslogic.deliverbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.DeliverDataService;
import dataservice.IdDataService;
import businesslogic.BusinessLogicUtil;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdManager;

public class DeliverIdManager implements IdManager{

    
    private IdDataService idDataService;
    private DeliverDataService deliverDataService;
    private final int ORDINAL_LENGTH = 6;
    
    public DeliverIdManager() {
        try {
            idDataService = (IdDataService) Naming.lookup("rmi://localhost/IdData");
            deliverDataService = (DeliverDataService) Naming.lookup("rmi://localhost/DeliverData");
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
        String date = BusinessLogicUtil.getDate();
        try {
            previousId = idDataService.getDeliverId(tag);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        //如果先前的Id并不存在，直接创建Id
        if(previousId == null || previousId.equals("")){
            id = tag+date+BusinessLogicUtil.formatByZero("0", ORDINAL_LENGTH);
        }else{
            String previousDate = previousId.substring(tag.length(), tag.length()+date.length());
           //判断是否为同一天
            if(previousDate.equals(date)){
               String previousOrdinal = previousId.substring(tag.length()+date.length());
               int tempOrdinal = new Integer(previousOrdinal)+1;
               int divisor = (int) Math.pow(10, ORDINAL_LENGTH);
               for(int i=tempOrdinal%divisor;;i++){
                   id = tag+date+BusinessLogicUtil.formatByZero(""+i, ORDINAL_LENGTH);
                   try {
                       if(deliverDataService.find(id) == null)
                           break;
                   } catch (RemoteException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
            }else{
                //新的一天，直接创建Id
                id = tag+date+BusinessLogicUtil.formatByZero("0", ORDINAL_LENGTH);
            }
        }
        try {
            idDataService.updateDeliverId(tag, id);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }

}

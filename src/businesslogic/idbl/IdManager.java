package businesslogic.idbl;

import java.rmi.RemoteException;

import dataservice.DataIdentifiable;
import dataservice.IdDataService;
import businesslogic.BusinessLogicUtil;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;

public class IdManager implements IdblService{

    protected DataIdentifiable dataService;
    protected IdDataService idDataService;
    protected int ordinalLength;
    protected boolean isByDate;
    
    public IdManager(DataIdentifiable dataService,int ordinalLength) {
        this.dataService = dataService;
        this.isByDate = true;
        try {
            this.idDataService = dataService.getIdDataService();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.ordinalLength = ordinalLength;
    }
    
    public IdManager(DataIdentifiable dataService,int ordinalLength,boolean isByDate) {
        this(dataService, ordinalLength);
        this.isByDate = isByDate;
    }
    
    @Override
    public String createNewId() {
        String tag = LoginController.getOrganizationId();
        return createNewId(tag);
    }

    @Override
    public String createNewId(String tag) {
        String previousId = "";
        String id = "";
        String date = BusinessLogicUtil.getDate();
        if(!isByDate)
            date = "";
        try {
            previousId = idDataService.getId(tag);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        //如果先前的Id并不存在，直接创建Id
        if(previousId == null || previousId.equals("")){
            id = tag+date+BusinessLogicUtil.formatByZero("0", ordinalLength);
        }else{
            String previousDate = previousId.substring(tag.length(), tag.length()+date.length());
           //判断是否为同一天
            if(previousDate.equals(date)){
               String previousOrdinal = previousId.substring(tag.length()+date.length());
               int tempOrdinal = new Integer(previousOrdinal)+1;
               int divisor = (int) Math.pow(10, ordinalLength);
               for(int i=tempOrdinal%divisor;;i++){
                   id = tag+date+BusinessLogicUtil.formatByZero(""+i, ordinalLength);
                   try {
                       if(dataService.isAvailable(id))
                           break;
                   } catch (RemoteException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
            }else{
                //新的一天，直接创建Id
                id = tag+date+BusinessLogicUtil.formatByZero("0", ordinalLength);
            }
        }
        try {
            idDataService.updateId(tag, id);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }

}

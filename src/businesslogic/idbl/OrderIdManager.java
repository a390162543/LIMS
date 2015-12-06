package businesslogic.idbl;

import java.rmi.RemoteException;

import businesslogic.BusinessLogicUtil;
import dataservice.DataIdentifiable;

public class OrderIdManager extends IdManager{
    

    public OrderIdManager(DataIdentifiable dataService, int ordinalLength) {
        super(dataService, ordinalLength);
    }
    
    
    @Override
    public String createNewId() {
        return createNewId("");
    }

    @Override
    public String createNewId(String tag) {
        tag = "orderId";
        String previousId = "";
        String id = "";
        String date = BusinessLogicUtil.getDate();
        date = date.substring(4);
        try {
            previousId = idDataService.getId(tag);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        //�����ǰ��Id�������ڣ�ֱ�Ӵ���Id
        if(previousId == null || previousId.equals("")){
            id = date+BusinessLogicUtil.formatByZero("0", ordinalLength);
        }else{
        	
            //String previousDate = previousId.substring(tag.length(), tag.length()+date.length());
            String previousDate = previousId.substring(0, 4);
           //�ж��Ƿ�Ϊͬһ��
            if(previousDate.equals(date)){
               String previousOrdinal = previousId.substring(4,10);
               int tempOrdinal = new Integer(previousOrdinal)+1;
               int divisor = (int) Math.pow(10, ordinalLength);
               for(int i=tempOrdinal%divisor;;i++){
                   id = date+BusinessLogicUtil.formatByZero(""+i, ordinalLength);
                   try {
                       if(dataService.isAvailable(id))
                           break;
                   } catch (RemoteException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
            }else{
                //�µ�һ�죬ֱ�Ӵ���Id
                id = date+BusinessLogicUtil.formatByZero("0", ordinalLength);
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

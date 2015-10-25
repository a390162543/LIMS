package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.LoadVO;
import businesslogicservice.LoadblService;

public class LoadblService_Driver {
    public void drive(LoadblService loadblService){
        List<Long> orderList = new ArrayList<Long>();
        orderList.add(new Long("1010000101"));
        LoadVO vo = new LoadVO(new Long("025001150118000001"), new Date(), new Long("02500115101000000"), "南京市栖霞区中转中心", new Long("025001014"), "张三", "李四", orderList, 2.98);
        
        boolean createResult = loadblService.createLoadPO(vo);
        if(createResult == true)
            System.out.println("create succeed!");
        
        boolean modifyResult = loadblService.modifyLoadPO(vo);
        if(modifyResult == true)
            System.out.println("modify succeed!");
       
        boolean executeResult = loadblService.execute(vo);
        if(executeResult == true)
            System.out.println("execute succeed!");
        
    }
}
package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.LoadVO;
import businesslogicservice.LoadblService;

public class LoadblService_Driver {
    public void drive(LoadblService loadblService){
        List<String> orderList = new ArrayList<String>();
        orderList.add(new String("1010000101"));
        LoadVO vo = new LoadVO(new String("025001150118000001"), new Date(), new String("02500115101000000"), "�Ͼ�����ϼ����ת����", new String("025001014"), "����", "����", orderList, 2.98);
        
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
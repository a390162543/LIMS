package businesslogic.logbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.LogPO;
import dataservice.LogDataService;
import vo.LogVO;
import businesslogicservice.LogblService;

public class Log implements LogblService{

	@Override
	public boolean createLogPO(LogVO vo) {
        try {
            LogDataService lds = (LogDataService) Naming.lookup("rmi://localhost/LogData");
            lds.insert(vo.getLogPO());
        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        } catch (NotBoundException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public List<LogVO> queryLogVO(Date date) {
        List<LogVO> vos = new ArrayList<LogVO>();
        try {
        	LogDataService lds = (LogDataService) Naming.lookup("rmi://localhost/LogData");
            List<LogPO> pos = lds.finds("date", date);
            for(LogPO po : pos){
                vos.add(po.getLogVO());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (RemoteException e) {

            e.printStackTrace();
        } catch (NotBoundException e) {
  
            e.printStackTrace();
        }
        return vos;
	}

	@Override
	public String getLogInfo(LogVO vo) {
		String logInfo = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		logInfo = sdf.format(vo.getDate())+"   :   "+vo.getOpration()+" "+vo.getEmployeeId()+"("+vo.getEmployeeName()+")"+" "+vo.getOpration()+"\n";
		return logInfo;
	}

}

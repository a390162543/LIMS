package businesslogic.logbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.LogPO;
import dataservice.DataService;
import dataservice.LogDataService;
import vo.LogVO;
import businesslogic.userbl.LoginController;
import businesslogicservice.LogblService;

/**
 * {@code Log}是主要操作记录的业务逻辑的实现类，提供所有有关主要操作记录的业务逻辑服务
 * @author 刘德宽
 * @version 1.6
 * @see dataservice.LogDataService
 */
public class Log implements LogblService{

	private LogDataService logDataService;
	
	public Log(){
		logDataService = DataService.getLogDataService();
	}
	@Override
	public boolean createLogPO(String operation) {
        try {
        	LogVO vo = new LogVO(operation,LoginController.getEmployeeId(),LoginController.getEmployeeName(),LoginController.getPosition() );
        	logDataService.insert(vo.getLogPO());
        } catch (RemoteException e) {
        	
            e.printStackTrace();
        }
        return true;
	}

	@Override
	public List<LogVO> queryLogVO(Date date) {
        List<LogVO> vos = new ArrayList<LogVO>();
        try {
            List<LogPO> pos = logDataService.finds("date", date);
            for(LogPO po : pos){
                vos.add(po.getLogVO());
            }
        } catch (RemoteException e) {

            e.printStackTrace();
        }
        return vos;
	}

	@Override
	public String getLogInfo(LogVO vo) {
		String logInfo = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logInfo = sdf.format(vo.getDate())+":"+"\n"+vo.getEmployeePosition().getName()+vo.getEmployeeName()+"("+vo.getEmployeeId()+")"+" "+vo.getOpration()+"\n";
		return logInfo;
	}

}

package businesslogic.checkbl.loadinfo;

import systemenum.CheckResult;
import vo.TruckVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.truckbl.Truck;
import businesslogic.userbl.LoginController;

public class LoadDestination implements CheckInfo{
    
    private String truckId;
    private String destination;
    
    public LoadDestination(String truckId, String destination){
        this.truckId = truckId;
        this.destination = destination;
    }
    
    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        Truck truckbl = new Truck();
        TruckVO vo = truckbl.getTruckVOById(truckId);
        if(vo == null){
            checkResultMessage.addInfo(CheckResult.FALSE, "车辆信息不正确，请检查");
            return checkResultMessage;
        }else{
            String organization = vo.getOrganization();
            boolean equalsDestination = organization.equals(destination);
            boolean equalsDepart = organization.equals(LoginController.getOrganizationName());
            if(!(equalsDepart||equalsDestination)){
                checkResultMessage.addInfo(CheckResult.FALSE, "该地不在指定车辆的运输范围,请检查");
                return checkResultMessage;
            }
        }
        return checkResultMessage;
    }

}
